
package workflow.orchestrator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the workflow.orchestrator package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StartprocessResponse_QNAME = new QName("http://orchestrator.workflow", "startprocessResponse");
    private final static QName _Startprocess_QNAME = new QName("http://orchestrator.workflow", "startprocess");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: workflow.orchestrator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Startprocess }
     * 
     */
    public Startprocess createStartprocess() {
        return new Startprocess();
    }

    /**
     * Create an instance of {@link StartprocessResponse }
     * 
     */
    public StartprocessResponse createStartprocessResponse() {
        return new StartprocessResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartprocessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orchestrator.workflow", name = "startprocessResponse")
    public JAXBElement<StartprocessResponse> createStartprocessResponse(StartprocessResponse value) {
        return new JAXBElement<StartprocessResponse>(_StartprocessResponse_QNAME, StartprocessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Startprocess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orchestrator.workflow", name = "startprocess")
    public JAXBElement<Startprocess> createStartprocess(Startprocess value) {
        return new JAXBElement<Startprocess>(_Startprocess_QNAME, Startprocess.class, null, value);
    }

}
