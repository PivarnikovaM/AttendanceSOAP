package m.attendancesoap;

import java.util.UUID;


public interface SubjectDao {
    public UUID addSubject(String name) throws InvalidInputException;
}
