package com.BlogAppApis.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogAppApis.exception.ResourceNotFoundException;
import com.BlogAppApis.model.Comment;
import com.BlogAppApis.model.Post;
import com.BlogAppApis.payload.CommentDto;
import com.BlogAppApis.repo.CommentRepo;
import com.BlogAppApis.repo.PostRepo;
import com.BlogAppApis.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("post", "post id", postId));
        Comment comment = this.mapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment saveComment = this.commentRepo.save(comment);
        return this.mapper.map(saveComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
        this.commentRepo.delete(com);
    }

    @Override
    public CommentDto getCommentById(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
        return this.mapper.map(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = this.commentRepo.findAll();
        List<CommentDto> commentDtos = comments.stream().map((comment) -> this.mapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
        return commentDtos;
    }

}
