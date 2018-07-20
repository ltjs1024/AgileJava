package sis.studentinfo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class StudentTest {

    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student student = new Student("Jane Doe");
        assertEquals(firstStudentName, student.getName());

        Student secondStudent = new Student("Joe Blow");
        assertEquals("Joe Blow", secondStudent.getName());

        assertEquals(firstStudentName, student.getName());
    }
}
