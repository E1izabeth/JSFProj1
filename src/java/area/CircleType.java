//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.07 at 06:25:40 PM MSK 
//


package area;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CircleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CircleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/FlatZone.xsd}ShapeType">
 *       &lt;attribute name="Quarter" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="R" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="OX" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="OY" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleType")
public class CircleType
    extends ShapeType
{

    @XmlAttribute(name = "Quarter", required = true)
    protected int quarter;
    @XmlAttribute(name = "R", required = true)
    protected double r;
    @XmlAttribute(name = "OX", required = true)
    protected double ox;
    @XmlAttribute(name = "OY", required = true)
    protected double oy;

    /**
     * Gets the value of the quarter property.
     * 
     */
    public int getQuarter() {
        return quarter;
    }

    /**
     * Sets the value of the quarter property.
     * 
     */
    public void setQuarter(int value) {
        this.quarter = value;
    }

    /**
     * Gets the value of the r property.
     * 
     */
    public double getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     */
    public void setR(double value) {
        this.r = value;
    }

    /**
     * Gets the value of the ox property.
     * 
     */
    public double getOX() {
        return ox;
    }

    /**
     * Sets the value of the ox property.
     * 
     */
    public void setOX(double value) {
        this.ox = value;
    }

    /**
     * Gets the value of the oy property.
     * 
     */
    public double getOY() {
        return oy;
    }

    /**
     * Sets the value of the oy property.
     * 
     */
    public void setOY(double value) {
        this.oy = value;
    }

}