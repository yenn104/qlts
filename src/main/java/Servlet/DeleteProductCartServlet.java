package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteProductCartServlet",  urlPatterns = {"/DeleteProductCartServlet"})
public class DeleteProductCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProductCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		String id_temp=request.getParameter("id");
		int id = Integer.parseInt(id_temp);
		String userName = request.getParameter("userName");
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			DBUtils.deleteProductCart(conn, id, userName);
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("/Cart").forward(request, response);
			 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DeleteProductCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
