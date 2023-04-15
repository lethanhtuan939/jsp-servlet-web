package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODB;
import Entity.Category;
import Entity.Product;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// b1 get data from dao
		DAODB dao = new DAODB();
		List<Product> list = dao.getTop3();
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLastestProduct();
		
		// b2 set data to jsp
		request.setAttribute("listP", list);
		request.setAttribute("listC", listC);
		request.setAttribute("lastestProcduct", last);
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
