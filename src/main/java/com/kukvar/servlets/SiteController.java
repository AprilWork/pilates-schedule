package com.kukvar.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kukvar.hibernate.DAO.GroupsDAO;
import com.kukvar.hibernate.entity.Group;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public String path = "c:/images/"; 
	public String assetsImagePath = "assets/img/uploaded/";
	public String realPath = "C:/Users/irade/git/Booking/pilates/src/main/webapp/";
	public String path = "C:/Users/irade/git/Booking/pilates/src/main/webapp/assets/img/uploaded/";
     
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {

		switch (action) {
		case "home" :
			homePage(request,response);
			break;
		case "about": {
			about(request, response);
			break;
		}
		case "viewGroups": {
			viewGroups(request, response);
			break;
		}	
		case "contact": {
			contact(request, response);
			break;
		}		
		default:
			homePage(request,response);
		}
		} catch (Exception e) {
			errorPage(request,response);
		}	
	}

	private void handler(HttpServletRequest request, HttpServletResponse response, String action)
			throws ServletException, IOException {
		try {

		switch (action) {
		case "home" :
			homePage(request,response);
			break;
		case "about": {
			about(request, response);
			break;
		}
		case "viewGroups": {
			viewGroups(request, response);
			break;
		}	
		case "contact": {
			contact(request, response);
			break;
		}		
		default:
			homePage(request,response);
		}
		} catch (Exception e) {
			errorPage(request,response);
		}
	}
	
	private void about(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("about.jsp").forward(request, response);
	}

	private void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("contact.jsp").forward(request, response);
		
	}

	private void viewGroups(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Group> groups = new GroupsDAO().listGroups();
		request.setAttribute("groups", groups);
		request.setAttribute("path", assetsImagePath);
		request.getRequestDispatcher("listGroups.jsp").forward(request, response);
	}	
	
	protected void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("title", "Home page");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("title", "Error page");
		//request.setAttribute("Answer", "search");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}	

}
