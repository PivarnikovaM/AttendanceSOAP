package m.attendancesoap;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

public class AJSWebServiceTest {
    
    private final AJSWebService service;
    public AJSWebServiceTest() {
        service = new AJSWebService();
    }

    @Test
    public void testAddStudent() {
        int initialNumOfStudents = service.getStudents().size();
        
        String name = "Martina";
        String surname = "Pivarníková";
        
        UUID uuid = service.addStudent(name, surname);
        
        int newNumOfStudents = service.getStudents().size();
        
        assertEquals(initialNumOfStudents + 1, newNumOfStudents);
        
        service.removeStudent(uuid);
    }

    @Test
    public void testAddSubject() {
        int initialNumOfSubjects = service.getSubjects().size();
        
        String name = "KOPR";
    
        UUID uuid = service.addSubject(name);
        
        int newNumOfSubjects = service.getSubjects().size();
        
        assertEquals(initialNumOfSubjects + 1, newNumOfSubjects);
        
        service.removeSubject(uuid);
    }

    @Test
    public void testAddAttendanceList() {
        int initialNumOfLists = service.getAttendanceLists().size();
        
        String name = "KOPR";
        UUID uuidSubject = service.addSubject(name);
        
        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        Date date = new Date(calendar.getTime().getTime());
        
        String studentName = "Martina";
        String surname = "Pivarníková";
        
        UUID uuidStudent = service.addStudent(studentName, surname);
        
        Student s = new Student();
        s.setId(uuidStudent);
        s.setName(studentName);
        s.setSurname(surname);
        
        List<Student> students = new ArrayList<Student>();
        students.add(s);
        
        UUID uuidAttendanceList = service.addAttendanceList(uuidSubject, date, students);
        
        int newNumOfLists = service.getAttendanceLists().size();
        
        assertEquals(initialNumOfLists + 1, newNumOfLists);
        
        service.removeAttendanceList(uuidAttendanceList);
        service.removeStudent(uuidStudent);
        service.removeSubject(uuidSubject);
    }

    @Test
    public void testGetLists() {
        String name = "KOPR";
        UUID uuidSubject = service.addSubject(name);
        
        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        Date date = new Date(calendar.getTime().getTime());
        
        String studentName = "Martina";
        String surname = "Pivarníková";
        
        UUID uuidStudent = service.addStudent(studentName, surname);
        
        Student s = new Student();
        s.setId(uuidStudent);
        s.setName(studentName);
        s.setSurname(surname);
        
        List<Student> students = new ArrayList<Student>();
        students.add(s);
        
        UUID uuidAttendanceList = service.addAttendanceList(uuidSubject, date, students);
        
        
        List<AttendanceList> lists = service.getLists(uuidStudent);
        
        assertEquals(lists.get(0).getId(),uuidAttendanceList);
        
        service.removeAttendanceList(uuidAttendanceList);
        service.removeStudent(uuidStudent);
        service.removeSubject(uuidSubject);
    }

    @Test
    public void testGetStudentsOnList() {
        String name = "KOPR";
        UUID uuidSubject = service.addSubject(name);
        
        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        Date date = new Date(calendar.getTime().getTime());
        
        String studentName = "Martina";
        String surname = "Pivarníková";
        
        UUID uuidStudent = service.addStudent(studentName, surname);
        
        Student s = new Student();
        s.setId(uuidStudent);
        s.setName(studentName);
        s.setSurname(surname);
        
        List<Student> students = new ArrayList<Student>();
        students.add(s);
        
        UUID uuidAttendanceList = service.addAttendanceList(uuidSubject, date, students);
        
        List<Student> studentsOnList = service.getStudentsOnList(uuidAttendanceList);
        
        assertEquals(studentsOnList.get(0).getId(),uuidStudent);
        
        service.removeAttendanceList(uuidAttendanceList);
        service.removeStudent(uuidStudent);
        service.removeSubject(uuidSubject);
    }

    @Test
    public void testGetAttendanceLists() {
        System.out.println("getAttendanceLists");
        AJSWebService instance = new AJSWebService();
        List<AttendanceList> expResult = null;
        List<AttendanceList> result = instance.getAttendanceLists();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveAttendanceList() {
        System.out.println("removeAttendanceList");
        UUID attendanceListId = null;
        AJSWebService instance = new AJSWebService();
        instance.removeAttendanceList(attendanceListId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSubjects() {
        System.out.println("getSubjects");
        AJSWebService instance = new AJSWebService();
        List<Subject> expResult = null;
        List<Subject> result = instance.getSubjects();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveSubject() {
        System.out.println("removeSubject");
        UUID subjectId = null;
        AJSWebService instance = new AJSWebService();
        instance.removeSubject(subjectId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStudents() {
        System.out.println("getStudents");
        AJSWebService instance = new AJSWebService();
        List<Student> expResult = null;
        List<Student> result = instance.getStudents();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        UUID studentId = null;
        AJSWebService instance = new AJSWebService();
        instance.removeStudent(studentId);
        fail("The test case is a prototype.");
    }
    
}
