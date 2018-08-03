package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.CommentDTO;
import com.company.entity.Comment;
import com.company.repository.CommentRepository;
import com.company.service.CommentService;
import com.company.service.utils.ObjectMapperUtils;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveComment(CommentDTO commentDTO) {
		commentRepository.save(modelMapper.map(commentDTO, Comment.class));
	}

	@Override
	public CommentDTO findById(Long id) {
		return modelMapper.map(commentRepository.findById(id).get(), CommentDTO.class);
	}

	@Override
	public List<CommentDTO> findAllComments() {
		return modelMapper.mapAll(commentRepository.findAll(), CommentDTO.class);
	}
}
