package Servlet;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
 fileSizeThreshold = 500 * 500 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
		)
@WebServlet("/newProductServlet")
public class newProductServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		 
		 public newProductServlet() {
			 super();
		 }
		 
		 
		 protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

				RequestDispatcher dispatcher = request.getServletContext()
						.getRequestDispatcher("/newProduct.jsp");
				dispatcher.forward(request, response);
			}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Connection conn = null; //connect SQL
		 
		try {
			 request.setCharacterEncoding("utf-8");
			 response.setCharacterEncoding("utf-8");
			 conn = MySQLConntUtils.getMySQLConnection();
			 
			 //xử lý tham số từ form
			 int id=Integer.parseInt(request.getParameter("ID"));			 
			 String name=request.getParameter("name");
			 String type=request.getParameter("type");
			 int slg=Integer.parseInt(request.getParameter("slg"));	
			 int price=Integer.parseInt(request.getParameter("price"));
			 String detail=request.getParameter("detail");
			 String image=""; 
			 Part part= request.getPart("image");
			 
//			 String fileName=extractFileName(part);
//			 filename = new File(filename).getName();
			 
			 String realpath = request.getServletContext().getRealPath("img_products");
			 String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			 part.write(realpath+"/"+filename);
			 image="./img_products/"+filename; 
			 
			 Product pro=new Product(id, name,type, slg, price, detail, image);
			 DBUtils.insertProduct(conn, pro);
			 request.getRequestDispatcher("/ProductListAdmin").forward(request, response);
		 
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
			} catch (SQLException ex) {
				Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
			
			}finally{
				 if(conn != null){
				 try {
				 conn.close();
			} catch (SQLException ex) {
			 	Logger.getLogger(newProductServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
			}} 
		 
		}
		
		
}

		
