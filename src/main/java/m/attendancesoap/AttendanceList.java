package m.attendancesoap;

import java.util.Date;


public class AttendanceList {
    
    private Long id;
    private Long idSubject;
    private Date dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
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
