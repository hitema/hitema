
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IServiceWebPublication", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IServiceWebPublication {


    /**
     * 
     * @param id
     * @param role
     * @param intitule
     * @param decription
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/IServiceWebPublication/execStep")
    @WebResult(name = "execStepResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "execStep", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecStep")
    @ResponseWrapper(localName = "execStepResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ExecStepResponse")
    public String execStep(
        @WebParam(name = "role", targetNamespace = "http://tempuri.org/")
        String role,
        @WebParam(name = "id", targetNamespace = "http://tempuri.org/")
        Integer id,
        @WebParam(name = "intitule", targetNamespace = "http://tempuri.org/")
        String intitule,
        @WebParam(name = "decription", targetNamespace = "http://tempuri.org/")
        String decription);

}
