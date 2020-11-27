/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suresh
 */
@Component
public class ScheduledDAOImpl implements ScheduledDAO {
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
//    public List<Scheduled> listRecords(Integer page, Integer size) {
//        Session session = getSession();
//        Long count = (Long) session.createQuery("select count(1) from  Scheduled").uniqueResult();
//
//        Criteria criteria = session.createCriteria(Scheduled.class);
//        criteria.addOrder(Order.desc("excelSno"));
//        criteria.setFirstResult((page) * size);
//        criteria.setMaxResults(size);
//
//        @SuppressWarnings("unchecked")
//        List<Scheduled> list = criteria.list();
//
//        for (Scheduled ub : list) {
//            System.out.println("Scheduled ::" + ub);
//        }
//        session.close();
//        return list;
//    }
//
//    @Override
//    public Long getScheduledCount() {
//        Session session = getSession();
//        return (Long) session.createQuery("select count(1) from  Scheduled").uniqueResult();
//    }
}
