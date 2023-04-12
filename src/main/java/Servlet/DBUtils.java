package Servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtils {
//    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException{
//        //để đăng nhập --tìm trên csdl và trả về một user_account
//        String sql ="SELECT a.UserName, a.Password FROM user_account a WHERE a.userName =? AND a.passWord =?";
//        
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1,userName);
//        pstm.setString(2,password);
//        ResultSet rs = pstm.executeQuery(); //executeQuery() - trả về một tập kết quả
//    
//        if(rs.next()){
//            UserAccount user = new UserAccount();
////            user.setUsername(userName);       //lấy ở trên dòng 16-17
////            user.setPassword(password);       //
//            
//            user.setUserName(rs.getString("userName")); //lấy từ csdl lấy lên
//            user.setPassword(rs.getString("passWord"));
//            
//            return user;
//        }return null;     
//    }
    
    public static UserAccount findAdmin(Connection conn, String userName, String password) throws SQLException{
        //để đăng nhập --tìm trên csdl và trả về một user_account
        String sql ="SELECT u.UserName, u.Password, u.admin FROM user_account u WHERE u.userName =? AND u.passWord =?";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
        pstm.setString(2,password);
        ResultSet rs = pstm.executeQuery(); //executeQuery() - trả về một tập kết quả
    
        if(rs.next()){
            UserAccount user = new UserAccount();
            
            user.setUserName(rs.getString("userName")); //lấy từ csdl lấy lên
            user.setPassword(rs.getString("passWord"));
            user.setAdmin(rs.getInt("admin"));
            
            return user;
        }return null;     
    }
    
    
    public static void updateUserInfo(Connection conn, UserAccount user) throws SQLException {
		String sql = "Update user_account set sdt=?, mail=?, password=? where userName=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getSdt());	
			pstm.setString(2, user.getMail());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getUserName());
		pstm.executeUpdate();
	}
    
    
    
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
        //để lấy thông tin
        String sql ="SELECT a.UserName, a.Sdt, a.Mail, a.Password, a.Admin FROM User_Account a WHERE a.Username =?"; 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
        ResultSet rs = pstm.executeQuery();
        
        if(rs.next()){
        	String sdt = rs.getString("Sdt");
        	String mail = rs.getString("Mail");
            String password = rs.getString("Password");
            int admin = rs.getInt("Admin");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setSdt(sdt);
            user.setMail(mail);
            user.setPassword(password);
            user.setAdmin(admin);
            return user;
        }return null;
    }
	
    // truy vấn lấy danh sách toàn bộ sản phẩm    
	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.id, a.Name, a.Type, a.Slg, a.Price, a.Detail, a.Img from Product a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
		int id = rs.getInt("Id");
		String name = rs.getString("Name");
		String type = rs.getString("Type");
		int slg = rs.getInt("Slg");
		int price = rs.getInt("Price");
		String detail = rs.getString("detail");
		String img = rs.getString("img");
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setType(type);
		product.setSlg(slg);
		product.setPrice(price);
		product.setDetail(detail);
		product.setImg(img);
		list.add(product);
	}
	return list;
	}
	
	
//	public static List<Cart> queryCart(Connection conn) throws SQLException {
//		String sql = "SELECT c.ID, c.IDProduct, c.Slg,  c.UserName FROM CART c";
//		PreparedStatement pstm = conn.prepareStatement(sql);
//		ResultSet rs = pstm.executeQuery();
//		List<Cart> list = new ArrayList<Cart>();
//		while (rs.next()) {
////		int idCart = rs.getInt("Id");
//		int idProduct = rs.getInt("IDProduct");
//		int slg = rs.getInt("Slg");
//		String userName = rs.getString("UserName");
//		Cart cart = new Cart();
////		cart.setIdCart(idCart);
//		cart.setIdProduct(idProduct);
//		cart.setSlg(slg);
//		cart.setUserName(userName);
//		list.add(cart);
//	}
//	return list;
//	}
	

	// list sp trong gio hang cua user	
	public static List<Cart> queryCartUser(Connection conn, String userName) throws SQLException {
		String sql = "SELECT * FROM cart c WHERE UserName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
		ResultSet rs = pstm.executeQuery();
		List<Cart> list = new ArrayList<Cart>();
		while (rs.next()) {
		int idCart = rs.getInt("Id");
		int idProduct = rs.getInt("IDProduct");
		int slg = rs.getInt("Slg");
		Cart cart = new Cart();
		cart.setUserName(userName);
		cart.setIdCart(idCart);
		cart.setIdProduct(idProduct);
		cart.setSlg(slg);
		list.add(cart);
	}
	return list;
	}

	
	//xóa 1 sản phẩm ra khỏi giỏ hàng
	public static void deleteProductCart(Connection conn, int id, String userName) throws SQLException {
		String sql = "Delete From Cart where idProduct= ? And UserName=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2, userName);
		pstm.executeUpdate();
		}
	
	
	//thêm mới 1 sản phẩm vào giỏ hàng	
	public static void insertProductCart(Connection conn, Cart cart) throws SQLException {
		String sql = "Insert INTO Cart(idProduct, Slg, UserName) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, cart.getIdProduct());
		pstm.setInt(2, cart.getSlg());
		pstm.setString(3, cart.getUserName());
		pstm.executeUpdate();
		}
	

	//cập nhật số lượng của hàng hóa
	public static void updateSlgProduct(Connection conn, int idProduct, int slg) throws SQLException {
		String sql = "Update Product set slg = slg-? WHERE ID =? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,slg);
			pstm.setInt(2,idProduct);
		pstm.executeUpdate();
	}
	
	

