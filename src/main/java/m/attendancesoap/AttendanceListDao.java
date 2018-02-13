package m.attendancesoap;

import java.util.Date;
import java.util.List;

public interface AttendanceListDao {
    public Long addAttendanceList(int subjectId,Date date, List<Student> students);
    public List<Student> getStudentsOnList(AttendanceList attendanceList);
    
}
