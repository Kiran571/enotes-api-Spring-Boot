package com.example.demo.dto;
/*
 * Class is middleware between Category class and other controller.
 * 
 * 
 * 
 * */

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	
	private Integer id;
	
	private String name;
	
	private String description;
	
	
	private Boolean isActive;
	
	
	private Boolean isDeleted;
	
	private Integer createdBy;
	
	private Date createdOn;
	
	private Integer updatedBy;
	
	@Column(name="updated_on")
	private Date updatedDate;
	
}
