package com.example.mysecondwebapp.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaterialType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    @Column(nullable = false, length = 45)
    private String type;
    
    public MaterialType() {
    	
    }

	public MaterialType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MaterialType [typeId=" + typeId + ", type=" + type + "]";
	}
}
