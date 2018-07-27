package ua.logos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("users")
public class UsersController {
	
	@GetMapping({"/", ""})
	public String showUsers() {
		return "users/users";
	}
	
	@GetMapping("{userId}")
	public String getUserById(
			@PathVariable("userId") Long id,
			@RequestParam(name = "name", required = false) String name,
			Model model
			) {
		System.out.println("User's id: " + id);
		System.out.println("User's name: " + name);
		
		model.addAttribute("userId", id);
		model.addAttribute("userName", name);
		
		return "users/profile";
	}
	
	@GetMapping("{userId}/edit")
	public String editUser(
			@PathVariable("userId") Long id,
			Model model
			) {
		model.addAttribute("userId", id);
		return "users/edit-user";
	}
	
	@PostMapping("{userId}/edit")
	public String postEditUser(
			@RequestParam("username") String name
			) {
		System.out.println("New usernamename: " + name);
		
		return "redirect:/users";
	}
	
	@GetMapping("{userId}/delete")
	public String deleteUser(
			@PathVariable("userId") Long id
			) {
		System.out.println("User with id = " + id + ", has been deleted");
		return "redirect:/users";
	}
}
