package com.BlogAppApis.service;

import java.util.List;

import com.BlogAppApis.payload.PostDto;
import com.BlogAppApis.payload.PostResponse;
import com.BlogAppApis.repo.PostRepo;

public interface PostService {

    // Create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update post
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete post
    void deletePost(Integer postId);

    // Get single post
    PostDto getPostById(Integer postId);

    // Get all post
    // List<PostDto> getAllPost();
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // Get all post using Pageable
    // List<PostDto> getAllPostUsingPageable(Integer pageSize,Integer pageNumber);
    // PostResponse getAllPostUsingPageable(Integer pageSize, Integer pageNumber,
    // String sortBy, String sortDir);

    // Get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);
    // public PostRepo getAllPostByCategory(Integer categoryId, Integer pageNumber,
    // Integer pageSize);

    // Get all post by user
    List<PostDto> getPostByUser(Integer userId);
    // public PostRepo getPostByUser(Integer userId, Integer pageNumber, Integer
    // PageSize);

    // Search post
    List<PostDto> searchPosts(String keyword);

}
