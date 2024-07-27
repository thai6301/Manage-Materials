package com.example.mysecondwebapp.material;

import java.util.List;

import com.example.mysecondwebapp.material.entity.Material;

public class FormWrapper {
	private Material material;
	private List<Integer> selectedCategory;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<Integer> getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(List<Integer> selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

}
