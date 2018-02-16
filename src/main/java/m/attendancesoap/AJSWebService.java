package m.attendancesoap;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService 
(serviceName = "AJSWebService")
public class AJSWebService implements AJSServiceInterface{
    
    private StudentDao studentDao = ObjectFactory.INSTANCE.studentDao();
    private SubjectDao subjectDao = ObjectFactory.INSTANCE.subjectDao();
    private AttendanceListDao attendanceListDao = ObjectFactory.INSTANCE.attendanceListDao();

    @Override
    @WebMethod
    public UUID addStudent(@WebParam(name = "name")String name, @WebParam(name = "surname")String surname) {
        return studentDao.addStudent(name, surname);
    }

    @Override
    @WebMethod
    public UUID addSubject(@WebParam(name = "name")String name) {
        return subjectDao.addSubject(name);
    }

    @Override
    @WebMethod
    public UUID addAttendanceList(@WebParam(name = "subjectId")UUID subjectId, 
            @WebParam(name = "date")Date date, @WebParam(name = "students")List<Student> students) {
        return attendanceListDao.addAttendanceList(subjectId, date, students);
    }

    @Override
    @WebMethod
    public List<AttendanceList> getLists(@WebParam(name = "studentId")UUID studentId) {
        return studentDao.getLists(studentId);
    }

    @Override
    @WebMethod
    public List<Student> getStudentsOnList(@WebParam(name = "attendanceListId")UUID attendanceListId) {
        return attendanceListDao.getStudentsOnList(attendanceListId);
    }
    
}
