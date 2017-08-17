//package com.model;
//
//import java.io.Serializable;
//import java.util.*;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//@Entity
//@Table(name="Category")
//
//
//
//public class Category 
//{
//    @Id
//    private int cid;
//	private String name;
//
//	@OneToMany(targetEntity=Product.class, fetch=FetchType.LAZY, mappedBy="category")
//    private Set<Product> products = new HashSet<Product>(0);
//	
//	
//
//	public int getCid() {
//		return cid;
//	}
//
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//
//    public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}
//}
