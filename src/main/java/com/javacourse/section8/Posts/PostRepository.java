package com.javacourse.section8.Posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    public List<Post> findAllByAddedByUser(Integer userId);
}
