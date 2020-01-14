package com.enigma.riomarket.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigma.riomarket.business.ProductBusiness;
import com.enigma.riomarket.model.Product;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie existingCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("session")) {
				existingCookie = cookie;
			}
		}
		if (existingCookie != null) {
			existingCookie.setMaxAge(10);
			request.getRequestDispatcher("WEB-INF/views/product.jsp").forward(request, response);
		} else {
			response.sendRedirect("/RIO-MARKET");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("productId");
		String productName = request.getParameter("nameProduct");
		ProductBusiness.addProduct(new Product(productId, productName));
		response.sendRedirect("ProductServlet");

	}

}
