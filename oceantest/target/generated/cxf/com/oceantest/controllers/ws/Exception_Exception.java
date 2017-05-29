
package com.oceantest.controllers.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.13
 * 2016-07-06T08:53:35.847+07:00
 * Generated source version: 2.7.13
 */

@WebFault(name = "Exception", targetNamespace = "http://ws.controllers.oceantest.com/")
public class Exception_Exception extends java.lang.Exception {
    
    private com.oceantest.controllers.ws.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, com.oceantest.controllers.ws.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, com.oceantest.controllers.ws.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public com.oceantest.controllers.ws.Exception getFaultInfo() {
        return this.exception;
    }
}