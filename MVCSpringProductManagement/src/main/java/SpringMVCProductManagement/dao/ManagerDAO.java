package SpringMVCProductManagement.dao;

import java.util.List;

import SpringMVCProductManagement.entity.Manager;
import SpringMVCProductManagement.model.ManagerInfo;
 
public interface ManagerDAO {
 
    public Manager findManager(String id);
 
    public List<ManagerInfo> listManagerInfos();
 
    public void saveManager(ManagerInfo managerInfo);
 
    public ManagerInfo findManagerInfo(String id);
 
    public void deleteManager(String id);
    
}