package com.BlogAppApis.service;

import java.util.List;

import com.BlogAppApis.payload.CommentDto;

public interface CommentService {

    // Create
    CommentDto createComment(CommentDto commentDto, Integer postId);

    // Delete
    void deleteComment(Integer commentId);

    // Get single comment
    CommentDto getCommentById(Integer commentId);

    // Get multiple comments
    List<CommentDto> getAllComments();

}
