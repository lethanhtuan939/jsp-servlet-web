package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODB;
import Entity.Product;

@WebServlet("/LoadMoreServlet")
public class LoadMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		DAODB dao = new DAODB();
		
		String amount = request.getParameter("exist");
		int iamount = Integer.parseInt(amount);
		List<Product> list = dao.getNext3Product(iamount);
		
		PrintWriter out = response.getWriter();
		
		for(Product o : list) {
			out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\r\n"
					+ "							<div class=\"card\">\r\n"
					+ "								<img class=\"card-img-top\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\r\n"
					+ "								<div class=\"card-body\">\r\n"
					+ "									<h4 class=\"card-title show_txt\">\r\n"
					+ "										<a href=\"DetailServlet?pid=\""+o.getId()+"\"\" title=\"View Product\">"+ o.getName()+"</a>\r\n"
					+ "									</h4>\r\n"
					+ "									<p class=\"card-text show_txt\">" + o.getTitle() +"</p>\r\n"
					+ "									<div class=\"row\">\r\n"
					+ "										<div class=\"col\">\r\n"
					+ "											<p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\r\n"
					+ "										</div>\r\n"
					+ "										<div class=\"col\">\r\n"
					+ "											<a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
