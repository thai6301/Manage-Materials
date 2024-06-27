package com.example.mysecondwebapp.material.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Material.findMaterialDetails",
query = "SELECT m.materialId, mt.type, mc.category, m.name, m.author, m.description " +
        "FROM Material m " +
        "INNER JOIN RelMaterialCat rel ON m.materialId = rel.materialId " +
        "INNER JOIN MaterialCategory mc ON rel.materialCatId = mc.materialCatId " +
        "INNER JOIN MaterialType mt ON m.typeId = mt.typeId")
public class Material {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int materialId;

    @Column(nullable = false)
    private int typeId;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 45)
    private String author;

    @Column(length = 45)
    private String publisher;

    private LocalDate firstPublishDate;

    @Column(length = 45)
    private String note;
    
    @Column(length = 255)
    private String description;

    @Column(nullable = true)
    private LocalDate createdDate;

    private LocalDate updatedDate;

    @Column(nullable = true)
    private Integer updatedUserId;

    @Column(nullable = true)
    private Boolean deleteFlag;
    
    public Material() {
    	
    }

	public Material(int materialId, int typeId, String name, String author, String publisher,
			LocalDate firstPublishDate, String note, String description, LocalDate createdDate, LocalDate updatedDate,
			Integer updatedUserId, Boolean deleteFlag) {
		super();
		this.materialId = materialId;
		this.typeId = typeId;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.firstPublishDate = firstPublishDate;
		this.note = note;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.updatedUserId = updatedUserId;
		this.deleteFlag = deleteFlag;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getFirstPublishDate() {
		return firstPublishDate;
	}

	public void setFirstPublishDate(LocalDate firstPublishDate) {
		this.firstPublishDate = firstPublishDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", typeId=" + typeId + ", name=" + name + ", author=" + author
				+ ", publisher=" + publisher + ", firstPublishDate=" + firstPublishDate + ", note=" + note
				+ ", description=" + description + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", updatedUserId=" + updatedUserId + ", deleteFlag=" + deleteFlag + "]";
	}

	

	
	}


