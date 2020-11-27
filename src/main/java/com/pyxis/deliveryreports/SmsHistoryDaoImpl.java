///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pyxis.deliveryreports;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
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
//public class SmsHistoryDaoImpl implements SmsHistoryDao {
//
//    private SessionFactory sessionFactory;
//
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
//    String sDate, eDate;
//
////    @Override
////    public List<SmsHistory> listRecords() {
////        System.out.println("comming here --------------------------------");
////        Session session = this.sessionFactory.openSession();
////        List<SmsHistory> pList = new ArrayList<>();
////        Calendar calEnd = Calendar.getInstance();
////        Calendar calstart = Calendar.getInstance();
////        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
////        SimpleDateFormat mySQLDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        Date sdt = null;
////        if (sdt == null) {
////            sdt = new Date();
////        }
////        calstart.setTime(sdt);
////        calstart.set(Calendar.HOUR_OF_DAY, 0);
////        calstart.set(Calendar.MINUTE, 0);
////        calstart.set(Calendar.SECOND, 0);
////        Date edt = null;
////        if (edt == null) {
////            edt = new Date();
////        }
////        calEnd.setTime(edt);
////        calEnd.set(Calendar.HOUR_OF_DAY, 23);
////        calEnd.set(Calendar.MINUTE, 59);
////        calEnd.set(Calendar.SECOND, 59);
////        sDate = mySQLDateFormat.format(calstart.getTime());
////        eDate = mySQLDateFormat.format(calEnd.getTime());
////        StringBuffer accessBuffer = new StringBuffer();
////        accessBuffer.append(" from SmsHistory where  insertedDate between '" + sDate + "' and '" + eDate + "'");
////        accessBuffer.append("order by insertedDate desc");
////        String sqlQuery = accessBuffer.toString();
////        System.out.println("*********************************");
////        System.out.println("sDate ::"+sDate);
////        System.out.println("eDate ::"+eDate);
////        System.out.println("*********************************");
////        pList = session.createQuery(sqlQuery).setMaxResults(10).list();
////        session.close();
////System.out.println("Returning object ----------------------------------------------------");
////        return pList;
////    }
//    @Override
//    public List<SmsHistory> listRecords(Integer page, Integer size) {
//        System.out.println("coming to here ********************************hhhh");
//        Session session = getSession();
////        Long count = (Long) session.createQuery("select count(1) from  SmsHistory").uniqueResult();
//        @SuppressWarnings("unchecked")
//        List<SmsHistory> list = new ArrayList<>();
//        try {
////        Criteria criteria = session.createCriteria(SmsHistory.class);
////        criteria.addOrder(Order.desc("smsSno"));
////        criteria.setFirstResult((page) * size);
////        criteria.setMaxResults(size);
//            Calendar calEnd = Calendar.getInstance();
//            Calendar calstart = Calendar.getInstance();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            SimpleDateFormat mySQLDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date sdt = null;
//            if (sdt == null) {
//                sdt = new Date();
//            }
//            calstart.setTime(sdt);
//            calstart.set(Calendar.HOUR_OF_DAY, 0);
//            calstart.set(Calendar.MINUTE, 0);
//            calstart.set(Calendar.SECOND, 0);
//            Date edt = null;
//            if (edt == null) {
//                edt = new Date();
//            }
//            calEnd.setTime(edt);
//            calEnd.set(Calendar.HOUR_OF_DAY, 23);
//            calEnd.set(Calendar.MINUTE, 59);
//            calEnd.set(Calendar.SECOND, 59);
//            sDate = mySQLDateFormat.format(calstart.getTime());
//            eDate = mySQLDateFormat.format(calEnd.getTime());
//            StringBuffer accessBuffer = new StringBuffer();
//            accessBuffer.append(" from SmsHistory where  insertedDate between '" + sDate + "' and '" + eDate + "'");
//            accessBuffer.append("order by insertedDate desc");
//            String sqlQuery = accessBuffer.toString();
//
//            System.out.println("*********************************");
//            System.out.println("sDate ::" + sDate);
//            System.out.println("eDate ::" + eDate);
//            System.out.println("*********************************");
//
//            list = session.createQuery(sqlQuery).setMaxResults(10).list();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        for (SmsHistory ub : list) {
//            System.out.println("SmsHistory ::" + ub);
//        }
//        session.close();
//        return list;
//    }
//
//    @Override
//    public Long getSmsHistoryCount() {
//        Session session = getSession();
//        return (Long) session.createQuery("select count(1) from  SmsHistory").uniqueResult();
//    }
//
//}
