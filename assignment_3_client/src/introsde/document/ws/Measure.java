
package introsde.document.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for measure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="measure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateRegistered" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="measureValueType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measure", propOrder = {
    "dateRegistered",
    "measureType",
    "measureValue",
    "measureValueType",
    "mid"
})
public class Measure {

    protected String dateRegistered;
    protected String measureType;
    protected double measureValue;
    protected String measureValueType;
    protected int mid;

    /**
     * Gets the value of the dateRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRegistered() {
        return dateRegistered;
    }

    /**
     * Sets the value of the dateRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRegistered(String value) {
        this.dateRegistered = value;
    }

    /**
     * Gets the value of the measureType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureType() {
        return measureType;
    }

    /**
     * Sets the value of the measureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureType(String value) {
        this.measureType = value;
    }

    /**
     * Gets the value of the measureValue property.
     * 
     */
    public double getMeasureValue() {
        return measureValue;
    }

    /**
     * Sets the value of the measureValue property.
     * 
     */
    public void setMeasureValue(double value) {
        this.measureValue = value;
    }

    /**
     * Gets the value of the measureValueType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureValueType() {
        return measureValueType;
    }

    /**
     * Sets the value of the measureValueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureValueType(String value) {
        this.measureValueType = value;
    }

    /**
     * Gets the value of the mid property.
     * 
     */
    public int getMid() {
        return mid;
    }

    /**
     * Sets the value of the mid property.
     * 
     */
    public void setMid(int value) {
        this.mid = value;
    }

}
