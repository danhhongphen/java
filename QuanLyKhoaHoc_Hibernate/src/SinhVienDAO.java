

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SinhVienDAO {
	public static SinhVien layThongTinSinhVien(int maSinhVien)
	{
		SinhVien sv =null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			sv = (SinhVien) session.get(SinhVien.class, maSinhVien);
		}
		catch(HibernateException ex)
		{
			System.err.println(ex);
		} finally {
			session.close();
		}
		
		return sv;
	}
	public static boolean themSinhVien(SinhVien sv)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien()) != null)
		{
			return false;
		}
		
		boolean kq = true;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(sv);
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
	public static boolean capNhatThongTinSinhVien(SinhVien sv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		if(SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(sv);
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	public static boolean xoaSinhVien(int maSinhVien) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		SinhVien sv = SinhVienDAO.layThongTinSinhVien(maSinhVien);
		if(sv == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(sv);
			transaction.commit();
		} catch (HibernateException ex) {
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	public static List<SinhVien> layDanhSachSinhVien() {
		List<SinhVien> ds = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			String hql = "select sv from SinhVien sv";
			Query query = session.createQuery(hql);
			ds = query.list();
		} catch(HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}
}
