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

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		
		DAODB dao = new DAODB();
		Product product = dao.getProductByID(id);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLastestProduct();
		
		request.setAttribute("detail", product);
		request.setAttribute("listC", listC);
		request.setAttribute("lastestProcduct", last);
		request.getRequestDispatcher("/view/Detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
