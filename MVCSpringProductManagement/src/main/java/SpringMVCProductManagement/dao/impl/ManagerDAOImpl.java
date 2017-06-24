package SpringMVCProductManagement.dao.impl;

import java.util.List;
import java.util.UUID;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import SpringMVCProductManagement.dao.ManagerDAO;
import SpringMVCProductManagement.entity.Manager;
import SpringMVCProductManagement.model.ManagerInfo;
import org.springframework.beans.factory.annotation.Autowired;
 
public class ManagerDAOImpl implements ManagerDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Manager findManager(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Manager.class);
        crit.add(Restrictions.eq("id", id));
        return (Manager) crit.uniqueResult();
    }
 
    @Override
    public ManagerInfo findManagerInfo(String id) {
    	Manager manager = this.findManager(id);
        if (manager == null) {
            return null;
        }
        return new ManagerInfo(manager.getId(), manager.getName(), manager.getPassword());
    }
 
    @Override
    public List<ManagerInfo> listManagerInfos() {
        String sql = "Select new " + ManagerInfo.class.getName()//
                + "(a.id, a.name, a.password) "//
                + " from " + Manager.class.getName() + " a ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        return query.list();
    }
    

    
    public void saveManager(ManagerInfo managerInfo) {
        String id = managerInfo.getId();
        Manager manager = null;
        if (id != null) {
        	manager = this.findManager(id);
        }
        boolean isNew = false;
        if (manager == null) {
            isNew = true;
            manager = new Manager();
            
            manager.setId(UUID.randomUUID().toString());
        }
        manager.setName(managerInfo.getName());
        manager.setPassword(managerInfo.getPassword());
 
        if (isNew) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(manager);
        }
    }
 
    @Override
    public void deleteManager(String id) {
    	Manager manager = this.findManager(id);
        if (manager != null) {
            this.sessionFactory.getCurrentSession().delete(manager);
        }
    }
 
}