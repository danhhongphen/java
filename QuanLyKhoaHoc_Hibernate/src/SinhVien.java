

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
class SinhVien implements java.io.Serializable
{
	private int maSinhVien;
	private String hoVaTen;
	private String matKhau;
	private Set<LopHoc> lopHocs = new HashSet<LopHoc>(0);
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public Set<LopHoc> getLopHocs() {
		return lopHocs;
	}
	public void setLopHocs(Set<LopHoc> lopHocs) {
		this.lopHocs = lopHocs;
	}
	
}
