package com.example.mysecondwebapp.material;

import com.example.mysecondwebapp.material.entity.Material;
import com.example.mysecondwebapp.material.entity.RelMaterialCat;

public class FormWrapperUpdate {
	private Material material;
	private Integer materialCatIdOfSelectedCategory;
	private RelMaterialCat relMaterialCat;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getMaterialCatIdOfSelectedCategory() {
		return materialCatIdOfSelectedCategory;
	}

	public void setMaterialCatIdOfSelectedCategory(Integer materialCatIdOfSelectedCategory) {
		this.materialCatIdOfSelectedCategory = materialCatIdOfSelectedCategory;
	}

	public RelMaterialCat getRelMaterialCat() {
		return relMaterialCat;
	}

	public void setRelMaterialCat(RelMaterialCat relMaterialCat) {
		this.relMaterialCat = relMaterialCat;
	}

}
