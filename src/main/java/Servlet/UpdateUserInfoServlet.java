package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Update",  urlPatterns = {"/Update"})
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName=request.getParameter("userName"); 
		String sdt=request.getParameter("sdt");
		String mail =request.getParameter("mail");
		String password =request.getParameter("password");
		request.setAttribute("userName", userName);
		request.setAttribute("sdt", sdt);
		request.setAttribute("mail", mail);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/UpdateInfo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			//xử lý tham số từ form
			String userName=request.getParameter("userName"); 
			String sdt=request.getParameter("sdt");
			String mail =request.getParameter("mail");
			String password =request.getParameter("password");
			request.setAttribute("userName", userName);
			
			UserAccount user = new UserAccount (userName, sdt, mail, password); //tạo đối tượng user

			DBUtils.updateUserInfo(conn, user);
			request.setAttribute("user", user);
			request.setAttribute("sdt", sdt);
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			request.setAttribute("done", "Cập nhật thành công!");
			request.setAttribute("icon", "<i class=\"fa fa-check\"></i>");
			request.getRequestDispatcher("/UpdateInfo.jsp").forward(request, response);
       
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(UpdateUserInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	
	}

}
