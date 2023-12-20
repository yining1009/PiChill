package com.pichill.reserveorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;


public class ReserveOrderDAOImpl implements ReserveOrderDAO {
private SessionFactory factory;
	
	public ReserveOrderDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int add(ReserveOrder reserveOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(reserveOrder);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}
	
	@Override
	public int update(ReserveOrder reserveOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(reserveOrder);
			session.getTransaction().commit();
			System.out.println("修改成功!");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改交易有錯QQ");
			session.getTransaction().rollback();
		}
		return -1;
	}
	
	@Override
	public ReserveOrder findByPK(Integer reserveOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ReserveOrder reserveOrder = session.get(ReserveOrder.class, reserveOrderID);
			session.getTransaction().commit();
			System.out.println("查單筆成功!");
			return reserveOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查單筆失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
//	@Override
//	public ReserveOrder findByFK1(Integer gUserID) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			ReserveOrder generalUser = session.get(ReserveOrder.class, gUserID);
//			session.getTransaction().commit();
//			System.out.println("用會員查單筆成功!");
//			return generalUser;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("用會員查單筆失敗QQ");
//			session.getTransaction().rollback();
//		}
//		return null;
//	}

	@Override
	public List<ReserveOrder> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//			NativeQuery<ReserveOrder> query = session.createNativeQuery(
//					"SELECT r.reserveOrderID, g.gUserID, g.gName, o.oUserID, r.reserveDate, t.timeID, t.reserveTime, c.courtName, "
//					+ "c.loc, p.placeID, p.placeName, p.ball, r.orderTime, r.orderNum, r.orderStatus, r.totalCost"+
//			        "FROM reserveOrder r JOIN generalUser g ON r.gUserID = g.gUserID"+
//							            "JOIN ownerUser o ON r.oUserID = o.oUserID"+
//			                            "JOIN time t ON r.timeID = t.timeID"+
//							            "JOIN place p ON r.placeID = p.placeID"+
//			                            "JOIN court c ON p.courtID = c.courtID", ReserveOrder.class);
//			List<ReserveOrder> list = query.list();

			List<ReserveOrder> list = session.createQuery("from ReserveOrder", ReserveOrder.class).list();
			session.getTransaction().commit();
			System.out.println("查全部成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查全部失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
	
}
