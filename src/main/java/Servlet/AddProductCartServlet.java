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

@WebServlet(name = "AddProductCart",  urlPatterns = {"/AddProductCart"})
public class AddProductCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddProductCartServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			String idProduct_temp=request.getParameter("idProduct");
			int idProduct = Integer.parseInt(idProduct_temp);
		
			String userName=request.getParameter("userName");
				
			Cart cart = new Cart(DBUtils.findProductCart(conn, userName, idProduct));
	
			if(cart.getSlg() > 0) {
				DBUtils.updateProductCart(conn, userName, idProduct); 
				
			}else{
				int slg1 = 1;
				cart = new Cart (idProduct, slg1, userName); 				
				DBUtils.insertProductCart(conn, cart);
			}
			
				request.setAttribute("cart", cart);
				request.getRequestDispatcher("/Cart").forward(request, response);				
	
	       }catch(ClassNotFoundException | SQLException ex){
	            Logger.getLogger(AddProductCartServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
