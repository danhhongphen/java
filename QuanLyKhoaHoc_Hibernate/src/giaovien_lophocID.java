
public class giaovien_lophocID implements java.io.Serializable {
	private int maGiaoVien;
	private String maLopHoc;
	public giaovien_lophocID(int maGiaoVien, String maLopHoc) {
		// TODO Auto-generated constructor stub
		this.maGiaoVien = maGiaoVien;
		this.maLopHoc = maLopHoc;
	}
	public int getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
}
