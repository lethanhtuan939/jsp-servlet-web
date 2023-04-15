package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAODB;
import Entity.Account;

@WebServlet("/ListAccount")
public class ListAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexP = request.getParameter("index");
		if(indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		
		DAODB dao = new DAODB();
		int count = dao.getTotalAccount();
		int endPage = count/3;
		
		if(count % 3 != 0) {
			endPage++;
		}
		
		List<Account> list = dao.pagingAccount(index);
		
		request.setAttribute("listA", list);
		request.setAttribute("endP", endPage);
		request.setAttribute("tag", index);
		request.getRequestDispatcher("List.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
