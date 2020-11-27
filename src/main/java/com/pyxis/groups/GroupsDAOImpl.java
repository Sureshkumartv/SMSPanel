///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pyxis.groups;
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
//public class GroupsDAOImpl implements GroupsDAO {
//
//    private SessionFactory sessionFactory;
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
//    public void addRecord(Groups s) {
//        Session session = getSession();
//        session.persist(s);
//        System.out.println("Record Created Successfully");
//    }
//
//    @Override
//    public void updateRecord(int id) {
//        Session session = getSession();
//        Groups s = getById(id);
//        session.update(s);
//        System.out.println("Record Updated Successfully");
//    }
//
//    @Override
//    public void deleteRecord(int id) {
//        Session session = getSession();
//        Groups s = getById(id);
//        session.delete(s);
//        System.out.println("Record Deleted Successfully ");
//    }
//
//    @Override
//    public Groups getById(int id) {
//        Session session = getSession();
//        Groups s = (Groups) session.load(Groups.class, id);
//        return s;
//    }
//
//    
//
//    @Override
//    public List<Groups> listRecords(Integer page, Integer size) {
//        Session session = getSession();
//        Long count = (Long) session.createQuery("select count(1) from  Groups").uniqueResult();
//
//        Criteria criteria = session.createCriteria(Groups.class);
//        criteria.addOrder(Order.desc("groupsno"));
//        criteria.setFirstResult((page) * size);
//        criteria.setMaxResults(size);
//
//        @SuppressWarnings("unchecked")
//        List<Groups> list = criteria.list();
//
//        for (Groups ub : list) {
//            System.out.println("Groups ::" + ub);
//        }
//        session.close();
//        return list;
//    }
//
//    @Override
//    public Long getGroupsCount() {
//        Session session = getSession();
//        return (Long) session.createQuery("select count(1) from  Groups").uniqueResult();
//    }
//
//}
