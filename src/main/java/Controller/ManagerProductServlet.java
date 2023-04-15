package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAODB;
import Entity.Account;
import Entity.Category;
import Entity.Product;

@WebServlet("/ManagerProductServlet")
public class ManagerProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        int id = acc.getId();
        DAODB dao = new DAODB();
        List<Product> list = dao.getProductBySellID(id);
        List<Category> listC = dao.getAllCategory();

        request.setAttribute("listC", listC);
        request.setAttribute("listP", list);
		request.getRequestDispatcher("/view/ManagerProduct.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
