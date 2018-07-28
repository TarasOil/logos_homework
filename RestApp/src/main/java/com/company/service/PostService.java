package com.company.service;

import java.util.List;

import com.company.entity.Post;

public interface PostService {
	
	void savePost(Post post);
	
	Post findPostById(Long id);
	
	List<Post> findAllPosts();
}
