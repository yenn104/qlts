package Servlet;

public class Thongke {
		private int nam;
		private int thang;
		private int tongdon;
		private int tongsp;
		private int dthu;
		
		public Thongke() {
			super();
		}

		public Thongke(int nam, int thang, int tongdon, int tongsp, int dthu) {
			super();
			this.nam = nam;
			this.thang = thang;
			this.tongdon = tongdon;
			this.tongsp = tongsp;
			this.dthu = dthu;
		}

		public int getNam() {
			return nam;
		}

		public void setNam(int nam) {
			this.nam = nam;
		}

		public int getThang() {
			return thang;
		}

		public void setThang(int thang) {
			this.thang = thang;
		}

		public int getTongdon() {
			return tongdon;
		}

		public void setTongdon(int tongdon) {
			this.tongdon = tongdon;
		}

		public int getTongsp() {
			return tongsp;
		}

		public void setTongsp(int tongsp) {
			this.tongsp = tongsp;
		}

		public int getDthu() {
			return dthu;
		}

		public void setDthu(int dthu) {
			this.dthu = dthu;
		}

		
}
