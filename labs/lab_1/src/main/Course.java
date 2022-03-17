package main;
import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector courseRecords;
    Course() {courseRecords=new Vector();}

    public String getTitle() {return title;}
    public void setTitle( String t) {title=t;}

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }
    public Enumeration getCourseRecords() {
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        for (Object courseRecord: courseRecords) {
            System.out.println(((CourseRecord)courseRecord).getStudent());
        }
    }

    public void printBestStudent() throws NotYetSetException {
        CourseRecord bestStudent = (CourseRecord) courseRecords.get(0);

        for (int i = 1; i < courseRecords.size(); i++) {
            CourseRecord nextStudent = (CourseRecord) courseRecords.get(i);
            if (nextStudent.average() > bestStudent.average()) {
                bestStudent = nextStudent;
            }
        }
        System.out.println(bestStudent.getStudent());
    }

    public void printFinalExamStudents() {
        for (Object courseRecord : courseRecords) {
            if (((CourseRecord)courseRecord).canTakeFinalExam()) {
                System.out.println(((CourseRecord)courseRecord).getStudent() +" " + "can participate in the final exam");
            }
        }
    }
}
