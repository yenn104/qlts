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

@WebServlet(name = "Detail", urlPatterns = {"/Detail"})
public class DetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		String userName=request.getParameter("userName");
		request.setAttribute("userName", userName);
		try {
			String id_temp=request.getParameter("idProduct");
			int id = Integer.parseInt(id_temp);
			
			conn = MySQLConntUtils.getMySQLConnection();
			
			Product p = new Product(DBUtils.findProduct(conn, id));
			 
				request.setAttribute("id", id);
				request.setAttribute("nameproduct", p.getName());
				request.setAttribute("type", p.getType());
				request.setAttribute("slg", p.getSlg());
				request.setAttribute("price", p.getPrice());
				request.setAttribute("img", p.getImg());
				request.setAttribute("detail", p.getDetail());
			
			request.getRequestDispatcher("/DetailProduct.jsp").forward(request, response);
			 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DetailProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
