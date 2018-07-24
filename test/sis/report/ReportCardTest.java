package sis.report;

import org.junit.Before;
import org.junit.Test;
import sis.studentinfo.Student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class ReportCardTest {

    private ReportCard card;

    @Before
    public void setUp() {
        card = new ReportCard();
    }

    @Test
    public void testMessage() {
        assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
    }

    @Test
    public void testKeys() {
        Set<Student.Grade> expectedGrades = new HashSet<>();
        expectedGrades.add(Student.Grade.A);
        expectedGrades.add(Student.Grade.B);
        expectedGrades.add(Student.Grade.C);
        expectedGrades.add(Student.Grade.D);
        expectedGrades.add(Student.Grade.F);


        Set<Student.Grade> grades = new HashSet<>();
        for (Student.Grade grade : card.getMessages().keySet()) {
            grades.add(grade);
        }
        assertEquals(expectedGrades, grades);
    }


    @Test
    public void testValues() {
        Set<String> expectedGrades = new HashSet<>();
        expectedGrades.add(ReportCard.A_MESSAGE);
        expectedGrades.add(ReportCard.B_MESSAGE);
        expectedGrades.add(ReportCard.C_MESSAGE);
        expectedGrades.add(ReportCard.D_MESSAGE);
        expectedGrades.add(ReportCard.F_MESSAGE);


        Collection<String> messages = card.getMessages().values();
        for (String message : messages) {
            assertTrue(expectedGrades.contains(message));
        }
        assertEquals(expectedGrades.size(), messages.size());
    }

    @Test
    public void testEntries() {
        Set<Entry> entries = new HashSet<>();
        for (Map.Entry<Student.Grade, String> entry :
                card.getMessages().entrySet()) {
            entries.add(new Entry(entry.getKey(), entry.getValue()));
        }

        Set<Entry> expectedEntries = new HashSet<>();
        expectedEntries.add(new Entry(Student.Grade.A, ReportCard.A_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.B, ReportCard.B_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.C, ReportCard.C_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.D, ReportCard.D_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.F, ReportCard.F_MESSAGE));
        assertEquals(expectedEntries, entries);
    }



}
