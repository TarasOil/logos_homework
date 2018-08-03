package com.company.controller;

import com.company.domain.CommentDTO;
import com.company.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{commentId}")
	public ResponseEntity<CommentDTO> getCommentById(@PathVariable("commentId") Long id) {
		CommentDTO comment = commentService.findById(id);
		return new ResponseEntity<CommentDTO>(comment, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CommentDTO>> getComments() {
		return new ResponseEntity<List<CommentDTO>>(commentService.findAllComments(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addComment(@RequestBody CommentDTO commentDto) {
		commentService.saveComment(commentDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{commentId}")
	public ResponseEntity<Void> editComment(@PathVariable("commentId") Long id, 
			@RequestParam(required = true, name = "userId") Long userId, 
			@RequestBody CommentDTO commentDto) {
		CommentDTO comment = commentService.findById(id);
		if (comment != null && comment.getUser().getId() == userId) {
			commentDto.setId(comment.getId());
			commentService.saveComment(commentDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
