/**
 * FileProcessServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.srisairam.ws;

public class FileProcessServiceServiceLocator extends org.apache.axis.client.Service implements org.srisairam.ws.FileProcessServiceService {

    public FileProcessServiceServiceLocator() {
    }


    public FileProcessServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FileProcessServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FileProcessServicePort
    private java.lang.String FileProcessServicePort_address = "http://localhost:9092/FILEPROCESS";

    public java.lang.String getFileProcessServicePortAddress() {
        return FileProcessServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FileProcessServicePortWSDDServiceName = "FileProcessServicePort";

    public java.lang.String getFileProcessServicePortWSDDServiceName() {
        return FileProcessServicePortWSDDServiceName;
    }

    public void setFileProcessServicePortWSDDServiceName(java.lang.String name) {
        FileProcessServicePortWSDDServiceName = name;
    }

    public org.srisairam.ws.FileProcessService getFileProcessServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FileProcessServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFileProcessServicePort(endpoint);
    }

    public org.srisairam.ws.FileProcessService getFileProcessServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.srisairam.ws.FileProcessServicePortBindingStub _stub = new org.srisairam.ws.FileProcessServicePortBindingStub(portAddress, this);
            _stub.setPortName(getFileProcessServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFileProcessServicePortEndpointAddress(java.lang.String address) {
        FileProcessServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.srisairam.ws.FileProcessService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.srisairam.ws.FileProcessServicePortBindingStub _stub = new org.srisairam.ws.FileProcessServicePortBindingStub(new java.net.URL(FileProcessServicePort_address), this);
                _stub.setPortName(getFileProcessServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FileProcessServicePort".equals(inputPortName)) {
            return getFileProcessServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.srisairam.org/", "FileProcessServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.srisairam.org/", "FileProcessServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FileProcessServicePort".equals(portName)) {
            setFileProcessServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
