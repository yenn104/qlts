package Servlet;

import java.sql.Date;

public class Bill {
	private int idBill;
	private int slg;
	private int totalPrice;
	private Date date;
	public String userName;
	
	
	public Bill() {
		super();
	}	
	
	public Bill(int idBill, int slg, int totalPrice, Date date, String userName) {
		this.idBill = idBill;
		this.slg = slg;
		this.totalPrice = totalPrice;
		this.userName = userName;
		this.date = date;
	}
	
	
	
	public Bill( int slg, int totalPrice, Date date, String userName) {
		this.slg = slg;
		this.totalPrice = totalPrice;
		this.userName = userName;
		this.date = date;
	}


	public Bill(Bill bill) {
		this.idBill = bill.idBill;
		this.slg = bill.slg;
		this.totalPrice = bill.totalPrice;
		this.date = bill.date;
		this.userName = bill.userName;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}


	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
