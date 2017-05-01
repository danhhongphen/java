

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class sinhvien_lophocDAO {
	public static sinhvien_lophoc layThongTinSinhVienLopHoc(sinhvien_lophocID pk)
	{
		sinhvien_lophoc svlhdao = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			svlhdao = (sinhvien_lophoc) session.get(sinhvien_lophoc.class, pk);
		}
		catch(HibernateException ex)
		{
			System.err.println(ex);
		} finally {
			session.close();
		}
		
		return svlhdao;
	}
	public static boolean themSinhVienVaoLopHoc(sinhvien_lophoc svlh)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(sinhvien_lophocDAO.layThongTinSinhVienLopHoc(svlh.getPk()) != null)
		{
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(svlh);
			transaction.commit();
		}catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	public static boolean capNhatThongTinSinhVienLopHoc(sinhvien_lophoc svlh)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(sinhvien_lophocDAO.layThongTinSinhVienLopHoc(svlh.getPk()) == null)
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
	public static boolean xoaSinhVienLopHoc(sinhvien_lophocID pk)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		sinhvien_lophoc svlh = sinhvien_lophocDAO.layThongTinSinhVienLopHoc(pk);
		if(svlh == null)
		{
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(svlh);
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
