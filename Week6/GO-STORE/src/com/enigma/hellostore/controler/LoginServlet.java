package com.enigma.hellostore.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().print("<html>");
//		response.getWriter().print("<body>");
//		response.getWriter().print("Hello");
//		response.getWriter().print("</body>");
//		response.getWriter().print("</html>");
//		response.getWriter().flush();
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
//		System.out.println(userName+" "+userPassword);
		if (userName.equals("123") && userPassword.equals("123")) {
			Cookie userCookie = new Cookie("session", "abcdefg");
			userCookie.setMaxAge(10);
			response.addCookie(userCookie);
			response.sendRedirect("ProductServlet");
		}else {
			response.sendRedirect("/GO-STORE");
		}
	}
	

}
