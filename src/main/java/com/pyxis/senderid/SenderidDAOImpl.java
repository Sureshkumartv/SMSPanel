/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

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
public class SenderidDAOImpl implements SenderidDAO {

    private SessionFactory sessionFactory;


    public Session getSession() {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (Exception ex) {
            session = this.sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public void addRecord(Senderid s) {
        Session session = getSession();
        session.persist(s);
        session.close();
        System.out.println("Record Created Successfully");
    }

    @Override
    public void updateRecord(int id) {
        Session session = getSession();
        Senderid s = getById(id);
        session.update(s);
        session.close();
        System.out.println("Record Updated Successfully");
    }

    @Override
    public void deleteRecord(int id) {
        Session session = getSession();
        Senderid s = getById(id);
        session.delete(s);
        session.close();
        System.out.println("Record Deleted Successfully ");
    }

    @Override
    public Senderid getById(int id) {
        Session session = getSession();
        Senderid s = (Senderid) session.load(Senderid.class, id);
        session.close();
        return s;
    }

    @Override
    public List<Senderid> listRecords() {
        Session session = getSession();
        List<Senderid> list = null;
        Criteria cr = null;
        cr = session.createCriteria(Senderid.class);
        cr.setFirstResult(1);
        cr.setMaxResults(10);

        list = cr.list();
        session.close();
        return list;
    }

    @Override
    public List<Senderid> listRecords(Integer page, Integer size) {
        Session session = getSession();
        Long count = (Long) session.createQuery("select count(1) from  Senderid").uniqueResult();
        StringBuffer sb = new StringBuffer();
//        sb.append("from (Senderid sid inner join UserSenderID usd on usd.senderId=sid.senderid)  inner join Users lu on (lu.userid = usd.userId) where lu.userid = usd.userId " );

        Criteria criteria = session.createCriteria(Senderid.class);
        criteria.addOrder(Order.desc("senderid"));
        criteria.setFirstResult((page) * size);
        criteria.setMaxResults(size);

        @SuppressWarnings("unchecked")
        List<Senderid> list = criteria.list();

        for (Senderid ub : list) {
            System.out.println("Senderid ::" + ub);
        }
        session.close();
        return list;
    }

    @Override
    public Long getSenderidsCount() {
        Session session = getSession();
        return (Long) session.createQuery("select count(1) from  Senderid").uniqueResult();
    }

}
