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
 * <p>Java class for TriangleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TriangleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/FlatZone.xsd}ShapeType">
 *       &lt;attribute name="X1" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Y1" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="X2" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Y2" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="X3" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Y3" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriangleType")
public class TriangleType
    extends ShapeType
{

    @XmlAttribute(name = "X1", required = true)
    protected double x1;
    @XmlAttribute(name = "Y1", required = true)
    protected double y1;
    @XmlAttribute(name = "X2", required = true)
    protected double x2;
    @XmlAttribute(name = "Y2", required = true)
    protected double y2;
    @XmlAttribute(name = "X3", required = true)
    protected double x3;
    @XmlAttribute(name = "Y3", required = true)
    protected double y3;

    /**
     * Gets the value of the x1 property.
     * 
     */
    public double getX1() {
        return x1;
    }

    /**
     * Sets the value of the x1 property.
     * 
     */
    public void setX1(double value) {
        this.x1 = value;
    }

    /**
     * Gets the value of the y1 property.
     * 
     */
    public double getY1() {
        return y1;
    }

    /**
     * Sets the value of the y1 property.
     * 
     */
    public void setY1(double value) {
        this.y1 = value;
    }

    /**
     * Gets the value of the x2 property.
     * 
     */
    public double getX2() {
        return x2;
    }

    /**
     * Sets the value of the x2 property.
     * 
     */
    public void setX2(double value) {
        this.x2 = value;
    }

    /**
     * Gets the value of the y2 property.
     * 
     */
    public double getY2() {
        return y2;
    }

    /**
     * Sets the value of the y2 property.
     * 
     */
    public void setY2(double value) {
        this.y2 = value;
    }

    /**
     * Gets the value of the x3 property.
     * 
     */
    public double getX3() {
        return x3;
    }

    /**
     * Sets the value of the x3 property.
     * 
     */
    public void setX3(double value) {
        this.x3 = value;
    }

    /**
     * Gets the value of the y3 property.
     * 
     */
    public double getY3() {
        return y3;
    }

    /**
     * Sets the value of the y3 property.
     * 
     */
    public void setY3(double value) {
        this.y3 = value;
    }

}
