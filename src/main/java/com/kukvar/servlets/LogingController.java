package com.kukvar.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kukvar.hibernate.DAO.UsersDAO;
import com.kukvar.hibernate.entity.Customers;
import com.kukvar.model.User;

import java.io.IOException;

@WebServlet("/login")
public class LogingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "logout" :
				logout(request,response);
				break;
			case "login" :
				response.sendRedirect("login.jsp");
				break;
			case "register" :
				response.sendRedirect("register.jsp");
				break;
			case "sign_with_google": {
				response.sendRedirect("login.jsp");
				break;
			}
			default:
				homePage(request,response);
			}			
		} catch (Exception e) {
			errorPage(request,response);
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Logout handler... new session...as guest...");
		request.getSession().invalidate();	
		HttpSession newSession = request.getSession(true);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "register": {
			register(request,response);
			break;
		}		
		case "loginSubmit": {
			authenticate(request,response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("new Customer : "+name+", "+email);
		Customers customer = new Customers( email, name, password);
			try {
				new UsersDAO().addCustomersDetails(customer);
				authenticate(request,response);
			} catch (Exception e) {
				System.out.println(e.toString());
				response.sendRedirect("login.jsp");
			}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String username = request.getParameter("username");
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");
		
		if(! new UsersDAO().isExisted(email)) {
			response.sendRedirect("login.jsp");
		} else {
			//Invalidating session if any
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			//newSession.setAttribute("username", username);
			newSession.setAttribute("email", email);
			User user = new User(email);

			newSession.setAttribute("User",user);
			response.sendRedirect("about.jsp");		
		}		
	}
	
	protected void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("title", "Home page");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}		
	
}




