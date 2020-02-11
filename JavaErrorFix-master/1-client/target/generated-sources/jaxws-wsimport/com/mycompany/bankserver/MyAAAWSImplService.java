
package com.mycompany.bankserver;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MyAAAWSImplService", targetNamespace = "http://bankserver.mycompany.com/", wsdlLocation = "http://localhost:9001/MyAAAWS?wsdl")
public class MyAAAWSImplService
    extends Service
{

    private final static URL MYAAAWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MYAAAWSIMPLSERVICE_EXCEPTION;
    private final static QName MYAAAWSIMPLSERVICE_QNAME = new QName("http://bankserver.mycompany.com/", "MyAAAWSImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9001/MyAAAWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYAAAWSIMPLSERVICE_WSDL_LOCATION = url;
        MYAAAWSIMPLSERVICE_EXCEPTION = e;
    }

    public MyAAAWSImplService() {
        super(__getWsdlLocation(), MYAAAWSIMPLSERVICE_QNAME);
    }

    public MyAAAWSImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYAAAWSIMPLSERVICE_QNAME, features);
    }

    public MyAAAWSImplService(URL wsdlLocation) {
        super(wsdlLocation, MYAAAWSIMPLSERVICE_QNAME);
    }

    public MyAAAWSImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYAAAWSIMPLSERVICE_QNAME, features);
    }

    public MyAAAWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyAAAWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MyAAAWSInterface
     */
    @WebEndpoint(name = "MyAAAWSImplPort")
    public MyAAAWSInterface getMyAAAWSImplPort() {
        return super.getPort(new QName("http://bankserver.mycompany.com/", "MyAAAWSImplPort"), MyAAAWSInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyAAAWSInterface
     */
    @WebEndpoint(name = "MyAAAWSImplPort")
    public MyAAAWSInterface getMyAAAWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bankserver.mycompany.com/", "MyAAAWSImplPort"), MyAAAWSInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYAAAWSIMPLSERVICE_EXCEPTION!= null) {
            throw MYAAAWSIMPLSERVICE_EXCEPTION;
        }
        return MYAAAWSIMPLSERVICE_WSDL_LOCATION;
    }

}