//tìm kiếm xem một sản phẩm nào đó có trong giỏ hàng của user nào đó hay không 
	public static Cart findProductCart(Connection conn, String userName, int idProduct) throws SQLException{
        String sql ="SELECT c.UserName, c.slg, c.idProduct FROM CART c WHERE c.userName =? AND c.idProduct =?";
        
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1,userName);
	        pstm.setInt(2,idProduct);
	        ResultSet rs = pstm.executeQuery(); 
	    
	        if(rs.next()){
	            Cart cart = new Cart();
	            
	            cart.setUserName(rs.getString("UserName"));
	            cart.setSlg(rs.getInt("slg")); 
	            cart.setIdProduct(rs.getInt("idProduct"));
	            return cart;
	         
	        }else {
	        	 int slg = 0;
	        	 Cart cart = new Cart();
	             cart.setUserName(userName);
	             cart.setSlg(slg); 
	             cart.setIdProduct(idProduct);
	             return cart;
	        }     
    }
	

	//sửa số lượng của một sản phẩm tăng hoặc giảm trong giỏ hàng	
	public static void EditSlgCart(Connection conn, int idCart, int slg) throws SQLException {
		String sql = "Update CART set slg =? WHERE ID =? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,slg);
			pstm.setInt(2,idCart);
		pstm.executeUpdate();
	}
	
	
	//update khi thêm số lượng của sản phẩm trong giỏ hàng
	public static void updateProductCart(Connection conn, String userName, int idProduct) throws SQLException {
		String sql = "Update CART set slg = slg + 1 WHERE userName =? AND idProduct =? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,userName);
	        pstm.setInt(2,idProduct);
		pstm.executeUpdate();
	}
	
	
	
	//	SELECT * FROM `product` WHERE Name like '%nhẫn%'
	//truy vấn tìm sản phẩm theo từ khóa
	public static  List<Product> findSP(Connection conn, String keys) throws SQLException {
		String sql = "Select a.id, a.Name, a.Type, a.Slg, a.Price, a.Detail, a.Img from Product a WHERE Name like ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
		        pstm.setString(1,keys);
				ResultSet rs = pstm.executeQuery();
				List<Product> list = new ArrayList<Product>();
				while (rs.next()) {
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					String type = rs.getString("Type");
					int slg = rs.getInt("Slg");
					int price = rs.getInt("Price");
					String detail = rs.getString("detail");
					String img = rs.getString("img");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setType(type);
					product.setSlg(slg);
					product.setPrice(price);
					product.setDetail(detail);
					product.setImg(img);
				list.add(product);
			}
			return list;
			}
	
	
	
	public static List<Bill> queryBill(Connection conn, String userName) throws SQLException {
		String sql = "SELECT b.ID, b.Slg, b.Total, b.Date FROM Bill b WHERE UserName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
		ResultSet rs = pstm.executeQuery();
		List<Bill> list = new ArrayList<Bill>();
		while (rs.next()) {
		int idBill = rs.getInt("Id");
 		int slg = rs.getInt("Slg");
		int totalPrice = rs.getInt("Total");
		Date date = rs.getDate("Date");
		Bill bill = new Bill();
		bill.setIdBill(idBill);
		bill.setSlg(slg);
		bill.setTotalPrice(totalPrice);
		bill.setDate(date);
		list.add(bill);
	}
	return list;
	}
	
	
	public static void createBill(Connection conn, Bill bill) throws SQLException {
		String sql = "Insert INTO Bill( Slg, Total, Date ,UserName) values (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, bill.getSlg());
		pstm.setInt(2, bill.getTotalPrice());
		pstm.setDate(3, bill.getDate());
		pstm.setString(4, bill.getUserName());
		pstm.executeUpdate();
		}
	
	
	
	public static List<Bill> Thongke(Connection conn,  int year, int month) throws SQLException {
		String sql = "SELECT * FROM bill b WHERE YEAR(b.Date) = ? AND MONTH(b.Date) = ? ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 pstm.setInt(1,year);
		 pstm.setInt(2,month);
        ResultSet rs = pstm.executeQuery();
		List<Bill> list = new ArrayList<Bill>();
		while (rs.next()) {
			int idBill = rs.getInt("Id");
	 		int slg = rs.getInt("Slg");
			int totalPrice = rs.getInt("Total");
			Date date = rs.getDate("Date");
			String userName = rs.getString("userName");
			
			Bill bill = new Bill();
			bill.setIdBill(idBill);
			bill.setSlg(slg);
			bill.setTotalPrice(totalPrice);
			bill.setDate(date);
			bill.setUserName( userName);
		list.add(bill);
	}
	return list;
	}
	
	

	public static List<Thongke> DoanhThu(Connection conn) throws SQLException {
		String sql = "SELECT YEAR(b.Date) as 'Năm', MONTH(b.Date) as 'Tháng', COUNT(b.Slg) as 'Đơn', SUM(b.Slg) as 'Sản phẩm', Sum(b.Total) as 'Doanh thu' "
				+ "FROM bill b Group by  YEAR(b.Date), MONTH(b.Date);";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
		List<Thongke> list = new ArrayList<Thongke>();
		while (rs.next()) {
			int nam = rs.getInt("Năm");
			int thang = rs.getInt("Tháng");
	 		int tongdon = rs.getInt("Đơn");
	 		int tongsp = rs.getInt("Sản phẩm");
			int doanhthu = rs.getInt("Doanh thu");
			
			Thongke thongke= new Thongke();
			thongke.setNam(nam);
			thongke.setThang(thang);
			thongke.setTongdon(tongdon);
			thongke.setTongsp(tongsp);
			thongke.setDthu(doanhthu);
			
		list.add(thongke);
	}
	return list;
	}
	
	
	
	public static List<BillDetail> queryBillDetail(Connection conn, int idBill) throws SQLException {
		String sql = "SELECT * FROM Bill_Detail bd WHERE idBill = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idBill);
		ResultSet rs = pstm.executeQuery();
		List<BillDetail> list = new ArrayList<BillDetail>();
		while (rs.next()) {
		int idBDetail = rs.getInt("Id");
		int idProduct = rs.getInt("IDProduct");
		int slg = rs.getInt("Slg");
		BillDetail bdetail = new BillDetail();
		bdetail.setIdBDetail(idBDetail);
		bdetail.setIdBill(idBill);
		bdetail.setIdProduct(idProduct);
		bdetail.setSlg(slg);
		list.add(bdetail);
	}
	return list;
	}
	
	
	public static void createBillDetail(Connection conn, BillDetail bd) throws SQLException {
		String sql = "Insert INTO Bill_Detail( idBill, idProduct, Slg) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, bd.getIdBill());
		pstm.setInt(2, bd.getIdProduct());
		pstm.setInt(3, bd.getSlg());
		pstm.executeUpdate();
		}
	
	
	
	//tìm sản phẩm bằng id truyền vào, rồi lấy toàn bộ thông tin của 1 sản phẩm	
		public static Product findProduct(Connection conn, int id) throws SQLException {
		String sql = "Select a.id, a.Name, a.Type, a.Slg, a.Price, a.Detail, a.Img from Product a where a.id=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				ResultSet rs = pstm.executeQuery();
				if (rs.next()) {
					String name = rs.getString("Name");
					String type= rs.getString("Type");
					int slg = rs.getInt("Slg");
					int price = rs.getInt("Price");
					String detail = rs.getString("detail");
					String img = rs.getString("Img");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setType(type);
					product.setSlg(slg);
					product.setPrice(price);
					product.setDetail(detail);
					product.setImg(img);
			return product;
			}
			return null;
			}
	

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Type=?, slg=? ,Price=?, Detail=?, img=?  where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getType());
			pstm.setInt(3, product.getSlg());
			pstm.setInt(4, product.getPrice());
			pstm.setString(5, product.getDetail());
			pstm.setString(6, product.getImg());
			pstm.setInt(7, product.getId()); 
		pstm.executeUpdate();
	}
	

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into product(id, Name, Type, slg, Price, Detail, img) values (?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, product.getId()); 
				pstm.setString(2, product.getName());
				pstm.setString(3, product.getType());
				pstm.setInt(4, product.getSlg());
				pstm.setInt(5, product.getPrice());
				pstm.setString(6, product.getDetail());
				pstm.setString(7, product.getImg());
		pstm.executeUpdate();
	}
	

	public static void deleteProduct(Connection conn, int id) throws SQLException {
		String sql = "Delete From Product where id= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	 

	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException{
        String sql = "INSERT INTO user_account (Username, Sdt, Mail ,Password, Admin) VALUES (?,?,?,?,?) ";
	        PreparedStatement pstm = conn.prepareStatement(sql);
		        pstm.setString(1,user.getUserName());
		        pstm.setString(2,user.getSdt());
		        pstm.setString(3,user.getMail());
		        pstm.setString(4,user.getPassword());
		        pstm.setInt(5,user.getAdmin());
        pstm.executeUpdate();
    }
    
    
}