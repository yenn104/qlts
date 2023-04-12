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


@WebServlet(name = "EditSlg", urlPatterns = {"/EditSlg"})
public class EditCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		String userName=request.getParameter("userName");
		String idCart_temp = request.getParameter("idCart");
		int idCart = Integer.parseInt(idCart_temp);
		String slg_temp = request.getParameter("slg");
		int slg = Integer.parseInt(slg_temp);
		request.setAttribute("userName", userName);
		
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			DBUtils.EditSlgCart(conn, idCart, slg);
			request.setAttribute("slg", slg);
			request.getRequestDispatcher("/Cart").forward(request, response);
       }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(EditCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}	
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
