package m.attendancesoap;

import java.util.List;

public interface StudentDao {

    public Long addStudent(String name, String surname);
    public List<AttendanceList> getLists(Student student);

}
