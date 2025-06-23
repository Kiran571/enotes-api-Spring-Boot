package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	

}
