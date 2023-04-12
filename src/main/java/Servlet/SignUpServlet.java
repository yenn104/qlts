package Servlet;

//import static Servlet.DBUtils.insertUserAccount;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpServlet", urlPatterns = { "/SignUpServlet" })

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null; // connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			// xử lý tham số từ form
			String username = request.getParameter("username");
			String sdt = request.getParameter("sdt");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			int admin= 0;
			
			UserAccount usr = new UserAccount(username, sdt, mail, password, admin); // tạo đối tượng user
			// thêm đối tượng vào CSDL
			DBUtils.insertUserAccount(conn, usr);
			request.setAttribute("username", username);
			/* request.getRequestDispatcher("/home").forward(request, response); */
			 response.sendRedirect(request.getContextPath() + "/home"); 
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}
