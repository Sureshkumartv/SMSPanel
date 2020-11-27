/**
 * UploadFileResponce.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.srisairam.ws;

public class UploadFileResponce  implements java.io.Serializable {
    private long errorCode;

    private long fileCredits;

    private java.lang.String message;

    private long userRemaingCredits;

    public UploadFileResponce() {
    }

    public UploadFileResponce(
           long errorCode,
           long fileCredits,
           java.lang.String message,
           long userRemaingCredits) {
           this.errorCode = errorCode;
           this.fileCredits = fileCredits;
           this.message = message;
           this.userRemaingCredits = userRemaingCredits;
    }


    /**
     * Gets the errorCode value for this UploadFileResponce.
     * 
     * @return errorCode
     */
    public long getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this UploadFileResponce.
     * 
     * @param errorCode
     */
    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the fileCredits value for this UploadFileResponce.
     * 
     * @return fileCredits
     */
    public long getFileCredits() {
        return fileCredits;
    }


    /**
     * Sets the fileCredits value for this UploadFileResponce.
     * 
     * @param fileCredits
     */
    public void setFileCredits(long fileCredits) {
        this.fileCredits = fileCredits;
    }


    /**
     * Gets the message value for this UploadFileResponce.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this UploadFileResponce.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the userRemaingCredits value for this UploadFileResponce.
     * 
     * @return userRemaingCredits
     */
    public long getUserRemaingCredits() {
        return userRemaingCredits;
    }


    /**
     * Sets the userRemaingCredits value for this UploadFileResponce.
     * 
     * @param userRemaingCredits
     */
    public void setUserRemaingCredits(long userRemaingCredits) {
        this.userRemaingCredits = userRemaingCredits;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UploadFileResponce)) return false;
        UploadFileResponce other = (UploadFileResponce) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.errorCode == other.getErrorCode() &&
            this.fileCredits == other.getFileCredits() &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.userRemaingCredits == other.getUserRemaingCredits();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getErrorCode()).hashCode();
        _hashCode += new Long(getFileCredits()).hashCode();
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += new Long(getUserRemaingCredits()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UploadFileResponce.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.srisairam.org/", "uploadFileResponce"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileCredits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileCredits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userRemaingCredits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userRemaingCredits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
