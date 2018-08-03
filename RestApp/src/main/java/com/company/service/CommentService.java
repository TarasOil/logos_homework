package com.company.service;

import java.util.List;

import com.company.domain.CommentDTO;

public interface CommentService {
	
	void saveComment(CommentDTO commentDTO);
	
	List<CommentDTO> findAllComments();
	
	CommentDTO findById(Long id);
}