
package workflow.interviewerrh;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for execstep complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="execstep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beancandidat" type="{http://interviewerRH.workflow}beancandidat" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "execstep", propOrder = {
    "role",
    "beancandidat"
})
public class Execstep {

    protected String role;
    protected Beancandidat beancandidat;

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

    /**
     * Gets the value of the beancandidat property.
     * 
     * @return
     *     possible object is
     *     {@link Beancandidat }
     *     
     */
    public Beancandidat getBeancandidat() {
        return beancandidat;
    }

    /**
     * Sets the value of the beancandidat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beancandidat }
     *     
     */
    public void setBeancandidat(Beancandidat value) {
        this.beancandidat = value;
    }

}
