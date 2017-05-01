

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LopHocDAO {
	public static LopHoc layThongTinLopHoc(String maLopHoc)
	{
		LopHoc lh =null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			lh = (LopHoc) session.get(LopHoc.class, maLopHoc);
		}
		catch(HibernateException ex)
		{
			System.err.println(ex);
		} finally {
			session.close();
		}
		
		return lh;
	}
	public static boolean themLopHoc(LopHoc lh)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(LopHocDAO.layThongTinLopHoc(lh.getMaLopHoc()) != null)
		{
			return false;
		}
		
		boolean kq = true;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(lh);
			transaction.commit();
		}catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
			kq = false;
		} finally {
			session.close();
		}
		return true;
	}
}
