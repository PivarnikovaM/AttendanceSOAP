package m.attendancesoap;

import java.util.List;
import java.util.UUID;


public interface SubjectDao {
    public UUID addSubject(String name) throws InvalidInputException;
    public List<Subject> getSubjects();
    public void removeSubject(UUID subjectId);
}
