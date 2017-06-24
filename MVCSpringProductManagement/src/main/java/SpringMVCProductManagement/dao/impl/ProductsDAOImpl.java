package SpringMVCProductManagement.dao.impl;
import java.util.List;
import java.util.UUID;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import SpringMVCProductManagement.dao.ProductsDAO;
import SpringMVCProductManagement.entity.Products;
import SpringMVCProductManagement.model.ProductsInfo;
import org.springframework.beans.factory.annotation.Autowired;
 
public class ProductsDAOImpl implements ProductsDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Products findProducts(int id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Products.class);
        crit.add(Restrictions.eq("id", id));
        return (Products) crit.uniqueResult();
    }
 
    @Override
    public ProductsInfo findProductsInfo(int id) {
    	Products product = this.findProducts(id);
        if (product == null) {
            return null;
        }
        return new ProductsInfo(product.getId(), product.getProduct_id(), product.getName());
    }
 
    @Override
    public List<ProductsInfo> listProductsInfos() {
        String sql = "Select new " + ProductsInfo.class.getName()//
                + "(a.id, a.product_id, a.name) "//
                + " from " + Products.class.getName() + " a ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        return query.list();
    }
    

    
    public void saveProducts(ProductsInfo productInfo) {
        int id = productInfo.getId();
        Products product = null;
        if (id != 0) {
        	product = this.findProducts(id);
        }
        boolean isNew = false;
        if (product == null) {
            isNew = true;
            product = new Products();
            
            product.setId(id);
        }
        product.setProduct_id(productInfo.getProduct_id());
        product.setName(productInfo.getName());
 
        if (isNew) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(product);
        }
    }
 
    @Override
    public void deleteProducts(int id) {
    	System.out.println("ID la: " + id);
    	Products product = this.findProducts(id);
        if (product != null) {
        	System.out.println("!= null");
            this.sessionFactory.getCurrentSession().delete(product);
        }
    }
 
}
