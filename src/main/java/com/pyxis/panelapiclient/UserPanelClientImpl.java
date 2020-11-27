package com.pyxis.panelapiclient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.srisairam.http.HttpResponce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.srisairam.enums.RequestParamNames;
import org.srisairam.enums.UserMethods;
import org.srisairam.utils.UserPanelClient;

/**
 *
 * @author ssit
 */
public class UserPanelClientImpl implements UserPanelClient {

    private String url;
    private String userName, pwd;
    private String accessFrom;

    public UserPanelClientImpl(String url, String userName, String pwd) {
        this.url = url;
        this.userName = userName;
        this.pwd = pwd;
    }

    public UserPanelClientImpl(String url, String userName, String pwd, String accessFrom) {
        this.url = url;
        this.userName = userName;
        this.pwd = pwd;
        this.accessFrom = accessFrom;
    }

    private String urlHitting(String hittingUrl) {
        BufferedReader br = null;
        try {
            URL urlobj = new URL(hittingUrl);
            URLConnection objHttpURL = urlobj.openConnection();
            br = new BufferedReader(new InputStreamReader(objHttpURL.getInputStream()));
            String strTemp, strLine = null;
            objHttpURL.connect();
            while ((strTemp = br.readLine()) != null) {
                if (strLine == null) {
                    strLine = strTemp;
                } else {
                    strLine = strLine + " " + strTemp;
                }
            }
            return strLine;
        } catch (Exception ex) {
            System.out.println("exception while hitting url:::" + ex.getMessage());
        }
        return "";
    }

    public HttpResponce parseResponce(String responce) {
        if (responce != null && responce.trim().length() > 0) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(HttpResponce.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                HttpResponce respObj = (HttpResponce) jaxbUnmarshaller.unmarshal(new StringReader(responce));
                return respObj;
            } catch (JAXBException ex) {
                System.out.println("exception while Parsing XML responce :::" + ex.getMessage());
            }

        }
        return null;
    }

    public HttpResponce addUser(String userid) {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.ADDUSR;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        hittingUrl += "&" + RequestParamNames.userid + "=" + userid;
        String urlResponce = urlHitting(hittingUrl);

        return parseResponce(urlResponce);

    }

    public HttpResponce editUser(String userid) {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.ADDUSR;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        hittingUrl += "&" + RequestParamNames.userid + "=" + userid;
        String urlResponce = urlHitting(hittingUrl);

        return parseResponce(urlResponce);
    }

    public HttpResponce addUsedCredits(long crdits) {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.INCR;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        hittingUrl += "&" + RequestParamNames.credits + "=" + crdits;
        String urlResponce = urlHitting(hittingUrl);

        return parseResponce(urlResponce);
    }

    public HttpResponce getCredits() {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.GETCR;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlResponce = urlHitting(hittingUrl);

        return parseResponce(urlResponce);
    }

    public HttpResponce login() {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.LOGIN;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlResponce = urlHitting(hittingUrl);
        return parseResponce(urlResponce);
    }

    public HttpResponce loadSenderIds() {
        String hittingUrl = this.url + "?" + RequestParamNames.method + "=" + UserMethods.LOADSENDERID;
        hittingUrl += "&" + RequestParamNames.username + "=" + userName;
        try {
            hittingUrl += "&" + RequestParamNames.pwd + "=" + URLEncoder.encode(pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserPanelClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlResponce = urlHitting(hittingUrl);
        return parseResponce(urlResponce);
    }

    public HttpResponce addCredits(long l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

