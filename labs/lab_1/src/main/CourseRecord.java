package main;
import java.util.Vector;
import java.util.Enumeration;

public class CourseRecord {
    private Student student;
    private Vector assignments;

    CourseRecord() {
        assignments = new Vector();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student s) {
        student = s;
    }

    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }

    public Enumeration getAssignments() {
        return assignments.elements();
    }

    public double average() throws NotYetSetException {
        double sum = 0.0;
        int cntr = 0;

        for (Object a : assignments) {
            Assignment assignment = (Assignment) a;

            try {
                if (assignment.getMark() != -1) {
                    sum += assignment.getMark();
                    cntr++;
                }
            } catch (NotYetSetException err) {
                System.out.println(err.getStackTrace());
            }
        }
        if (sum != 0)
            return sum / cntr;
         else
            return 0.0;

    }

    public boolean canTakeFinalExam() {
        int cntr=0;
        for (Object a : assignments) {
            Assignment assignment = (Assignment) a;
            try {
                if (assignment.getMark() != 0)
                    cntr++;
                if (cntr == 3) break;
            } catch (NotYetSetException err) {
                System.out.println(err.getStackTrace());
            }
        }

        return cntr >= 3;
    }
}