package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Post findByTitle(String title);
	List<Post> findByUserId(Long id);
}
