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


@WebServlet(name = "DeleteProductServlet",  urlPatterns = {"/DeleteProductServlet"})
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Connection conn = null;
			String id_temp=request.getParameter("id");
			int id = Integer.parseInt(id_temp);
			request.setAttribute("product", id);			 
			try {
				conn = MySQLConntUtils.getMySQLConnection();
				DBUtils.deleteProduct(conn, id);
				request.setAttribute("product", id);
				request.getRequestDispatcher("/ProductListAdmin").forward(request, response);
			}catch(ClassNotFoundException | SQLException ex){
	            Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }
		}
}