package dao;

import java.util.List;

import hibernate.HibernateSessionFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.User;

public class UserDaoImpl implements UserDao {
	
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public boolean insert(User user) {
		log.debug("saving User instance");
		boolean flag = true;
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			session.save(user);
			transaction.commit();//提交事务			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			re.printStackTrace();
			transaction.rollback();//事务回滚		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
		if(flag)
			return true;
		else
			return false;
	}

	@Override
	public User findById(int userId) {
		log.debug("getting User instance with id: " + userId);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User as users where users.userId = ?");
			query.setInteger(0, userId);
			List list = query.list();			
			//user = (User)session.get("User", userId);   //User是Entity的name
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象			
			
			if(!list.isEmpty()) {
				return (User)list.get(0);
			}else{
				return null;
			}	
		} catch (RuntimeException re) {
			log.error("get failed", re);			
			throw re;
		}
	
	}

	@Override
	public List<User> findByName(String userName) {
		log.debug("getting User instance with userName: " + userName);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象		
			System.out.println("1111111");
			Query query = session.createQuery("from User as user where user.userName = ?");		
			query.setString(0, userName);		//查询获取用户名字
			System.out.println("2222221");			
			List<User> list = query.list();					//查询结果保存到list中			
			HibernateSessionFactory.closeSession();		//关闭Session对象
			return list;
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public User findByTel(String tel) {
		log.debug("getting User instance with tel: " + tel);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象			
			Query query = session.createQuery("from User as user where user.tel = ?");		
			query.setString(0, tel);		//查询获取用户名字			
			List<User> list = query.list();					//查询结果保存到list中
			//System.out.println(list.get(0).getTel());
			HibernateSessionFactory.closeSession();		//关闭Session对象
			if(!list.isEmpty()) {
				return (User)list.get(0);
			}else{
				return null;
			}
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<User> findAll() {
		log.debug("getting All User instance:");
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象		
			
			Query query = session.createQuery("from User");		
			List<User> list = query.list();					//查询结果保存到list中			
			HibernateSessionFactory.closeSession();		//关闭Session对象
			return list;
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


}
