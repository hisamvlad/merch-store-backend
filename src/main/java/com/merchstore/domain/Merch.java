package com.merchstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Merch implements Serializable {
		private static final long serialVersionUID = 353252L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		private String name;
		private String brand;
		private String manufacturer;
		private double shippingWeight;
		private int listPrice;
		private int discountedPrice;
		private boolean active = true;
		private int inStockNumber;
		
		@Column(columnDefinition="text")
		private String description;
		
		@Transient
		private MultipartFile merchImage;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public double getShippingWeight() {
			return shippingWeight;
		}

		public void setShippingWeight(double shippingWeight) {
			this.shippingWeight = shippingWeight;
		}

		public int getListPrice() {
			return listPrice;
		}

		public void setListPrice(int listPrice) {
			this.listPrice = listPrice;
		}

		public int getDiscountedPrice() {
			return discountedPrice;
		}

		public void setDiscountedPrice(int discountedPrice) {
			this.discountedPrice = discountedPrice;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public int getInStockNumber() {
			return inStockNumber;
		}

		public void setInStockNumber(int inStockNumber) {
			this.inStockNumber = inStockNumber;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public MultipartFile getMerchImage() {
			return merchImage;
		}

		public void setMerchImage(MultipartFile merchImage) {
			this.merchImage = merchImage;
		}
		
		
}
