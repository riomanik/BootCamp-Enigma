package com.enigma.mahasiswa.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.enigma.mahasiswa.business.MahasiswaBusiness;
import com.enigma.mahasiswa.model.Mahasiswa;

/**
 * Servlet implementation class MahasiswaServlet
 */
@WebServlet("/MahasiswaServlet")
public class MahasiswaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MahasiswaServlet() {
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
			List<Mahasiswa> ListMhs = MahasiswaBusiness.getListMhs();
			request.setAttribute("listMhs", ListMhs);
			request.getRequestDispatcher("/WEB-INF/views/mahasiswa.jsp").forward(request, response);	
		} else{response.sendRedirect("/Mahasiswa");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MahasiswaId = request.getParameter("MahasiswaId");
		String MahasiswaName = request.getParameter("MahasiswaName");
		
		if (request.getParameter("idDel") != null) {
			String idDel = request.getParameter("idDel");
			MahasiswaBusiness.delMahasiswa(idDel);
		} else if(request.getParameter("UpdtPr") != null && request.getParameter("UpdtId") != null && request.getParameter("UpdtName") != null){
			Integer IdPrimary = Integer.parseInt(request.getParameter("UpdtPr"));
			String UpdtId = request.getParameter("UpdtId");
			String UpdtName = request.getParameter("UpdtName");
			MahasiswaBusiness.updMahasiswa(IdPrimary, UpdtId, UpdtName);
		}else if(MahasiswaId != null && MahasiswaName != null){
		MahasiswaBusiness.addMahasiswa(new Mahasiswa(MahasiswaId,MahasiswaName));
//		response.sendRedirect("MahasiswaServlet");
		}
		response.sendRedirect("MahasiswaServlet");
		
	}

}
