package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Post;
import com.company.service.PostService;

@RestController
@RequestMapping("posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody Post post) {
		postService.savePost(post);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Post> getUserById(@PathVariable("postId") Long id) {
		Post post = postService.findPostById(id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> getUsers() {
		List<Post> posts = postService.findAllPosts();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
}
