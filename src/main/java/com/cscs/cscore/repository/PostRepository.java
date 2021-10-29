package com.cscs.cscore.repository;

import com.cscs.cscore.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
