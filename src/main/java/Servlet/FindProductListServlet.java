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

//tìm kiếm sản phẩm theo từ khóa
@WebServlet(name = "Find", urlPatterns = {"/Find"})
public class FindProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindProductListServlet() {
        super();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());

		String errorString = "Không có sản phẩm.";
		String key = request.getParameter("key");
		request.setAttribute("key", key);
		String keys = "%"+key+"%";
		List<Product> list = new ArrayList<Product>();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.findSP(conn, keys);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("productList", list);
		request.getRequestDispatcher("/ProductList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
