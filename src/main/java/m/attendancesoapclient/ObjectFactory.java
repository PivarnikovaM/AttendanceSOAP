
package m.attendancesoapclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the main.java.m.attendancesoapclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudentResponse_QNAME = new QName("http://attendancesoap.m/", "addStudentResponse");
    private final static QName _GetStudentsOnListResponse_QNAME = new QName("http://attendancesoap.m/", "getStudentsOnListResponse");
    private final static QName _AddAttendanceList_QNAME = new QName("http://attendancesoap.m/", "addAttendanceList");
    private final static QName _AddAttendanceListResponse_QNAME = new QName("http://attendancesoap.m/", "addAttendanceListResponse");
    private final static QName _GetStudentsOnList_QNAME = new QName("http://attendancesoap.m/", "getStudentsOnList");
    private final static QName _AddSubject_QNAME = new QName("http://attendancesoap.m/", "addSubject");
    private final static QName _GetLists_QNAME = new QName("http://attendancesoap.m/", "getLists");
    private final static QName _AddStudent_QNAME = new QName("http://attendancesoap.m/", "addStudent");
    private final static QName _AddSubjectResponse_QNAME = new QName("http://attendancesoap.m/", "addSubjectResponse");
    private final static QName _GetListsResponse_QNAME = new QName("http://attendancesoap.m/", "getListsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: main.java.m.attendancesoapclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddSubjectResponse }
     * 
     */
    public AddSubjectResponse createAddSubjectResponse() {
        return new AddSubjectResponse();
    }

    /**
     * Create an instance of {@link GetListsResponse }
     * 
     */
    public GetListsResponse createGetListsResponse() {
        return new GetListsResponse();
    }

    /**
     * Create an instance of {@link GetStudentsOnListResponse }
     * 
     */
    public GetStudentsOnListResponse createGetStudentsOnListResponse() {
        return new GetStudentsOnListResponse();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link AddAttendanceList }
     * 
     */
    public AddAttendanceList createAddAttendanceList() {
        return new AddAttendanceList();
    }

    /**
     * Create an instance of {@link AddAttendanceListResponse }
     * 
     */
    public AddAttendanceListResponse createAddAttendanceListResponse() {
        return new AddAttendanceListResponse();
    }

    /**
     * Create an instance of {@link AddSubject }
     * 
     */
    public AddSubject createAddSubject() {
        return new AddSubject();
    }

    /**
     * Create an instance of {@link GetStudentsOnList }
     * 
     */
    public GetStudentsOnList createGetStudentsOnList() {
        return new GetStudentsOnList();
    }

    /**
     * Create an instance of {@link GetLists }
     * 
     */
    public GetLists createGetLists() {
        return new GetLists();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AttendanceList }
     * 
     */
    public AttendanceList createAttendanceList() {
        return new AttendanceList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsOnListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "getStudentsOnListResponse")
    public JAXBElement<GetStudentsOnListResponse> createGetStudentsOnListResponse(GetStudentsOnListResponse value) {
        return new JAXBElement<GetStudentsOnListResponse>(_GetStudentsOnListResponse_QNAME, GetStudentsOnListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAttendanceList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addAttendanceList")
    public JAXBElement<AddAttendanceList> createAddAttendanceList(AddAttendanceList value) {
        return new JAXBElement<AddAttendanceList>(_AddAttendanceList_QNAME, AddAttendanceList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAttendanceListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addAttendanceListResponse")
    public JAXBElement<AddAttendanceListResponse> createAddAttendanceListResponse(AddAttendanceListResponse value) {
        return new JAXBElement<AddAttendanceListResponse>(_AddAttendanceListResponse_QNAME, AddAttendanceListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsOnList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "getStudentsOnList")
    public JAXBElement<GetStudentsOnList> createGetStudentsOnList(GetStudentsOnList value) {
        return new JAXBElement<GetStudentsOnList>(_GetStudentsOnList_QNAME, GetStudentsOnList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addSubject")
    public JAXBElement<AddSubject> createAddSubject(AddSubject value) {
        return new JAXBElement<AddSubject>(_AddSubject_QNAME, AddSubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "getLists")
    public JAXBElement<GetLists> createGetLists(GetLists value) {
        return new JAXBElement<GetLists>(_GetLists_QNAME, GetLists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "addSubjectResponse")
    public JAXBElement<AddSubjectResponse> createAddSubjectResponse(AddSubjectResponse value) {
        return new JAXBElement<AddSubjectResponse>(_AddSubjectResponse_QNAME, AddSubjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://attendancesoap.m/", name = "getListsResponse")
    public JAXBElement<GetListsResponse> createGetListsResponse(GetListsResponse value) {
        return new JAXBElement<GetListsResponse>(_GetListsResponse_QNAME, GetListsResponse.class, null, value);
    }

}
