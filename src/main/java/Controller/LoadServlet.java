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

@WebServlet("/loadProduct")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		DAODB dao = new DAODB();
		Product p = dao.getProductByID(id);
		List<Category> listC = dao.getAllCategory();

        request.setAttribute("listC", listC);
		request.setAttribute("detail", p);
		request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
