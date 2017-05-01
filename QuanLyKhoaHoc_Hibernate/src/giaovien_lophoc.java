

public class giaovien_lophoc implements java.io.Serializable {
	private giaovien_lophocID pk;

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		giaovien_lophoc that = (giaovien_lophoc) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	public giaovien_lophocID getPk() {
		return pk;
	}

	public void setPk(giaovien_lophocID pk) {
		this.pk = pk;
	}
}
