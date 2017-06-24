package SpringMVCProductManagement.model;

public class StaffInfo {
	private String id;
	private String name;
	private String password;
	
	// Không được thay đổi Constructor này,
	// Nó được sử dụng trong Hibernate Query.
	public StaffInfo() {
		 
	   }
   public StaffInfo(String id, String name, String password) {
       this.id = id;
       this.name = name;
       this.password = password;

   }

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
