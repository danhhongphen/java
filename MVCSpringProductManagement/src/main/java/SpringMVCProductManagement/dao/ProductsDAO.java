package SpringMVCProductManagement.dao;
import java.util.List;

import SpringMVCProductManagement.entity.Products;
import SpringMVCProductManagement.model.ProductsInfo;
 
public interface ProductsDAO {
 
    public Products findProducts(int id);
 
    public List<ProductsInfo> listProductsInfos();
 
    public void saveProducts(ProductsInfo ProductsInfo);
 
    public ProductsInfo findProductsInfo(int id);
 
    public void deleteProducts(int id);
    
}

