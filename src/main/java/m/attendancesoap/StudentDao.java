package m.attendancesoap;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    public UUID addStudent(String name, String surname);
    public List<AttendanceList> getLists(UUID studentId);

}
