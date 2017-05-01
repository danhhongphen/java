import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class giaovien_lophocDAO {
	public static giaovien_lophoc layThongTinGiaoVienLopHoc(giaovien_lophocID pk)
	{
		giaovien_lophoc gvlhdao = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			gvlhdao = (giaovien_lophoc) session.get(giaovien_lophoc.class, pk);
			
			//gvlhdao = (giaovien_lophoc) session.createQuery("from giaovien_lophoc b where b.")
		}
		catch(HibernateException ex)
		{
			System.err.println(ex);
		} finally {
			session.close();
		}
		
		return gvlhdao;
	}
	public static boolean themGiaoVienVaoLopHoc(giaovien_lophoc gvlh)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(giaovien_lophocDAO.layThongTinGiaoVienLopHoc(gvlh.getPk()) != null)
		{
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(gvlh);
			transaction.commit();
		}catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	public static boolean capNhatThongTinGiaoVienLopHoc(giaovien_lophoc svlh)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(giaovien_lophocDAO.layThongTinGiaoVienLopHoc(svlh.getPk()) == null)
		{
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(svlh);
			transaction.commit();
		}catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	public static boolean xoaSinhVienLopHoc(giaovien_lophocID pk)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		giaovien_lophoc gvlh = giaovien_lophocDAO.layThongTinGiaoVienLopHoc(pk);
		if(gvlh == null)
		{
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(gvlh);
			transaction.commit();
		}catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
}
