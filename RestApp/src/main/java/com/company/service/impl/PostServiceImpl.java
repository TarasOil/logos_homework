package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Post;
import com.company.repository.PostRepository;
import com.company.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void savePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public Post findPostById(Long id) {
		return postRepository.getOne(id);
	}

	@Override
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}

	
	
}
