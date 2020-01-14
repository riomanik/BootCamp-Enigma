package com.enigma.hellostore.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigma.hellostore.busines.ProductBusiness;
import com.enigma.hellostore.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie[] cookies = request.getCookies();
		Cookie existingCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("session")) {
				existingCookie = cookie;
			}
		}
		if (existingCookie != null) {
			existingCookie.setMaxAge(120);
			List<Product> productList = ProductBusiness.getProduct();
			request.setAttribute("products", productList);
			request.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(request, response);	
		} else{response.sendRedirect("/GO-STORE");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String productName = request.getParameter("productName");
		String productId = request.getParameter("productId");
		
		ProductBusiness.addProduct(new Product(productId,productName));
		response.sendRedirect("ProductServlet");
		
		
	}

}
