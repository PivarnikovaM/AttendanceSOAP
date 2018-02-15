package m.attendancesoap;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AttendanceListDao {
    public UUID addAttendanceList(UUID subjectId,Date date, List<Student> students);
    public List<Student> getStudentsOnList(UUID attendanceListId);
    
}
