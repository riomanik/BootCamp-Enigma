package com.enigma.riomarket.model;

public class Product {
		String productid;
		String productname;
		
		
		public Product(String productid, String productname) {
			super();
			this.productid = productid;
			this.productname = productname;
		}
		
		
		public String getProductid() {
			return productid;
		}
		public void setProductid(String productid) {
			this.productid = productid;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}


		@Override
		public String toString() {
			return "Product [productid=" + productid + ", productname=" + productname + "]";
		}
		
		
		
}
