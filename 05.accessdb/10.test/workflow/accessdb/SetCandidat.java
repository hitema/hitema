
package workflow.accessdb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setCandidat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setCandidat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="candidat" type="{http://accessdb.workflow}beancandidatDB" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCandidat", propOrder = {
    "candidat"
})
public class SetCandidat {

    protected BeancandidatDB candidat;

    /**
     * Gets the value of the candidat property.
     * 
     * @return
     *     possible object is
     *     {@link BeancandidatDB }
     *     
     */
    public BeancandidatDB getCandidat() {
        return candidat;
    }

    /**
     * Sets the value of the candidat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeancandidatDB }
     *     
     */
    public void setCandidat(BeancandidatDB value) {
        this.candidat = value;
    }

}
