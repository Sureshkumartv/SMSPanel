package org.srisairam.ws;

public class FileProcessServiceProxy implements org.srisairam.ws.FileProcessService {
  private String _endpoint = null;
  private org.srisairam.ws.FileProcessService fileProcessService = null;
  
  public FileProcessServiceProxy() {
    _initFileProcessServiceProxy();
  }
  
  public FileProcessServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFileProcessServiceProxy();
  }
  
  private void _initFileProcessServiceProxy() {
    try {
      fileProcessService = (new org.srisairam.ws.FileProcessServiceServiceLocator()).getFileProcessServicePort();
      if (fileProcessService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fileProcessService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fileProcessService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fileProcessService != null)
      ((javax.xml.rpc.Stub)fileProcessService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.srisairam.ws.FileProcessService getFileProcessService() {
    if (fileProcessService == null)
      _initFileProcessServiceProxy();
    return fileProcessService;
  }
  
  public org.srisairam.ws.UploadFileResponce processCustomUploadFile(java.lang.String arg0, java.lang.String arg1, org.srisairam.ws.SendSmsBean arg2) throws java.rmi.RemoteException, org.srisairam.ws.PanelException, org.srisairam.ws.Exception{
    if (fileProcessService == null)
      _initFileProcessServiceProxy();
    return fileProcessService.processCustomUploadFile(arg0, arg1, arg2);
  }
  
  public boolean saveSendSmsDetails() throws java.rmi.RemoteException{
    if (fileProcessService == null)
      _initFileProcessServiceProxy();
    return fileProcessService.saveSendSmsDetails();
  }
  
  public org.srisairam.ws.UploadFileResponce processUploadFile(java.lang.String arg0, java.lang.String arg1, org.srisairam.ws.SendSmsBean arg2) throws java.rmi.RemoteException, org.srisairam.ws.PanelException, org.srisairam.ws.Exception{
    if (fileProcessService == null)
      _initFileProcessServiceProxy();
    return fileProcessService.processUploadFile(arg0, arg1, arg2);
  }
  
  
}