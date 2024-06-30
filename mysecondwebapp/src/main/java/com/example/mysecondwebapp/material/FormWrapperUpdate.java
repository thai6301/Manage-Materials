package com.example.mysecondwebapp.material;

import com.example.mysecondwebapp.material.entity.Material;
import com.example.mysecondwebapp.material.entity.MaterialCategory;
import com.example.mysecondwebapp.material.entity.RelMaterialCat;

public class FormWrapperUpdate {
	private Material material;
	private MaterialCategory materialCategory;
	private RelMaterialCat relMaterialCat;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public MaterialCategory getMaterialCategory() {
		return materialCategory;
	}

	public void setMaterialCategory(MaterialCategory materialCategory) {
		this.materialCategory = materialCategory;
	}

	public RelMaterialCat getRelMaterialCat() {
		return relMaterialCat;
	}

	public void setRelMaterialCat(RelMaterialCat relMaterialCat) {
		this.relMaterialCat = relMaterialCat;
	}

}
