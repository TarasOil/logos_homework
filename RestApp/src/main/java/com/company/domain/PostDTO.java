package com.company.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

	private Long id;
	private String title;
	private String description;
	private UserDTO user;
//	private List<CommentDTO> comments; 
}
