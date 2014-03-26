
package workflow.rediger;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the workflow.rediger package. 
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

    private final static QName _Execstep_QNAME = new QName("http://rediger.workflow", "execstep");
    private final static QName _ExecstepResponse_QNAME = new QName("http://rediger.workflow", "execstepResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: workflow.rediger
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExecstepResponse }
     * 
     */
    public ExecstepResponse createExecstepResponse() {
        return new ExecstepResponse();
    }

    /**
     * Create an instance of {@link Execstep }
     * 
     */
    public Execstep createExecstep() {
        return new Execstep();
    }

    /**
     * Create an instance of {@link Beancandidat }
     * 
     */
    public Beancandidat createBeancandidat() {
        return new Beancandidat();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Execstep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rediger.workflow", name = "execstep")
    public JAXBElement<Execstep> createExecstep(Execstep value) {
        return new JAXBElement<Execstep>(_Execstep_QNAME, Execstep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecstepResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rediger.workflow", name = "execstepResponse")
    public JAXBElement<ExecstepResponse> createExecstepResponse(ExecstepResponse value) {
        return new JAXBElement<ExecstepResponse>(_ExecstepResponse_QNAME, ExecstepResponse.class, null, value);
    }

}
