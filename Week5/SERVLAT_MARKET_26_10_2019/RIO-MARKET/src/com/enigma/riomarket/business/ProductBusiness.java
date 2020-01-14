package com.enigma.riomarket.business;

import java.util.ArrayList;
import java.util.List;

import com.enigma.riomarket.model.Product;

public class ProductBusiness {
		static public List<Product> ListProduct = new ArrayList<Product>();

		public static List<Product> getListProduct() {
			return ListProduct;
		}

		public static void setListProduct(List<Product> listProduct) {
			ListProduct = listProduct;
		}

		public static void addProduct(Product product) {
			ListProduct.add(product);
			
		}
		
		
}
