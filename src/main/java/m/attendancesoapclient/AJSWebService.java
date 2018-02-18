
package m.attendancesoapclient;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AJSWebService", targetNamespace = "http://attendancesoap.m/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AJSWebService {


    /**
     * 
     * @param studentId
     * @return
     *     returns java.util.List<m.attendancesoapclient.AttendanceList>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLists", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.GetLists")
    @ResponseWrapper(localName = "getListsResponse", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.GetListsResponse")
    @Action(input = "http://attendancesoap.m/AJSWebService/getListsRequest", output = "http://attendancesoap.m/AJSWebService/getListsResponse")
    public List<AttendanceList> getLists(
        @WebParam(name = "studentId", targetNamespace = "")
        String studentId);

    /**
     * 
     * @param surname
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddStudentResponse")
    @Action(input = "http://attendancesoap.m/AJSWebService/addStudentRequest", output = "http://attendancesoap.m/AJSWebService/addStudentResponse")
    public String addStudent(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "surname", targetNamespace = "")
        String surname);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addSubject", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddSubject")
    @ResponseWrapper(localName = "addSubjectResponse", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddSubjectResponse")
    @Action(input = "http://attendancesoap.m/AJSWebService/addSubjectRequest", output = "http://attendancesoap.m/AJSWebService/addSubjectResponse")
    public String addSubject(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param date
     * @param students
     * @param subjectId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addAttendanceList", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddAttendanceList")
    @ResponseWrapper(localName = "addAttendanceListResponse", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.AddAttendanceListResponse")
    @Action(input = "http://attendancesoap.m/AJSWebService/addAttendanceListRequest", output = "http://attendancesoap.m/AJSWebService/addAttendanceListResponse")
    public String addAttendanceList(
        @WebParam(name = "subjectId", targetNamespace = "")
        String subjectId,
        @WebParam(name = "date", targetNamespace = "")
        XMLGregorianCalendar date,
        @WebParam(name = "students", targetNamespace = "")
        List<Student> students);

    /**
     * 
     * @param attendanceListId
     * @return
     *     returns java.util.List<m.attendancesoapclient.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentsOnList", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.GetStudentsOnList")
    @ResponseWrapper(localName = "getStudentsOnListResponse", targetNamespace = "http://attendancesoap.m/", className = "m.attendancesoapclient.GetStudentsOnListResponse")
    @Action(input = "http://attendancesoap.m/AJSWebService/getStudentsOnListRequest", output = "http://attendancesoap.m/AJSWebService/getStudentsOnListResponse")
    public List<Student> getStudentsOnList(
        @WebParam(name = "attendanceListId", targetNamespace = "")
        String attendanceListId);

}