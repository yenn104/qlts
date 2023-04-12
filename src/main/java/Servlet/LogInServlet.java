package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@SuppressWarnings("unused")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Connection conn;    
        try{
            conn = MySQLConntUtils.getMySQLConnection();     
   
            String username = request.getParameter("username");  
            String password = request.getParameter("password");        
            
            UserAccount usr = new UserAccount(username,password); 
            UserAccount user = new UserAccount(DBUtils.findAdmin(conn,usr.getUserName(),usr.getPassword()));
       
            if(user!=null) {
            	
            	HttpSession session = request.getSession();
//            	int ad = user.getAdmin();
//	        	String admin = String.valueOf(ad); 
	        	session.setAttribute("admin", user);
	        	session.setAttribute("name",  user.getUserName());
//	        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
//	        	dispatcher.forward(request, response);
	        	
	        	response.sendRedirect(request.getContextPath() + "/home"); 
	        	
				 
	        }else{
	        	
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

          @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");  
            String password = request.getParameter("password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
