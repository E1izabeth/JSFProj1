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
 * <p>Java class for RectangleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RectangleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/FlatZone.xsd}ShapeType">
 *       &lt;attribute name="X" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Y" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="W" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="H" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RectangleType")
public class RectangleType
    extends ShapeType
{

    @XmlAttribute(name = "X", required = true)
    protected double x;
    @XmlAttribute(name = "Y", required = true)
    protected double y;
    @XmlAttribute(name = "W", required = true)
    protected double w;
    @XmlAttribute(name = "H", required = true)
    protected double h;

    /**
     * Gets the value of the x property.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

    /**
     * Gets the value of the w property.
     * 
     */
    public double getW() {
        return w;
    }

    /**
     * Sets the value of the w property.
     * 
     */
    public void setW(double value) {
        this.w = value;
    }

    /**
     * Gets the value of the h property.
     * 
     */
    public double getH() {
        return h;
    }

    /**
     * Sets the value of the h property.
     * 
     */
    public void setH(double value) {
        this.h = value;
    }

}
