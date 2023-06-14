package com.BlogAppApis.repo;

import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BlogAppApis.model.Category;
import com.BlogAppApis.model.Post;
import com.BlogAppApis.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

    // Custom finder method to find users post
    List<Post> findByUser(User user);
    // Page<Post> findByUser(Integer userId, Pageable pageable);

    List<Post> findByCategory(Category category);
    // Page<Post> findByCategory(Integer userId, Pageable pageable);

    // List<Post> findByTitleContaining(String title);
    @Query("select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);
}
