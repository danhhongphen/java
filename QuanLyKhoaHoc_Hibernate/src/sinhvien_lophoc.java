
public class sinhvien_lophoc implements java.io.Serializable {
	private sinhvien_lophocID pk;
	private int Tuan1;
	private int Tuan2;
	private int Tuan3;
	private int Tuan4;
	private int Tuan5;
	private int Tuan6;
	private int Tuan7;
	private int Tuan8;
	private int Tuan9;
	private int Tuan10;
	private int Tuan11;
	private int Tuan12;
	private int Tuan13;
	private int Tuan14;
	private int Tuan15;
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		sinhvien_lophoc that = (sinhvien_lophoc) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	public sinhvien_lophocID getPk() {
		return pk;
	}

	public void setPk(sinhvien_lophocID pk) {
		this.pk = pk;
	}

	public int getTuan1() {
		return Tuan1;
	}

	public void setTuan1(int tuan1) {
		Tuan1 = tuan1;
	}

	public int getTuan2() {
		return Tuan2;
	}

	public void setTuan2(int tuan2) {
		Tuan2 = tuan2;
	}

	public int getTuan3() {
		return Tuan3;
	}

	public void setTuan3(int tuan3) {
		Tuan3 = tuan3;
	}

	public int getTuan4() {
		return Tuan4;
	}

	public void setTuan4(int tuan4) {
		Tuan4 = tuan4;
	}

	public int getTuan5() {
		return Tuan5;
	}

	public void setTuan5(int tuan5) {
		Tuan5 = tuan5;
	}

	public int getTuan6() {
		return Tuan6;
	}

	public void setTuan6(int tuan6) {
		Tuan6 = tuan6;
	}

	public int getTuan7() {
		return Tuan7;
	}

	public void setTuan7(int tuan7) {
		Tuan7 = tuan7;
	}

	public int getTuan8() {
		return Tuan8;
	}

	public void setTuan8(int tuan8) {
		Tuan8 = tuan8;
	}

	public int getTuan9() {
		return Tuan9;
	}

	public void setTuan9(int tuan9) {
		Tuan9 = tuan9;
	}

	public int getTuan10() {
		return Tuan10;
	}

	public void setTuan10(int tuan10) {
		Tuan10 = tuan10;
	}

	public int getTuan11() {
		return Tuan11;
	}

	public void setTuan11(int tuan11) {
		Tuan11 = tuan11;
	}

	public int getTuan12() {
		return Tuan12;
	}

	public void setTuan12(int tuan12) {
		Tuan12 = tuan12;
	}

	public int getTuan13() {
		return Tuan13;
	}

	public void setTuan13(int tuan13) {
		Tuan13 = tuan13;
	}

	public int getTuan14() {
		return Tuan14;
	}

	public void setTuan14(int tuan14) {
		Tuan14 = tuan14;
	}

	public int getTuan15() {
		return Tuan15;
	}

	public void setTuan15(int tuan15) {
		Tuan15 = tuan15;
	}
}
