package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODB;
import Entity.Account;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String rePass = request.getParameter("repass");
		if(!(password.equals(rePass))) {
			response.sendRedirect("/Project_Sale_Servlet/view/Login.jsp");
		} else {
			DAODB dao = new DAODB();
			Account acc = dao.checkAccountExist(username);
			if(acc == null) {
				// acept sign up
				dao.signup(username, password);
				response.sendRedirect("HomeServlet");
				
			} else {
				response.sendRedirect("/Project_Sale_Servlet/view/Login.jsp");
			}
		}
		// sign up
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
