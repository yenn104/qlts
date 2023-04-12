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

@WebServlet(name = "Cart",  urlPatterns = {"/Cart"})
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		String errorString = "Chưa có sản phẩm trong giỏ hàng!";
		String userName = request.getParameter("userName") ;
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryCartUser(conn,userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		List<Product> list1 = new ArrayList<Product>();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			list1 = DBUtils.queryProduct(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("productList", list1);
		
		request.setAttribute("userName", userName);
		request.setAttribute("errorString", errorString);
		request.setAttribute("cartList", list);
		request.getRequestDispatcher("/CartList.jsp").forward(request, response);
		
		
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			String slgofbill_temp = request.getParameter("slgofbill") ;
			int slg = Integer.parseInt(slgofbill_temp);
			
			String totalofbill_temp = request.getParameter("totalofbill") ;
			int total = Integer.parseInt(totalofbill_temp);
			
			long millis=System.currentTimeMillis(); 
			java.sql.Date date=new java.sql.Date(millis);   
			
			String userName=request.getParameter("userName");
			request.setAttribute("userName", userName);
				
			Bill bill = new Bill(slg, total, date, userName);
			DBUtils.createBill(conn, bill);
			request.setAttribute("bill", bill);
			
			
			//insert billdetail
			List<Cart> list = new ArrayList<Cart>();
			try {
				 conn = MySQLConntUtils.getMySQLConnection();
				list = DBUtils.queryCartUser(conn,userName);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			List<Bill> list1 = new ArrayList<Bill>();
			try {
				conn = MySQLConntUtils.getMySQLConnection();
				list1 = DBUtils.queryBill(conn, userName);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("cartList", list);
			request.setAttribute("bill1", list1);
					
			int idBill = list1.get(list1.size()-1).getIdBill();
			
			for (int i = 0; i < list.size(); i++) {
				int id_product = list.get(i).getIdProduct();
				int slgg = list.get(i).getSlg();
				
				BillDetail bd = new BillDetail(idBill, id_product, slgg);
				DBUtils.createBillDetail(conn, bd);
				DBUtils.updateSlgProduct(conn, id_product, slgg);
				DBUtils.deleteProductCart(conn, id_product, userName);
			}
			
			request.setAttribute("done", "Đặt hàng thành công!");
			request.setAttribute("icon", "<i class=\"fa fa-check\"></i>");
			request.getRequestDispatcher("/UserInfo").forward(request, response);				
	
	       }catch(ClassNotFoundException | SQLException ex){
	            Logger.getLogger(AddProductCartServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }		
		
	}

}
