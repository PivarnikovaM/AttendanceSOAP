
package m.attendancesoapclient;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AJSWebService", targetNamespace = "http://attendancesoap.m/", wsdlLocation = "http://localhost:8188/ajs?wsdl")
public class AJSWebService_Service
    extends Service
{

    private final static URL AJSWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException AJSWEBSERVICE_EXCEPTION;
    private final static QName AJSWEBSERVICE_QNAME = new QName("http://attendancesoap.m/", "AJSWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8188/ajs?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AJSWEBSERVICE_WSDL_LOCATION = url;
        AJSWEBSERVICE_EXCEPTION = e;
    }

    public AJSWebService_Service() {
        super(__getWsdlLocation(), AJSWEBSERVICE_QNAME);
    }

    public AJSWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), AJSWEBSERVICE_QNAME, features);
    }

    public AJSWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, AJSWEBSERVICE_QNAME);
    }

    public AJSWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AJSWEBSERVICE_QNAME, features);
    }

    public AJSWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AJSWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AJSWebService
     */
    @WebEndpoint(name = "AJSWebServicePort")
    public AJSWebService getAJSWebServicePort() {
        return super.getPort(new QName("http://attendancesoap.m/", "AJSWebServicePort"), AJSWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AJSWebService
     */
    @WebEndpoint(name = "AJSWebServicePort")
    public AJSWebService getAJSWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://attendancesoap.m/", "AJSWebServicePort"), AJSWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AJSWEBSERVICE_EXCEPTION!= null) {
            throw AJSWEBSERVICE_EXCEPTION;
        }
        return AJSWEBSERVICE_WSDL_LOCATION;
    }

}
