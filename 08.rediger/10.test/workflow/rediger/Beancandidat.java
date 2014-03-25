
package workflow.rediger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beancandidat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beancandidat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deroulement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriptif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processorder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beancandidat", propOrder = {
    "cv",
    "deroulement",
    "descriptif",
    "dop",
    "id",
    "intitule",
    "nom",
    "prenom",
    "processorder",
    "rh",
    "validation"
})
public class Beancandidat {

    protected String cv;
    protected String deroulement;
    protected String descriptif;
    protected String dop;
    protected int id;
    protected String intitule;
    protected String nom;
    protected String prenom;
    protected int processorder;
    protected String rh;
    protected String validation;

    /**
     * Gets the value of the cv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCv() {
        return cv;
    }

    /**
     * Sets the value of the cv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCv(String value) {
        this.cv = value;
    }

    /**
     * Gets the value of the deroulement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeroulement() {
        return deroulement;
    }

    /**
     * Sets the value of the deroulement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeroulement(String value) {
        this.deroulement = value;
    }

    /**
     * Gets the value of the descriptif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptif() {
        return descriptif;
    }

    /**
     * Sets the value of the descriptif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptif(String value) {
        this.descriptif = value;
    }

    /**
     * Gets the value of the dop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDop() {
        return dop;
    }

    /**
     * Sets the value of the dop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDop(String value) {
        this.dop = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the intitule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Sets the value of the intitule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntitule(String value) {
        this.intitule = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
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
     * Gets the value of the rh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRh() {
        return rh;
    }

    /**
     * Sets the value of the rh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRh(String value) {
        this.rh = value;
    }

    /**
     * Gets the value of the validation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidation() {
        return validation;
    }

    /**
     * Sets the value of the validation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidation(String value) {
        this.validation = value;
    }

}
