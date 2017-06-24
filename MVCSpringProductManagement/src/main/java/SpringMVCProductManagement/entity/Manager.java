package SpringMVCProductManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quanly")
public class Manager implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	private String id;
	private String name;
	private String password;
	
	@Id
	@Column(name = "MaQuanLy", length = 50, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "TenQuanLy", length = 50, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "MatKhau", length = 50, nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
