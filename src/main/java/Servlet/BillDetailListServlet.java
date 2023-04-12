package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "BillDetail",  urlPatterns = {"/BillDetail"})
public class BillDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillDetailListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().append("Served at:").append(request.getContextPath());
			
			String userName = request.getParameter("userName") ;
			request.setAttribute("userName", userName);
			
			String id_temp=request.getParameter("idBill");
			int id = Integer.parseInt(id_temp);
			request.setAttribute("idBill", id);
			
			List<BillDetail> list = new ArrayList<BillDetail>();
			try {
				Connection conn = MySQLConntUtils.getMySQLConnection();
				list = DBUtils.queryBillDetail(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
			
			List<Product> list1 = new ArrayList<Product>();
			try {
				Connection conn = MySQLConntUtils.getMySQLConnection();
				list1 = DBUtils.queryProduct(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("productList", list1);
			

			request.setAttribute("billDetailList", list);
			request.getRequestDispatcher("/BillDetailList.jsp").forward(request, response);
			
			
	}		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
