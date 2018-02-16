package m.attendancesoap;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AJSServiceInterface {
    
    UUID addStudent(String name, String surname);
    UUID addSubject(String name);
    UUID addAttendanceList(UUID subjectId, Date date, List<Student> students);
    List<AttendanceList> getLists(UUID studentId);
    List<Student> getStudentsOnList(UUID attendanceListId);
        
}
