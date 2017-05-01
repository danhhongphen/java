

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
class GiaoVien implements java.io.Serializable
{
	private int maGiaoVien;
	private String hoVaTen;
	private String matKhau;
	private Set<LopHoc> lopHocs = new HashSet<LopHoc>(0);
	public GiaoVien(){
		
	}
	public GiaoVien(int maGiaoVien)
	{
		this.maGiaoVien = maGiaoVien;
	}
	public GiaoVien(int maGiaoVien, String hoVaTen, String matKhau, Set<LopHoc> lophocs)
	{
		this.maGiaoVien = maGiaoVien;
		this.hoVaTen = hoVaTen;
		this.matKhau = matKhau;
		this.lopHocs = lophocs;
	}
	public int getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
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
	public void setLopHocs(Set<LopHoc> lophocs) {
		this.lopHocs = lophocs;
	}
}
