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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String txtSearch = request.getParameter("searchTxt");
		DAODB dao = new DAODB();
		List<Product> listSearch = dao.searchByName(txtSearch);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLastestProduct();
		
		request.setAttribute("listP", listSearch);
		request.setAttribute("listC", listC);
		request.setAttribute("lastestProcduct", last);
		request.setAttribute("txtSearch", txtSearch);
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
		
		// chua foreach san pham (chua co data)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
