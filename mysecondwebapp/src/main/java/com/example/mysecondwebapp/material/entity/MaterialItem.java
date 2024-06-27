package com.example.mysecondwebapp.material.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaterialItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	@Column(nullable = false)
	private int materialId;

	@Column(nullable = false)
	private int officeId;

	@Column(nullable = false, length = 45)
	private String publishVer;

	@Column(nullable = false)
	private int pages;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	private int itemStatusId;

	@Column(nullable = false)
	private int lendableStatus;

	@Column(length = 45)
	private String damageReason;

	@Column(nullable = false, length = 45)
	private String editedUserId;

	@Column(nullable = false)
	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;

	public MaterialItem() {

	}

	public MaterialItem(int itemId, int materialId, int officeId, String publishVer, int pages, int price,
			int itemStatusId, int lendableStatus, String damageReason, String editedUserId, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.itemId = itemId;
		this.materialId = materialId;
		this.officeId = officeId;
		this.publishVer = publishVer;
		this.pages = pages;
		this.price = price;
		this.itemStatusId = itemStatusId;
		this.lendableStatus = lendableStatus;
		this.damageReason = damageReason;
		this.editedUserId = editedUserId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getPublishVer() {
		return publishVer;
	}

	public void setPublishVer(String publishVer) {
		this.publishVer = publishVer;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getItemStatusId() {
		return itemStatusId;
	}

	public void setItemStatusId(int itemStatusId) {
		this.itemStatusId = itemStatusId;
	}

	public int getLendableStatus() {
		return lendableStatus;
	}

	public void setLendableStatus(int lendableStatus) {
		this.lendableStatus = lendableStatus;
	}

	public String getDamageReason() {
		return damageReason;
	}

	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	public String getEditedUserId() {
		return editedUserId;
	}

	public void setEditedUserId(String editedUserId) {
		this.editedUserId = editedUserId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "MaterialItem [itemId=" + itemId + ", materialId=" + materialId + ", officeId=" + officeId
				+ ", publishVer=" + publishVer + ", pages=" + pages + ", price=" + price + ", itemStatusId="
				+ itemStatusId + ", lendableStatus=" + lendableStatus + ", damageReason=" + damageReason
				+ ", editedUserId=" + editedUserId + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
}
