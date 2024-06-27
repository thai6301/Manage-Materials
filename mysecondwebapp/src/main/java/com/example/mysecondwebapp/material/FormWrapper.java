package com.example.mysecondwebapp.material;

import java.util.List;

import com.example.mysecondwebapp.material.entity.Material;

public class FormWrapper {
	private Material material;
	private List<String> selectedCategory;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<String> getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(List<String> selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

}
