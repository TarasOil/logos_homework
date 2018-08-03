package com.company.domain;

import com.company.domain.PostDTO.PostDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
	
	private Long id;
	private String title;
	private String message;
	private PostDTO post;
	private UserDTO user;
}
