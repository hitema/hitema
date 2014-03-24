
package workflow.accessdb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the workflow.accessdb package. 
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

    private final static QName _GetListstepResponse_QNAME = new QName("http://accessdb.workflow", "getListstepResponse");
    private final static QName _GetListstep_QNAME = new QName("http://accessdb.workflow", "getListstep");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: workflow.accessdb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetListstep }
     * 
     */
    public GetListstep createGetListstep() {
        return new GetListstep();
    }

    /**
     * Create an instance of {@link GetListstepResponse }
     * 
     */
    public GetListstepResponse createGetListstepResponse() {
        return new GetListstepResponse();
    }

    /**
     * Create an instance of {@link BeanProcess }
     * 
     */
    public BeanProcess createBeanProcess() {
        return new BeanProcess();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListstepResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://accessdb.workflow", name = "getListstepResponse")
    public JAXBElement<GetListstepResponse> createGetListstepResponse(GetListstepResponse value) {
        return new JAXBElement<GetListstepResponse>(_GetListstepResponse_QNAME, GetListstepResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListstep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://accessdb.workflow", name = "getListstep")
    public JAXBElement<GetListstep> createGetListstep(GetListstep value) {
        return new JAXBElement<GetListstep>(_GetListstep_QNAME, GetListstep.class, null, value);
    }

}
