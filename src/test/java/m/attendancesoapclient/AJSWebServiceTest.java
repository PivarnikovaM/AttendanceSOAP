package m.attendancesoapclient;

import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class AJSWebServiceTest {

    AJSWebService_Service service;
    AJSWebService s;

    public AJSWebServiceTest() {
        service = new AJSWebService_Service();
        s = service.getAJSWebServicePort();
    }

    @Test
    public void testAddStudent() {
        int initialNumOfStudents = s.getStudents().size();

        String name = "Martina";
        String surname = "Pivarníková";
        
        String uuiid = s.addStudent(name, surname);
        
        int newNumOfStudents = s.getStudents().size();

        assertEquals(initialNumOfStudents + 1, newNumOfStudents);

        s.removeStudent(uuiid);
    }

    @Test
    public void testAddSubject() {
        int initialNumOfSubjects = s.getSubjects().size();

        String name = "KOPR";

        String uuid = s.addSubject(name);

        int newNumOfSubjects = s.getSubjects().size();

        assertEquals(initialNumOfSubjects + 1, newNumOfSubjects);

        s.removeSubject(uuid);
    }

    @Test
    public void testAddAttendanceList() {
        int initialNumOfLists = s.getAttendanceLists().size();

        String name = "KOPR";
        String uuidSubject = s.addSubject(name);

        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        
        XMLGregorianCalendar xMLGregorianCalendar = null;
        try {
            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            //
        }

        String studentName = "Martina";
        String surname = "Pivarníková";

        String uuidStudent = s.addStudent(studentName, surname);

        Student student = new Student();
        student.setId(uuidStudent);
        student.setName(studentName);
        student.setSurname(surname);

        List<Student> students = new ArrayList<Student>();
        students.add(student);

        String uuidAttendanceList = s.addAttendanceList(uuidSubject, xMLGregorianCalendar, students);

        int newNumOfLists = s.getAttendanceLists().size();

        assertEquals(initialNumOfLists + 1, newNumOfLists);

        s.removeAttendanceList(uuidAttendanceList);
        s.removeStudent(uuidStudent);
        s.removeSubject(uuidSubject);
    }

    @Test
    public void testGetLists() {
        String name = "KOPR";
        String uuidSubject = s.addSubject(name);

        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
         XMLGregorianCalendar xMLGregorianCalendar = null;
        try {
            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            //
        }

        String studentName = "Martina";
        String surname = "Pivarníková";

        String uuidStudent = s.addStudent(studentName, surname);

        Student student = new Student();
        student.setId(uuidStudent);
        student.setName(studentName);
        student.setSurname(surname);

        List<Student> students = new ArrayList<Student>();
        students.add(student);

        String uuidAttendanceList = s.addAttendanceList(uuidSubject, xMLGregorianCalendar, students);

        List<AttendanceList> lists = s.getLists(uuidStudent);

        assertEquals(lists.get(0).getId(), uuidAttendanceList);

        s.removeAttendanceList(uuidAttendanceList);
        s.removeStudent(uuidStudent);
        s.removeSubject(uuidSubject);
    }

    @Test
    public void testGetStudentsOnList() {
        String name = "KOPR";
        String uuidSubject = s.addSubject(name);

        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
         XMLGregorianCalendar xMLGregorianCalendar = null;
        try {
            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            //
        }
        String studentName = "Martina";
        String surname = "Pivarníková";

        String uuidStudent = s.addStudent(studentName, surname);

        Student student = new Student();
        student.setId(uuidStudent);
        student.setName(studentName);
        student.setSurname(surname);

        List<Student> students = new ArrayList<Student>();
        students.add(student);

        String uuidAttendanceList = s.addAttendanceList(uuidSubject, xMLGregorianCalendar, students);

        List<Student> studentsOnList = s.getStudentsOnList(uuidAttendanceList);

        assertEquals(studentsOnList.get(0).getId(), uuidStudent);

        s.removeAttendanceList(uuidAttendanceList);
        s.removeStudent(uuidStudent);
        s.removeSubject(uuidSubject);
    }

    @Test
    public void testGetAttendanceLists() {
         String name = "KOPR";
        String uuidSubject = s.addSubject(name);

        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        XMLGregorianCalendar xMLGregorianCalendar = null;
        try {
            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            //
        }
        String studentName = "Martina";
        String surname = "Pivarníková";

        String uuidStudent = s.addStudent(studentName, surname);

        Student student = new Student();
        student.setId(uuidStudent);
        student.setName(studentName);
        student.setSurname(surname);

        List<Student> students = new ArrayList<Student>();
        students.add(student);

        String uuidAttendanceList = s.addAttendanceList(uuidSubject, xMLGregorianCalendar, students);
        List<AttendanceList> attendanceLists = s.getAttendanceLists();

        assertTrue(attendanceLists.size() > 0);

        s.removeAttendanceList(uuidAttendanceList);
        s.removeStudent(uuidStudent);
        s.removeSubject(uuidSubject);
    }

    @Test
    public void testRemoveAttendanceList() {
        int initialNumOfLists = s.getAttendanceLists().size();

        String name = "KOPR";
        String uuidSubject = s.addSubject(name);

        int year = 2018;
        int month = 2;
        int day = 10;
        int hour = 6;
        int min = 30;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, min);
        XMLGregorianCalendar xMLGregorianCalendar = null;
        try {
            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            //
        }
        String studentName = "Martina";
        String surname = "Pivarníková";

        String uuidStudent = s.addStudent(studentName, surname);

        Student student = new Student();
        student.setId(uuidStudent);
        student.setName(studentName);
        student.setSurname(surname);

        List<Student> students = new ArrayList<Student>();
        students.add(student);

        String uuidAttendanceList = s.addAttendanceList(uuidSubject, xMLGregorianCalendar, students);

        s.removeAttendanceList(uuidAttendanceList);

        int newNumOfLists = s.getAttendanceLists().size();

        assertEquals(initialNumOfLists, newNumOfLists);

        s.removeStudent(uuidStudent);
        s.removeSubject(uuidSubject);
    }

    @Test
    public void testGetSubjects() {
        String name = "KOPR";

        String uuid = s.addSubject(name);

        List<Subject> subjects = s.getSubjects();
        assertTrue(subjects.size() > 0);

        s.removeSubject(uuid);
    }

    @Test
    public void testRemoveSubject() {
        int initialNumOfSubjects = s.getSubjects().size();

        String name = "KOPR";

        String uuid = s.addSubject(name);
        s.removeSubject(uuid);

        int newNumOfSubjects = s.getSubjects().size();
        assertEquals(initialNumOfSubjects,newNumOfSubjects);
    }

    @Test
    public void testGetStudents() {
        String name = "Martina";
        String surname = "Pivarníková";

        String uuid = s.addStudent(name, surname);
        List<Student> students = s.getStudents();
        

        assertTrue(students.size() > 0);

        s.removeStudent(uuid);
    }

    @Test
    public void testRemoveStudent() {
       int initialNumOfStudents = s.getStudents().size();

        String name = "Martina";
        String surname = "Pivarníková";

        String uuid = s.addStudent(name, surname);
        s.removeStudent(uuid);

        int newNumOfStudents = s.getStudents().size();

        assertEquals(initialNumOfStudents, newNumOfStudents);
    }

}
