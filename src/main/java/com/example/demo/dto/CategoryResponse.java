/**
 * 
 */
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

	private Integer id;
	
	private String name;
	
	private String descriptions;
	
}
