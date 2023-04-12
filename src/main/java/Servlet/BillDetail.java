package Servlet;

public class BillDetail {
	private int idBDetail;
	private int idBill;
	private int idProduct;
	private int slg;
	
	public BillDetail() {
		super();
	}

	public BillDetail(int idBDetail, int idBill, int idProduct, int slg) {
		this.idBDetail = idBDetail;
		this.idBill = idBill;
		this.idProduct = idProduct;
		this.slg = slg;
	}
	
	
	public BillDetail( int idBill, int idProduct, int slg) {
		this.idBill = idBill;
		this.idProduct = idProduct;
		this.slg = slg;
	}
	
	
	public BillDetail(BillDetail bdetail) {
		this.idBDetail = bdetail.idBDetail;
		this.idBill = bdetail.idBill;
		this.idProduct = bdetail.idProduct;
		this.slg = bdetail.slg;
	}
	
	

	public int getIdBDetail() {
		return idBDetail;
	}

	public void setIdBDetail(int idBDetail) {
		this.idBDetail = idBDetail;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}
	
}
