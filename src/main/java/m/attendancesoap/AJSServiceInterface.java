package m.attendancesoap;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AJSServiceInterface {
    
    UUID addStudent(String name, String surname) throws InvalidInputException;
    UUID addSubject(String name) throws InvalidInputException;
    UUID addAttendanceList(UUID subjectId, Date date, List<Student> students) throws InvalidInputException;
    List<AttendanceList> getLists(UUID studentId) throws InvalidInputException;
    List<Student> getStudentsOnList(UUID attendanceListId) throws InvalidInputException;
    
    List<AttendanceList> getAttendanceLists();
    void removeAttendanceList(UUID attendanceListId);
    
    List<Subject> getSubjects();
    void removeSubject(UUID subjectId);
    
    List<Student> getStudents();
    void removeStudent(UUID studentId);
        
}
