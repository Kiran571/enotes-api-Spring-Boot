package com.example.demo.service.impl;

import lombok.*;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponse;
import com.example.demo.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {

		Category category = mapper.map(categoryDto, Category.class);

		/*
		 * Category category = new Category(); category.setName(categoryDto.getName());
		 * category.setDescription(categoryDto.getDescription());
		 * category.setIsActive(categoryDto.getIsActive());
		 * category.setCreatedBy(categoryDto.getCreatedBy());
		 */
		/*
		 * this also valid : category.setIsDeleted(category.getIsActive());
		 */

		
		 category.setIsDeleted(categoryDto.getIsActive()); 
		 category.setCreatedOn(new Date());
		 category.setCreatedBy(1);

		
		Category savedCategory = categoryRepository.save(category);

		if (ObjectUtils.isEmpty(savedCategory)) {
			return false;
		}
		return true;

	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategoriesList = categoryRepository.findAll();
		
		/*Converting to dto(middleware to pass btw Model and controller)*/
		
		List<CategoryDto> allCategoriesDtoList = allCategoriesList.stream().map(categ->mapper.map(categ, CategoryDto.class)).toList();
		
		
		return allCategoriesDtoList;
	}
	
	

	@Override
	public List<CategoryResponse> getActiveCategory(){
		
		List<Category> activeCategoriesList = categoryRepository.findByIsActiveTrue();
		
		List<CategoryResponse> activeList = activeCategoriesList.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
		
		
		return activeList;
	}
	
	@Override
	public CategoryDto getCategoryById(Integer id) {
		Optional<Category> findByCategory = categoryRepository.findById(id);
		if(findByCategory.isPresent()) {
			Category category=findByCategory.get();
			return mapper.map(category, CategoryDto.class);
		}
		return null;
		
	}
	

}
