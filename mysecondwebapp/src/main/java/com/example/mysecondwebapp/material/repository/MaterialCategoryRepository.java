package com.example.mysecondwebapp.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysecondwebapp.material.entity.MaterialCategory;

public interface MaterialCategoryRepository extends JpaRepository<MaterialCategory, Integer> {

	public MaterialCategory findByCategory(String category);


}
