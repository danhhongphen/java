

import java.util.Date;
import java.sql.Time;
import java.util.Set;

@SuppressWarnings("serial")
class LopHoc implements java.io.Serializable{
	private String maLopHoc;
	private String tenLopHoc;
	private String phongHoc;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private Time gioBatDau;
	private Time gioKetThuc;
	private String thu;
	private Set<SinhVien> sinhViens;
	public LopHoc()
	{
		
	}
	public LopHoc(String maLopHoc)
	{
		this.maLopHoc = maLopHoc;
	}
	public LopHoc(String maLopHoc, String tenLopHoc, String phongHoc, 
			Date ngayBatDau, Date ngayKetThuc, Time gioBatDau, Time gioKetThuc, 
			String thu, Set<SinhVien> sinhViens)
	{
		this.maLopHoc = maLopHoc;
		this.tenLopHoc = tenLopHoc;
		this.phongHoc = phongHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.thu = thu;
		this.sinhViens = sinhViens;
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public String getTenLopHoc() {
		return tenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
	public String getPhongHoc() {
		return phongHoc;
	}
	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public Time getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Time gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public Time getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Time gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
	}
	public Set<SinhVien> getSinhViens() {
		return sinhViens;
	}
	public void setSinhViens(Set<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}
}
