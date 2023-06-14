package com.BlogAppApis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogAppApis.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
