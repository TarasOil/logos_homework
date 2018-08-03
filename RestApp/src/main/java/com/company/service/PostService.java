package com.company.service;

import java.util.List;

import com.company.domain.PostDTO;
import com.company.entity.Post;

public interface PostService {
	
	void savePost(PostDTO postDTO);
	
	PostDTO findPostById(Long id);
	
	List<PostDTO> findAllPosts();
	
	PostDTO findByTitle(String title);
	
	List<PostDTO> findByUserId(Long id);
}
