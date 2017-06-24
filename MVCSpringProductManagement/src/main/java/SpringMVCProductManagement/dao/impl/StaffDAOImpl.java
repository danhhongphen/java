package SpringMVCProductManagement.dao.impl;

import java.util.List;
import java.util.UUID;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import SpringMVCProductManagement.dao.StaffDAO;
import SpringMVCProductManagement.entity.Staff;
import SpringMVCProductManagement.model.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
 
public class StaffDAOImpl implements StaffDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Staff findStaff(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Staff.class);
        crit.add(Restrictions.eq("id", id));
        return (Staff) crit.uniqueResult();
    }
 
    @Override
    public StaffInfo findStaffInfo(String id) {
    	Staff staff = this.findStaff(id);
        if (staff == null) {
            return null;
        }
        return new StaffInfo(staff.getId(), staff.getName(), staff.getPassword());
    }
 
    @Override
    public List<StaffInfo> listStaffInfos() {
        String sql = "Select new " + StaffInfo.class.getName()//
                + "(a.id, a.name, a.password) "//
                + " from " + Staff.class.getName() + " a ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        return query.list();
    }
    

    
    public void saveStaff(StaffInfo staffInfo) {
        String id = staffInfo.getId();
        Staff staff = null;
        if (id != null) {
        	staff = this.findStaff(id);
        }
        boolean isNew = false;
        if (staff == null) {
            isNew = true;
            staff = new Staff();
            
            staff.setId(UUID.randomUUID().toString());
        }
        staff.setName(staffInfo.getName());
        staff.setPassword(staffInfo.getPassword());
 
        if (isNew) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(staff);
        }
    }
 
    @Override
    public void deleteStaff(String id) {
    	Staff staff = this.findStaff(id);
        if (staff != null) {
            this.sessionFactory.getCurrentSession().delete(staff);
        }
    }
 
}