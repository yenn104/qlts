package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserInfo", urlPatterns = {"/UserInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());

		Connection conn = null;
		String userName = request.getParameter("userName") ;
		
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			UserAccount user = new UserAccount(DBUtils.findUser(conn,userName));
				
				request.setAttribute("userName", userName);
				request.setAttribute("sdt", user.getSdt());
				request.setAttribute("mail", user.getMail());
				request.setAttribute("password", user.getPassword());
//				request.setAttribute("admin", user.getAdmin());
			
//				request.getRequestDispatcher("/UserInfo.jsp").forward(request, response);
			
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(UserInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }		
		
		String errorString = "Bạn chưa có đơn hàng nào.";
		List<Bill> list = new ArrayList<Bill>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryBill(conn, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("bill", list);
		request.setAttribute("errorString", errorString);
		request.getRequestDispatcher("/UserInfo.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}


}
