package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService  {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	@Override
	public Boolean saveCategory(Category category) {
		Category savedCategory = categoryRepository.save(category);
		if (ObjectUtils.isEmpty(savedCategory)){
			return false;
		}
		return true;
	
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategoriesList = categoryRepository.findAll();
		return null;
	}

}
