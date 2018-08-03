package com.company.domain;

import java.util.List;

import com.company.domain.PostDTO.PostDTOBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private int age;
//	private List<PostDTO> posts;
}
