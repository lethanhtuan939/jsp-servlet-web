package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import DAO.DAODB;
import Entity.Account;
import Entity.Product;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		int sid = acc.getId();
		
		Product product = new Product(name, image, price, title, description);
		
		DAODB dao = new DAODB();
		dao.insertProduct(product, category, sid);
		response.sendRedirect("ManagerProductServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
