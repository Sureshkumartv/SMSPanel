/**
 * SendSmsBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.srisairam.ws;

public class SendSmsBean  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6298557276398452492L;

	private java.lang.String baseName;

    private java.lang.String basePath;

    private java.lang.String message;

    private long messageCredits;

    private org.srisairam.ws.MessageType messageType;

    private java.lang.String mobileNumbers;

    private java.lang.String scheduleDateTime;

    private java.util.Calendar scheduleTime;

    private int senderId;

    private int smppId;

    private int smppid_scrub;

    private int smppid_scrub_direct;

    private int smppid_trans_direct;

    private org.srisairam.ws.SmsSendingType smsSendingType;

    private java.lang.String uploadFilePath;

    private org.srisairam.ws.UploadTypes uploadType;

    private long usedCredits;

    public SendSmsBean() {
    }

    public SendSmsBean(
           java.lang.String baseName,
           java.lang.String basePath,
           java.lang.String message,
           long messageCredits,
           org.srisairam.ws.MessageType messageType,
           java.lang.String mobileNumbers,
           java.lang.String scheduleDateTime,
           java.util.Calendar scheduleTime,
           int senderId,
           int smppId,
           int smppid_scrub,
           int smppid_scrub_direct,
           int smppid_trans_direct,
           org.srisairam.ws.SmsSendingType smsSendingType,
           java.lang.String uploadFilePath,
           org.srisairam.ws.UploadTypes uploadType,
           long usedCredits) {
           this.baseName = baseName;
           this.basePath = basePath;
           this.message = message;
           this.messageCredits = messageCredits;
           this.messageType = messageType;
           this.mobileNumbers = mobileNumbers;
           this.scheduleDateTime = scheduleDateTime;
           this.scheduleTime = scheduleTime;
           this.senderId = senderId;
           this.smppId = smppId;
           this.smppid_scrub = smppid_scrub;
           this.smppid_scrub_direct = smppid_scrub_direct;
           this.smppid_trans_direct = smppid_trans_direct;
           this.smsSendingType = smsSendingType;
           this.uploadFilePath = uploadFilePath;
           this.uploadType = uploadType;
           this.usedCredits = usedCredits;
    }


    /**
     * Gets the baseName value for this SendSmsBean.
     * 
     * @return baseName
     */
    public java.lang.String getBaseName() {
        return baseName;
    }


    /**
     * Sets the baseName value for this SendSmsBean.
     * 
     * @param baseName
     */
    public void setBaseName(java.lang.String baseName) {
        this.baseName = baseName;
    }


    /**
     * Gets the basePath value for this SendSmsBean.
     * 
     * @return basePath
     */
    public java.lang.String getBasePath() {
        return basePath;
    }


    /**
     * Sets the basePath value for this SendSmsBean.
     * 
     * @param basePath
     */
    public void setBasePath(java.lang.String basePath) {
        this.basePath = basePath;
    }


    /**
     * Gets the message value for this SendSmsBean.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this SendSmsBean.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the messageCredits value for this SendSmsBean.
     * 
     * @return messageCredits
     */
    public long getMessageCredits() {
        return messageCredits;
    }


    /**
     * Sets the messageCredits value for this SendSmsBean.
     * 
     * @param messageCredits
     */
    public void setMessageCredits(long messageCredits) {
        this.messageCredits = messageCredits;
    }


    /**
     * Gets the messageType value for this SendSmsBean.
     * 
     * @return messageType
     */
    public org.srisairam.ws.MessageType getMessageType() {
        return messageType;
    }


    /**
     * Sets the messageType value for this SendSmsBean.
     * 
     * @param messageType
     */
    public void setMessageType(org.srisairam.ws.MessageType messageType) {
        this.messageType = messageType;
    }


    /**
     * Gets the mobileNumbers value for this SendSmsBean.
     * 
     * @return mobileNumbers
     */
    public java.lang.String getMobileNumbers() {
        return mobileNumbers;
    }


    /**
     * Sets the mobileNumbers value for this SendSmsBean.
     * 
     * @param mobileNumbers
     */
    public void setMobileNumbers(java.lang.String mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }


    /**
     * Gets the scheduleDateTime value for this SendSmsBean.
     * 
     * @return scheduleDateTime
     */
    public java.lang.String getScheduleDateTime() {
        return scheduleDateTime;
    }


    /**
     * Sets the scheduleDateTime value for this SendSmsBean.
     * 
     * @param scheduleDateTime
     */
    public void setScheduleDateTime(java.lang.String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }


    /**
     * Gets the scheduleTime value for this SendSmsBean.
     * 
     * @return scheduleTime
     */
    public java.util.Calendar getScheduleTime() {
        return scheduleTime;
    }


    /**
     * Sets the scheduleTime value for this SendSmsBean.
     * 
     * @param scheduleTime
     */
    public void setScheduleTime(java.util.Calendar scheduleTime) {
        this.scheduleTime = scheduleTime;
    }


    /**
     * Gets the senderId value for this SendSmsBean.
     * 
     * @return senderId
     */
    public int getSenderId() {
        return senderId;
    }


    /**
     * Sets the senderId value for this SendSmsBean.
     * 
     * @param senderId
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }


    /**
     * Gets the smppId value for this SendSmsBean.
     * 
     * @return smppId
     */
    public int getSmppId() {
        return smppId;
    }


    /**
     * Sets the smppId value for this SendSmsBean.
     * 
     * @param smppId
     */
    public void setSmppId(int smppId) {
        this.smppId = smppId;
    }


    /**
     * Gets the smppid_scrub value for this SendSmsBean.
     * 
     * @return smppid_scrub
     */
    public int getSmppid_scrub() {
        return smppid_scrub;
    }


    /**
     * Sets the smppid_scrub value for this SendSmsBean.
     * 
     * @param smppid_scrub
     */
    public void setSmppid_scrub(int smppid_scrub) {
        this.smppid_scrub = smppid_scrub;
    }


    /**
     * Gets the smppid_scrub_direct value for this SendSmsBean.
     * 
     * @return smppid_scrub_direct
     */
    public int getSmppid_scrub_direct() {
        return smppid_scrub_direct;
    }


    /**
     * Sets the smppid_scrub_direct value for this SendSmsBean.
     * 
     * @param smppid_scrub_direct
     */
    public void setSmppid_scrub_direct(int smppid_scrub_direct) {
        this.smppid_scrub_direct = smppid_scrub_direct;
    }


    /**
     * Gets the smppid_trans_direct value for this SendSmsBean.
     * 
     * @return smppid_trans_direct
     */
    public int getSmppid_trans_direct() {
        return smppid_trans_direct;
    }


    /**
     * Sets the smppid_trans_direct value for this SendSmsBean.
     * 
     * @param smppid_trans_direct
     */
    public void setSmppid_trans_direct(int smppid_trans_direct) {
        this.smppid_trans_direct = smppid_trans_direct;
    }


    /**
     * Gets the smsSendingType value for this SendSmsBean.
     * 
     * @return smsSendingType
     */
    public org.srisairam.ws.SmsSendingType getSmsSendingType() {
        return smsSendingType;
    }


    /**
     * Sets the smsSendingType value for this SendSmsBean.
     * 
     * @param smsSendingType
     */
    public void setSmsSendingType(org.srisairam.ws.SmsSendingType smsSendingType) {
        this.smsSendingType = smsSendingType;
    }


    /**
     * Gets the uploadFilePath value for this SendSmsBean.
     * 
     * @return uploadFilePath
     */
    public java.lang.String getUploadFilePath() {
        return uploadFilePath;
    }


    /**
     * Sets the uploadFilePath value for this SendSmsBean.
     * 
     * @param uploadFilePath
     */
    public void setUploadFilePath(java.lang.String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }


    /**
     * Gets the uploadType value for this SendSmsBean.
     * 
     * @return uploadType
     */
    public org.srisairam.ws.UploadTypes getUploadType() {
        return uploadType;
    }


    /**
     * Sets the uploadType value for this SendSmsBean.
     * 
     * @param uploadType
     */
    public void setUploadType(org.srisairam.ws.UploadTypes uploadType) {
        this.uploadType = uploadType;
    }


    /**
     * Gets the usedCredits value for this SendSmsBean.
     * 
     * @return usedCredits
     */
    public long getUsedCredits() {
        return usedCredits;
    }


    /**
     * Sets the usedCredits value for this SendSmsBean.
     * 
     * @param usedCredits
     */
    public void setUsedCredits(long usedCredits) {
        this.usedCredits = usedCredits;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSmsBean)) return false;
        SendSmsBean other = (SendSmsBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baseName==null && other.getBaseName()==null) || 
             (this.baseName!=null &&
              this.baseName.equals(other.getBaseName()))) &&
            ((this.basePath==null && other.getBasePath()==null) || 
             (this.basePath!=null &&
              this.basePath.equals(other.getBasePath()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.messageCredits == other.getMessageCredits() &&
            ((this.messageType==null && other.getMessageType()==null) || 
             (this.messageType!=null &&
              this.messageType.equals(other.getMessageType()))) &&
            ((this.mobileNumbers==null && other.getMobileNumbers()==null) || 
             (this.mobileNumbers!=null &&
              this.mobileNumbers.equals(other.getMobileNumbers()))) &&
            ((this.scheduleDateTime==null && other.getScheduleDateTime()==null) || 
             (this.scheduleDateTime!=null &&
              this.scheduleDateTime.equals(other.getScheduleDateTime()))) &&
            ((this.scheduleTime==null && other.getScheduleTime()==null) || 
             (this.scheduleTime!=null &&
              this.scheduleTime.equals(other.getScheduleTime()))) &&
            this.senderId == other.getSenderId() &&
            this.smppId == other.getSmppId() &&
            this.smppid_scrub == other.getSmppid_scrub() &&
            this.smppid_scrub_direct == other.getSmppid_scrub_direct() &&
            this.smppid_trans_direct == other.getSmppid_trans_direct() &&
            ((this.smsSendingType==null && other.getSmsSendingType()==null) || 
             (this.smsSendingType!=null &&
              this.smsSendingType.equals(other.getSmsSendingType()))) &&
            ((this.uploadFilePath==null && other.getUploadFilePath()==null) || 
             (this.uploadFilePath!=null &&
              this.uploadFilePath.equals(other.getUploadFilePath()))) &&
            ((this.uploadType==null && other.getUploadType()==null) || 
             (this.uploadType!=null &&
              this.uploadType.equals(other.getUploadType()))) &&
            this.usedCredits == other.getUsedCredits();
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
        if (getBaseName() != null) {
            _hashCode += getBaseName().hashCode();
        }
        if (getBasePath() != null) {
            _hashCode += getBasePath().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += new Long(getMessageCredits()).hashCode();
        if (getMessageType() != null) {
            _hashCode += getMessageType().hashCode();
        }
        if (getMobileNumbers() != null) {
            _hashCode += getMobileNumbers().hashCode();
        }
        if (getScheduleDateTime() != null) {
            _hashCode += getScheduleDateTime().hashCode();
        }
        if (getScheduleTime() != null) {
            _hashCode += getScheduleTime().hashCode();
        }
        _hashCode += getSenderId();
        _hashCode += getSmppId();
        _hashCode += getSmppid_scrub();
        _hashCode += getSmppid_scrub_direct();
        _hashCode += getSmppid_trans_direct();
        if (getSmsSendingType() != null) {
            _hashCode += getSmsSendingType().hashCode();
        }
        if (getUploadFilePath() != null) {
            _hashCode += getUploadFilePath().hashCode();
        }
        if (getUploadType() != null) {
            _hashCode += getUploadType().hashCode();
        }
        _hashCode += new Long(getUsedCredits()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.srisairam.org/", "sendSmsBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "basePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("messageCredits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messageCredits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.srisairam.org/", "messageType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileNumbers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobileNumbers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduleDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduleTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smppId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smppId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smppid_scrub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smppid_scrub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smppid_scrub_direct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smppid_scrub_direct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smppid_trans_direct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smppid_trans_direct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsSendingType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smsSendingType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.srisairam.org/", "smsSendingType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadFilePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uploadFilePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uploadType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.srisairam.org/", "uploadTypes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usedCredits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usedCredits"));
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
