package com.example.mysecondwebapp.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaterialCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialCatId;

	@Column(nullable = false, length = 45)
	private String category;

	public MaterialCategory() {

	}

	public MaterialCategory(int materialCatId, String category) {
		super();
		this.materialCatId = materialCatId;
		this.category = category;
	}

	public int getMaterialCatId() {
		return materialCatId;
	}

	public void setMaterialCatId(int materialCatId) {
		this.materialCatId = materialCatId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MaterialCategory [materialCatId=" + materialCatId + ", category=" + category + "]";
	}

}
