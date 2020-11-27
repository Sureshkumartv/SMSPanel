///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pyxis.contacts;
//
//import java.util.List;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author suresh
// */
//@Component
//public class ContactsDAOImpl implements ContactsDAO {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory fs) {
//        this.sessionFactory = fs;
//    }
//
//    public Session getSession() {
//        Session session = null;
//        try {
//            session = this.sessionFactory.getCurrentSession();
//        } catch (Exception ex) {
//            session = this.sessionFactory.openSession();
//        }
//        return session;
//    }
//
//    @Override
//    public List<Contacts> listRecords(Integer page, Integer size) {
//        Session session = getSession();
//        Long count = (Long) session.createQuery("select count(1) from  Contacts").uniqueResult();
//        System.out.println(count);
//        Criteria criteria = session.createCriteria(Contacts.class);
//        criteria.addOrder(Order.desc("contactNo"));
//        criteria.setFirstResult((page) * size);
//        criteria.setMaxResults(size);
//
//        @SuppressWarnings("unchecked")
//        List<Contacts> list = criteria.list();
//
//        for (Contacts ub : list) {
//            System.out.println("Contacts ::" + ub);
//        }
//        session.close();
//        return list;
//    }
//
//    @Override
//    public Long getContactsCount() {
//      Session session = getSession();
//        return (Long) session.createQuery("select count(1) from  Contacts").uniqueResult();
//    }
//}
