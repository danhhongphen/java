
public class sinhvien_lophocID implements java.io.Serializable {
	private int maSinhVien;
	private String maLopHoc;
	public sinhvien_lophocID(int mssv, String maLopHocCombobox) {
		// TODO Auto-generated constructor stub
		this.maSinhVien = mssv;
		this.maLopHoc = maLopHocCombobox;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	
	
}
