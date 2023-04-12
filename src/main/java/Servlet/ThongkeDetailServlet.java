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


@WebServlet(name = "ThongkeDetail", urlPatterns = {"/ThongkeDetail"})
public class ThongkeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ThongkeDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		int nam=Integer.parseInt(request.getParameter("nam"));
		int thang=Integer.parseInt(request.getParameter("thang"));
		List<Bill> list = new ArrayList<Bill>();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.Thongke(conn, nam, thang);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		request.setAttribute("nam", nam);
		request.setAttribute("thang", thang);
		request.setAttribute("billList", list);
		request.getRequestDispatcher("/ThongkeDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
