package com.example.mysecondwebapp.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysecondwebapp.material.entity.MaterialItem;

public interface MaterialItemRepository extends JpaRepository<MaterialItem, Integer> {

}
