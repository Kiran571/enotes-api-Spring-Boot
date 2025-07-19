package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponse;
import com.example.demo.entity.BaseModel;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
		
		
		Boolean saveCategory = categoryService.saveCategory(categoryDto);
		if(saveCategory) {

			
			return new ResponseEntity<>("Saved Successfully",HttpStatus.CREATED);
		}
		else return new ResponseEntity<>("Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategory(){
		
		List<CategoryDto> allCategoriesList = categoryService.getAllCategory();
		if(!allCategoriesList.isEmpty()) { //CollectionUtils.isEmpty()
			return new ResponseEntity<>(allCategoriesList, HttpStatus.OK);
		}
		
		else return ResponseEntity.noContent().build();
		
	}

	@GetMapping("/active-category")
	public ResponseEntity<?> getActiveCategory(){
		
		List<CategoryResponse> activeCategoriesList = categoryService.getActiveCategory();
		if(!activeCategoriesList.isEmpty()) { //CollectionUtils.isEmpty()
			return new ResponseEntity<>(activeCategoriesList, HttpStatus.OK);
		}
		
		else return ResponseEntity.noContent().build();
		
	}
	
	
}
