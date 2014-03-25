
package workflow.accessdb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanProcess complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanProcess">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idprocess" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idregistry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processorder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanProcess", propOrder = {
    "idprocess",
    "idregistry",
    "name",
    "processorder",
    "role"
})
public class BeanProcess {

    protected int idprocess;
    protected int idregistry;
    protected String name;
    protected int processorder;
    protected String role;

    /**
     * Gets the value of the idprocess property.
     * 
     */
    public int getIdprocess() {
        return idprocess;
    }

    /**
     * Sets the value of the idprocess property.
     * 
     */
    public void setIdprocess(int value) {
        this.idprocess = value;
    }

    /**
     * Gets the value of the idregistry property.
     * 
     */
    public int getIdregistry() {
        return idregistry;
    }

    /**
     * Sets the value of the idregistry property.
     * 
     */
    public void setIdregistry(int value) {
        this.idregistry = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the processorder property.
     * 
     */
    public int getProcessorder() {
        return processorder;
    }

    /**
     * Sets the value of the processorder property.
     * 
     */
    public void setProcessorder(int value) {
        this.processorder = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

}
