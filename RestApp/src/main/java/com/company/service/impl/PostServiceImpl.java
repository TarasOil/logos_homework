package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.PostDTO;
import com.company.entity.Post;
import com.company.repository.PostRepository;
import com.company.service.PostService;
import com.company.service.utils.ObjectMapperUtils;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void savePost(PostDTO postDTO) {
		postRepository.save(modelMapper.map(postDTO, Post.class));
	}

	@Override
	public PostDTO findPostById(Long id) {
		return modelMapper.map(postRepository.findById(id).get(), PostDTO.class);
	}

	@Override
	public List<PostDTO> findAllPosts() {
		return modelMapper.mapAll(postRepository.findAll(), PostDTO.class);
	}

	@Override
	public PostDTO findByTitle(String title) {
		return modelMapper.map(postRepository.findByTitle(title), PostDTO.class);
	}

	@Override
	public List<PostDTO> findByUserId(Long id) {
		return modelMapper.mapAll(postRepository.findByUserId(id), PostDTO.class);
	}

	

	
	
}
