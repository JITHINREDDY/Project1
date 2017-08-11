package com.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import com.dao.UserDao;
import com.model.User;
@SuppressWarnings("deprecation")
@Repository("userDAO")
@Component
@Transactional
public class UserDaoImpl implements UserDao
{ 
	@Autowired
	SessionFactory sessionFactory;


	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}

	public void insertUser(User user)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	
		//session.close();

		//yg code	public boolean saveUser(User user);

	}

//	public void saveUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
