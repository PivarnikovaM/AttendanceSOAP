package m.attendancesoap;

import java.util.Date;
import java.util.UUID;


public class AttendanceList {
    
    private UUID id;
    private UUID idSubject;
    private Date dateTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(UUID idSubject) {
        this.idSubject = idSubject;
    }
    

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "" + id + " " + idSubject + " " + dateTime;
    }
    
    
}
