package com.company.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "post")
//@ToString(callSuper = true, exclude = {"user", "comments"})
public class Post extends BaseEntity {
	
	private String title;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

//	@OneToMany(mappedBy = "post")
//	private List<Comment> comments;
}
