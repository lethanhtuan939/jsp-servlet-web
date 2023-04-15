package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAODB;
import Entity.Account;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay user password tu cookie
		Cookie cookie[] = request.getCookies();
		if(cookie != null) {
			for(Cookie o : cookie) {
				if(o.getName().equals("userC")) {
					request.setAttribute("user", o.getValue());
				}
				if(o.getName().equals("passC")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		
		request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		DAODB dao = new DAODB();
		Account acc = dao.login(username, password);
		if(acc == null) {
			request.setAttribute("message", "User or password is invalid");
			request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
		} else {
//			dung requestDipatcher khi chuyen trang co kem theo du lieu
//			request.getRequestDispatcher("HomeServlet").forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("acc", acc);
//			ko kem theo du lieu
			
			// luu len cookie
			Cookie u = new Cookie("userC", username);
			Cookie p = new Cookie("passC", password);
			
			u.setMaxAge(1000);
			
			if(remember != null) {				
				p.setMaxAge(1000);
			} else {
				p.setMaxAge(0);
			}
			response.addCookie(u);
			response.addCookie(p);
			
			response.sendRedirect("HomeServlet");
		}
	}

}
