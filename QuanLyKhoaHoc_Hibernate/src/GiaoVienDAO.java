

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GiaoVienDAO {
	public static GiaoVien layThongTinGiaoVien(int maGiaoVien)
	{
		GiaoVien gv =null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			gv = (GiaoVien) session.get(GiaoVien.class, maGiaoVien);
		}
		catch(HibernateException ex)
		{
			System.err.println(ex);
		} finally {
			session.close();
		}
		
		return gv;
	}
	public static boolean capNhatThongTinGiaoVien(GiaoVien gv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(GiaoVienDAO.layThongTinGiaoVien(gv.getMaGiaoVien()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(gv);
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
}
