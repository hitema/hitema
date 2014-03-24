
package workflow.registry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the workflow.registry package. 
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

    private final static QName _GetService_QNAME = new QName("http://registry.workflow", "getService");
    private final static QName _AddServiceResponse_QNAME = new QName("http://registry.workflow", "addServiceResponse");
    private final static QName _AddService_QNAME = new QName("http://registry.workflow", "addService");
    private final static QName _GetServiceResponse_QNAME = new QName("http://registry.workflow", "getServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: workflow.registry
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetService }
     * 
     */
    public GetService createGetService() {
        return new GetService();
    }

    /**
     * Create an instance of {@link AddServiceResponse }
     * 
     */
    public AddServiceResponse createAddServiceResponse() {
        return new AddServiceResponse();
    }

    /**
     * Create an instance of {@link GetServiceResponse }
     * 
     */
    public GetServiceResponse createGetServiceResponse() {
        return new GetServiceResponse();
    }

    /**
     * Create an instance of {@link AddService }
     * 
     */
    public AddService createAddService() {
        return new AddService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registry.workflow", name = "getService")
    public JAXBElement<GetService> createGetService(GetService value) {
        return new JAXBElement<GetService>(_GetService_QNAME, GetService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registry.workflow", name = "addServiceResponse")
    public JAXBElement<AddServiceResponse> createAddServiceResponse(AddServiceResponse value) {
        return new JAXBElement<AddServiceResponse>(_AddServiceResponse_QNAME, AddServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registry.workflow", name = "addService")
    public JAXBElement<AddService> createAddService(AddService value) {
        return new JAXBElement<AddService>(_AddService_QNAME, AddService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registry.workflow", name = "getServiceResponse")
    public JAXBElement<GetServiceResponse> createGetServiceResponse(GetServiceResponse value) {
        return new JAXBElement<GetServiceResponse>(_GetServiceResponse_QNAME, GetServiceResponse.class, null, value);
    }

}
