/**
 * FileProcessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.srisairam.ws;

public interface FileProcessService extends java.rmi.Remote {
    public org.srisairam.ws.UploadFileResponce processCustomUploadFile(java.lang.String arg0, java.lang.String arg1, org.srisairam.ws.SendSmsBean arg2) throws java.rmi.RemoteException, org.srisairam.ws.PanelException, org.srisairam.ws.Exception;
    public boolean saveSendSmsDetails() throws java.rmi.RemoteException;
    public org.srisairam.ws.UploadFileResponce processUploadFile(java.lang.String arg0, java.lang.String arg1, org.srisairam.ws.SendSmsBean arg2) throws java.rmi.RemoteException, org.srisairam.ws.PanelException, org.srisairam.ws.Exception;
}
