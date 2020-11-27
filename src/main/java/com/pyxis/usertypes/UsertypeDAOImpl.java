///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pyxis.usertypes;
//
//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author suresh
// */
//@Component
//public class UsertypeDAOImpl implements UsertypeDAO {
////
////    @Autowired
////    private SessionFactory sessionFactory;
////
////    public void setSessionFactory(SessionFactory fs) {
////        this.sessionFactory = fs;
////    }
////
////    public Session getSession() {
////        Session session = null;
////        try {
////            session = this.sessionFactory.getCurrentSession();
////        } catch (Exception ex) {
////            session = this.sessionFactory.openSession();
////        }
////        return session;
////    }
////
////    @Override
////    public void addRecord(Usertypes s) {
////        Session session = getSession();
////        session.persist(s);
////        System.out.println("Record Created Successfully");
////    }
////
////    @Override
////    public void updateRecord(int id) {
////       Session session = getSession();
////        Usertypes s = getById(id);
////        session.update(s);
////        System.out.println("Record Updated Successfully");
////    }
////
////    @Override
////    public void deleteRecord(int id) {
////       Session session = getSession();
////        Usertypes s = getById(id);
////        session.delete(s);
////        System.out.println("Record Deleted Successfully ");
////    }
////
////    @Override
////    public Usertypes getById(int id) {
////       Session session = getSession();
////        Usertypes s = (Usertypes) session.load(Usertypes.class, id);
////        return s;
////    }
////
////    @Override
////    public List<Usertypes> listRecords() {
////       Session session = getSession();
////        List<Usertypes> list = session.createCriteria(Usertypes.class).list();
////        for (Usertypes ub : list) {
////            System.out.println("Usertypes ::" + ub);
////        }
////        return list;
////    }
////
//}
