package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("posts")
public class PostsController {
	@GetMapping({"/", ""})
	public String getPosts() {
		return "posts/posts";
	}
	
	@GetMapping("{postId}")
	public String getPostById(
			@PathVariable("postId") Long id,
			Model model
			) {
		System.out.println("Post id: " + id);
		model.addAttribute("postId", id);
		return "posts/post-preview";
	}
	
	@GetMapping("{postId}/{userId}")
	public String getPostInfo(
			@PathVariable("postId") Long postId,
			@PathVariable("userId") Long userId,
			Model model
			) {
		model.addAttribute("postId", postId);
		model.addAttribute("userId", userId);
		return "posts/post-info";
	}
	
	@GetMapping("{postId}/{userId}/edit")
	public String getPostEdit(
			@PathVariable("postId") Long postId,
			@PathVariable("userId") Long userId,
			Model model
			) {
		model.addAttribute("postId", postId);
		model.addAttribute("userId", userId);
		return "posts/post-edit";
	}
	
	@PostMapping("{postId}/{userId}/edit")
	public String postPostEdit(
			@RequestParam(name = "title") String title,
			@RequestParam(name = "description") String description
			) {
		System.out.println("Title: " + title);
		System.out.println("Description: " + description);
		return "redirect:/posts";
	}
}
