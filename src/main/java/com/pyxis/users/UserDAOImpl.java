///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pyxis.users;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.criterion.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.support.DataAccessUtils;
//import org.springframework.orm.hibernate4.HibernateCallback;
//import org.springframework.orm.hibernate4.HibernateTemplate;
//import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author suresh
// */
//@Component
//public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
//
//	@Override
//	public void addRecord(Users s) {
//		// System.out.println("ok suresh coming here");
//		// Session session = getSession();
//		// session.getTransaction().begin();
//		// session.persist(s);
//		// session.getTransaction().commit();
//		// session.close();
//		// System.out.println("Record Created Successfully");
//
//		getHibernateTemplate().save(s);
//	}
//
//	@Override
//	public void updateRecord(Users id) {
//		// Session session = getSession();
//		// session.getTransaction().begin();
//		//// Users s = getById(id);
//		// session.update(id);
//		// session.getTransaction().commit();
//		// session.close();
//		getHibernateTemplate().update(id);
//		System.out.println("Record Updated Successfully");
//	}
//
//	@Override
//	public void deleteRecord(int id) {
//		// Session session = getSession();
//		// Users s = getById(id);
//		// session.delete(s);
//		Users s = getById(id);
//		getHibernateTemplate().delete(s);
//		System.out.println("Record Deleted Successfully ");
//	}
//
//	@Override
//	public Users getById(int id) {
//		// Session session = getSession();
//		// Users s = (Users) session.load(Users.class, id);
//		Users s = (Users) getHibernateTemplate().get(Users.class, id);
//		return s;
//	}
//
//	@Override
//	public Long getUsersCount() {
//		// Session session = getSession();
//		// Users
//		// return (Long) session.createQuery("select count(1) from
//		// Users").uniqueResult();
//		return DataAccessUtils.longResult(getHibernateTemplate().find("select count(*) from Users"));
//	}
//
//	@Override
//	public List<Users> listRecords(Integer page, Integer size) {
//		HibernateTemplate template = getHibernateTemplate();
//
//		List<Users> list = template.execute(new HibernateCallback<List<Users>>() {
//			@SuppressWarnings("unchecked")
//			public List<Users> doInHibernate(Session session) throws HibernateException {
//				Query query = session.createQuery("from Users");
//				query.setMaxResults(size);
//				query.setFirstResult(size * page);
//				return query.list();
//			}
//		});
//		// Session session = getSession();
//		//// Long count = (Long) session.createQuery("select count(1) from
//		// Users").uniqueResult();
//		//
//		// Criteria criteria = session.createCriteria(Users.class);
//		// criteria.addOrder(Order.desc("userid"));
//		// criteria.setFirstResult((page) * size);
//		// criteria.setMaxResults(size);
//		//
//		// @SuppressWarnings("unchecked")
//		// List<Users> list = criteria.list();
//
//		for (Users ub : list) {
//			System.out.println("Users ::" + ub);
//		}
//		return list;
//	}
//
//	@Override
//	public Users getByName(String id) {
//
//		return (Users) DataAccessUtils
//				.uniqueResult(getHibernateTemplate().find("select u from Users u where u.username = " + id));
//		// Session session = getSession();
//		// Users s = null;// (Users) session.load(Users.class, id);
//		// System.out.println("id value ::" + id);
//		// Query query = session.createQuery();
//		// query.setParameter(0, id);
//		// List<Users> users = query.list();
//		//
//		// if (users != null) {
//		// for (Users user : users) {
//		// s = user;
//		// }
//		// }
//		// session.close();
//		// return s;
//	}
//
//	@Override
//	public String getPassword(Integer id) {
//		String password = null;
//
//		HibernateTemplate template = getHibernateTemplate();
//
//		List<Object> list = template.execute(new HibernateCallback<List<Object>>() {
//			@SuppressWarnings("unchecked")
//			public List<Object> doInHibernate(Session session) throws HibernateException {
//				Query query = session.createSQLQuery(
//						"SELECT AES_DECRYPT(PASSWORD, '20091129') password FROM user_details where userid = ?");
//				query.setParameter(0, id);
//				return query.list();
//			}
//		});
//		if (null != list) {
//			for (Object object : list) {
//				password = new String((byte[]) object);
//			}
//		}
//		return password;
//	}
//
//}
