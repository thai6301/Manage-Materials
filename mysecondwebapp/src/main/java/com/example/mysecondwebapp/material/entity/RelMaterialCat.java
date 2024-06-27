package com.example.mysecondwebapp.material.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RelMaterialCat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int relMaterialCatId;

    @Column(nullable = false)
    private int materialId;

    @Column(nullable = false)
    private int materialCatId;
    
    public RelMaterialCat() {
    	
    }

	public RelMaterialCat(int relMaterialCatId, int materialId, int materialCatId) {
		super();
		this.relMaterialCatId = relMaterialCatId;
		this.materialId = materialId;
		this.materialCatId = materialCatId;
	}

	public int getRelMaterialCatId() {
		return relMaterialCatId;
	}

	public void setRelMaterialCatId(int relMaterialCatId) {
		this.relMaterialCatId = relMaterialCatId;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getMaterialCatId() {
		return materialCatId;
	}

	public void setMaterialCatId(int materialCatId) {
		this.materialCatId = materialCatId;
	}

	@Override
	public String toString() {
		return "RelMaterialCat [relMaterialCatId=" + relMaterialCatId + ", materialId=" + materialId
				+ ", materialCatId=" + materialCatId + "]";
	}
    
    
}
