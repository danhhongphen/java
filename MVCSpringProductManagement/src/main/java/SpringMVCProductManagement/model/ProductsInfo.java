package SpringMVCProductManagement.model;

public class ProductsInfo {
	private int id;
	private String product_id;
	private String name;
	
	public ProductsInfo() {
		
	}
	
	public ProductsInfo(int id, String product_id, String name) {
		this.id = id;
		this.product_id = product_id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
