package com.example.mysecondwebapp.material;

import java.util.List;

public class FormWrapper {
	private Material material;
	private List<String> selectedMaterialCatIds;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<String> getSelectedMaterialCatIds() {
		return selectedMaterialCatIds;
	}

	public void setSelectedMaterialCatIds(List<String> selectedMaterialCatIds) {
		this.selectedMaterialCatIds = selectedMaterialCatIds;
	}

}
