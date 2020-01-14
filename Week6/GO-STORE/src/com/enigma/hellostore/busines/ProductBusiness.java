package com.enigma.hellostore.busines;

import java.util.ArrayList;
import java.util.List;

import com.enigma.hellostore.model.Product;

public class ProductBusiness {
	
	
	
	static public List<Product> product = new ArrayList<Product>();

	public static List<Product> getProduct() {
		return product;
	}

//	public static void setProduct(List<Product> product) {
//		ProductBusiness.product = product;
//	}

	public static void addProduct(Product product2) {
		// TODO Auto-generated method stub
		product.add(product2);
	}



	
	
	
}
