
package workflow.rediger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Service", targetNamespace = "http://rediger.workflow", wsdlLocation = "http://localhost:8080/ServiceRediger/Service/rediger?wsdl")
public class Service
    extends javax.xml.ws.Service
{

    private final static URL SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(workflow.rediger.Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = workflow.rediger.Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/ServiceRediger/Service/rediger?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/ServiceRediger/Service/rediger?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICE_WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(SERVICE_WSDL_LOCATION, new QName("http://rediger.workflow", "Service"));
    }

    /**
     * 
     * @return
     *     returns Rediger
     */
    @WebEndpoint(name = "redigerPort")
    public Rediger getRedigerPort() {
        return super.getPort(new QName("http://rediger.workflow", "redigerPort"), Rediger.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Rediger
     */
    @WebEndpoint(name = "redigerPort")
    public Rediger getRedigerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://rediger.workflow", "redigerPort"), Rediger.class, features);
    }

}
