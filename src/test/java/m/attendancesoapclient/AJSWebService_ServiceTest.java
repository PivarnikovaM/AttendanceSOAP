package m.attendancesoapclient;

import javax.xml.ws.WebServiceFeature;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martinapivarnikova
 */
public class AJSWebService_ServiceTest {
    
    public AJSWebService_ServiceTest() {
    }

    @Test
    public void testGetAJSWebServicePort() {
        System.out.println("getAJSWebServicePort");
        AJSWebService_Service instance = new AJSWebService_Service();
        AJSWebService expResult = null;
        AJSWebService result = instance.getAJSWebServicePort();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAJSWebServicePort_WebServiceFeatureArr() {
        System.out.println("getAJSWebServicePort");
        WebServiceFeature[] features = null;
        AJSWebService_Service instance = new AJSWebService_Service();
        AJSWebService expResult = null;
        AJSWebService result = instance.getAJSWebServicePort(features);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
