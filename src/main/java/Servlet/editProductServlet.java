package Servlet;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
)
	@WebServlet("/editProductServlet")
	public class editProductServlet extends HttpServlet { private static final long serialVersionUID = 1L;
	 
	 public editProductServlet() {
		 super();
	 }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = null; //connect SQL
			
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			String id_temp=request.getParameter("id");
			int id = Integer.parseInt(id_temp);
			
			conn = MySQLConntUtils.getMySQLConnection();
			
			Product p = new Product(DBUtils.findProduct(conn, id));
				request.setAttribute("p_id", id);
				request.setAttribute("p_name", p.getName());
				request.setAttribute("p_type", p.getType());
				request.setAttribute("p_slg", p.getSlg());
				request.setAttribute("p_price", p.getPrice());
				request.setAttribute("p_img", p.getImg());
				request.setAttribute("p_detail", p.getDetail());
			
			request.getRequestDispatcher("/EditProduct.jsp").forward(request, response);
       }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(EditCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			conn = MySQLConntUtils.getMySQLConnection();
			
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type"); 
			int slg=Integer.parseInt(request.getParameter("slg"));	
			int price=Integer.parseInt(request.getParameter("price"));
			String detail=request.getParameter("detail");
			String image=""; 
			Part part= request.getPart("image2");
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			
			if(filename.length() > 0)
			{
				String realpath = request.getServletContext().getRealPath("img_products");
				part.write(realpath+"/"+filename);
				image="./img_products/"+filename; 
			}
			else
			{
				image =request.getParameter("image1");
			}
			
			Product pro=new Product(id, name,type, slg, price, detail, image); //tạo đối tượngproduct
			
			DBUtils.updateProduct(conn, pro); 
			request.getRequestDispatcher("/ProductListAdmin").forward(request, response);
		
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
			 if(conn != null){
			 try {
			 conn.close();
		} catch (SQLException ex) {
		 	Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		}} 
	 
	}
			
		}
