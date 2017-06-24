package SpringMVCProductManagement.dao;

import java.util.List;

import SpringMVCProductManagement.entity.Staff;
import SpringMVCProductManagement.model.StaffInfo;
 
public interface StaffDAO {
 
    public Staff findStaff(String id);
 
    public List<StaffInfo> listStaffInfos();
 
    public void saveStaff(StaffInfo staffInfo);
 
    public StaffInfo findStaffInfo(String id);
 
    public void deleteStaff(String id);
    
}