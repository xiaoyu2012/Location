package dao;

import hibernate.HibernateSessionFactory;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.AlarmInfo;

public class AlarmInfoDaoImpl implements AlarmInfoDao {
	
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public boolean insert(AlarmInfo alarminfo) {
		log.debug("saving AlarmInfo instance");
		boolean flag = true;
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			session.save(alarminfo);
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
	public AlarmInfo findById(int alarmInfoId) {
		log.debug("getting AlarmInfo instance with id: " + alarmInfoId);
		
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			AlarmInfo alarmInfo = new AlarmInfo();
			//alarmInfo = (AlarmInfo)session.get("AlarmInfo", alarmInfoId);		
			alarmInfo = (AlarmInfo) session.createQuery("from AlarmInfo as ai where ai.alarmInfoId = ? ").setInteger(0, alarmInfoId).list().get(0);
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象			
			return alarmInfo;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public boolean delete(int alarmInfoId) {
		log.debug("delete AlarmInfo instance with id: " + alarmInfoId);
		boolean flag = true;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			AlarmInfo alarmInfo = new AlarmInfo();
			alarmInfo = (AlarmInfo)session.get("AlarmInfo", alarmInfoId);
			session.delete(alarmInfo);     //删除对象
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象			
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			flag = false;
			throw re;
		}
		
		if(flag)
			return true;
		else
			return false;
	}
	
	   // 根据第几页获取，每页几行获取数据  
	@Override
    public List<AlarmInfo> getAlarmInfoList(int state, String page, String rows) {  
        log.debug("get AlarmInfo with page" + page + ", row=" + rows );
        //当为缺省值的时候进行赋值  
        int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);	//第几页  
        int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);	//每页多少行       
        System.out.println("currentpage=" + currentpage + ", pagesize=" + pagesize);
        try {
        	Session session = HibernateSessionFactory.getSession();
        	Query query = session.createQuery("from AlarmInfo as alarmInfo where alarmInfo.syn = 1 and alarmInfo.state = ?");
        	query.setInteger(0, state);
        	query.setMaxResults(pagesize);
        	query.setFirstResult((currentpage-1)*pagesize);
        	List<AlarmInfo> list = query.list();
        	HibernateSessionFactory.closeSession();
        	return list;  
        } catch(RuntimeException re) {
        	log.error("get failed" + re);
        	throw re;
        }        
    }  
  
    // 统计一共有多少数据  
	@Override
    public int getAlarmInfoTotal(int state) {  
    	log.debug("get AlarmInfo Total Number:" );
    	try{
    		Session session = HibernateSessionFactory.getSession();
    		int totel = session.createQuery("from AlarmInfo as ai where ai.syn = 1 and ai.state = ?").setInteger(0,state).list().size();    
    		HibernateSessionFactory.closeSession();
    		return totel;
    	} catch(RuntimeException re) {
    		log.error("get AlarmInfo Total Number failed !" + re);
    		throw re;
    	}
    }

	@Override
	public List<AlarmInfo> getOnceAlarmInfoList(int userId, int identify) {
		log.debug("get AlarmInfo with userId" + userId + ", identify=" + identify );
        
        try {
        	Session session = HibernateSessionFactory.getSession();
        	Query query = session.createQuery("from AlarmInfo as alarmInfo where alarmInfo.user.userId = ? and alarmInfo.identify=?");
        	query.setInteger(0, userId);
        	query.setInteger(1,identify);
        	List<AlarmInfo> list = query.list();
        	HibernateSessionFactory.closeSession();
        	return list;  
        } catch(RuntimeException re) {
        	log.error("get failed" + re);
        	throw re;
        }   
	 
	}

	@Override
	public boolean update(AlarmInfo alarmInfo) {
		log.debug("updating AlarmInfo instance");
		boolean flag = true;
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			session.update(alarmInfo);
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




}
