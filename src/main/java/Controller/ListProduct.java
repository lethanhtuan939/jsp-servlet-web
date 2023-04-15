package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODB;
import Entity.Product;

@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexP = request.getParameter("index");
		if(indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		
		DAODB dao = new DAODB();
		int count = dao.getTotalProduct();
		int endPage = count/5;
		
		if(count % 5 != 0) {
			endPage++;
		}
		
		List<Product> list = dao.pagingProduct(index);
		
		request.setAttribute("listP", list);
		request.setAttribute("endP", endPage);
		request.setAttribute("tag", index);
		request.getRequestDispatcher("/view/ListProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
