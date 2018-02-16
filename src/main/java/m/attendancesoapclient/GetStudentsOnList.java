
package m.attendancesoapclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentsOnList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentsOnList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attendanceListId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentsOnList", propOrder = {
    "attendanceListId"
})
public class GetStudentsOnList {

    protected String attendanceListId;

    /**
     * Gets the value of the attendanceListId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttendanceListId() {
        return attendanceListId;
    }

    /**
     * Sets the value of the attendanceListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttendanceListId(String value) {
        this.attendanceListId = value;
    }

}
