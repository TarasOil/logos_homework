package com.company.controller;

import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.PostDTO;
import com.company.entity.Post;
import com.company.service.PostService;

@RestController
@RequestMapping("posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody PostDTO postDTO) {
		postService.savePost(postDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getUsers() {
		List<PostDTO> postDTOs = postService.findAllPosts();
		return new ResponseEntity<List<PostDTO>>(postDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getUserById(@PathVariable("postId") Long id) {
		PostDTO post = postService.findPostById(id);
		return new ResponseEntity<PostDTO>(post, HttpStatus.OK);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<Void> editPost(@PathVariable("postId") Long id, @RequestBody PostDTO postDTO) {
		PostDTO post = postService.findPostById(id);
		if (post != null) {
			postDTO.setId(post.getId());
			postService.savePost(postDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/title")
	public ResponseEntity<PostDTO> getUserById(@RequestParam("title") String title) {
		return new ResponseEntity<PostDTO>(postService.findByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable("userId") Long id) {
		return new ResponseEntity<List<PostDTO>>(postService.findByUserId(id), HttpStatus.OK);
	}
}
