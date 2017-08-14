/*package com.daoImpl;
package com.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import com.dao.CategoryDao;
import com.dao.UserDao;
import com.model.Category;
import com.model.User;

@SuppressWarnings("unused")
@Repository
public class CategoryDaoImpl implements CategoryDao

{
 @Autowired
 SessionFactory sessionFactory;
   
 public CategoryDaoImpl(Category category)
 {
	  this.sessionFactory=sessionFactory;
 }
 

public void insertCategory(Category category)
{
	Session session= sessionFactory.openSession();
	session.beginTransaction();
	session.saveOrUpdate(category);
	session.getTransaction().commit();
	
}
}
*/