package dao;

import hibernate.HibernateSessionFactory;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Admin;
import po.User;

public class AdminDaoImpl implements AdminDao {
	
	private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

	@Override
	public Admin findById(int adminId) {
		log.debug("getting Admin instance with id: " + adminId);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();			
			Query query = session.createQuery("from Admin as admin where admin.adminId = ?");
			query.setInteger(0, adminId);
			List list = query.list();					
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象			
			
			if(!list.isEmpty()) {
				return (Admin)list.get(0);
			}else{
				return null;
			}	
		} catch (RuntimeException re) {
			log.error("get failed", re);			
			throw re;
		}
	
	}

	@Override
	public Admin findByName(String adminName) {
		log.debug("getting Admin instance with adminName: " + adminName);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();		
			Query query = session.createQuery("from Admin as admin where admin.adminName = ?");
			query.setString(0, adminName);
			List list = query.list();					
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象			
			
			if(!list.isEmpty()) {
				return (Admin)list.get(0);
			}else{
				return null;
			}	
		} catch (RuntimeException re) {
			log.error("get failed", re);			
			throw re;
		}
	}

}
