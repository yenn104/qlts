package Servlet;

public class Product {
	private int id;
	private String name;
	private String type;
	private int slg;
	private int price;
	private String detail;
	private String img;
	
	
	public Product() {
		super();
	}

	public Product(int id, String name, String type, int slg, int price,  String detail,  String img) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.slg = slg;
		this.price = price;
		this.img = img;
		this.detail =detail;
	}
	
	
	public Product(Product product) {
		this.id = product.id;
		this.name = product.name;
		this.type = product.type;
		this.slg = product.slg;
		this.price = product.price;
		this.img = product.img;
		this.detail = product.detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


}
