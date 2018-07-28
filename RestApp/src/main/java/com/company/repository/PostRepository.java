package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}