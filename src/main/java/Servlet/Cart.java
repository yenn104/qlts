package Servlet;

public class Cart {
	private int idCart;
	public int idProduct;
	private int slg;
	public String userName;
	
	public Cart() {
		super();
	}	
	
	
	public Cart(int idCart, int slg, int idProduct, String userName) {
		this.idCart = idCart;
		this.slg = slg;
		this.idProduct = idProduct;
		this.userName = userName;
	}
	
	
	public Cart(  int idProduct, int slg, String userName) {
		this.slg = slg;
		this.idProduct = idProduct;
		this.userName = userName;
	}
	
	
	public Cart( String userName, int idProduct) {
		this.idProduct = idProduct;
		this.userName = userName;
	}


	public Cart(Cart cart) {
		this.idCart = cart.idCart;
		this.slg = cart.slg;
		this.idProduct = cart.idProduct;
		this.userName = cart.userName;
	}
	

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
