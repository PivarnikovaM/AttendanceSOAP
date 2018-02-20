package m.attendancesoap;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    public UUID addStudent(String name, String surname) throws InvalidInputException;
    public List<AttendanceList> getLists(UUID studentId) throws InvalidInputException;
    public List<Student> getStudents();
    public void removeStudent(UUID studentId);

}
