
package workflow.valider;

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
@WebServiceClient(name = "Service", targetNamespace = "http://valider.workflow", wsdlLocation = "http://localhost:8080/ServiceValider/Service/valider?wsdl")
public class Service
    extends javax.xml.ws.Service
{

    private final static URL SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(workflow.valider.Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = workflow.valider.Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/ServiceValider/Service/valider?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/ServiceValider/Service/valider?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICE_WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(SERVICE_WSDL_LOCATION, new QName("http://valider.workflow", "Service"));
    }

    /**
     * 
     * @return
     *     returns Valider
     */
    @WebEndpoint(name = "validerPort")
    public Valider getValiderPort() {
        return super.getPort(new QName("http://valider.workflow", "validerPort"), Valider.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Valider
     */
    @WebEndpoint(name = "validerPort")
    public Valider getValiderPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://valider.workflow", "validerPort"), Valider.class, features);
    }

}
