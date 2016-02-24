package test;

import java.io.IOException;

import model.MyStudentException;
import model.Schoolclass;
import model.Student;
import model.StudentInsertException;

public class TestSave
{

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
	Schoolclass sc = new Schoolclass();

	try {
	    sc.addStudent(new Student(1, "Roland", "Haidari"));
	    sc.addStudent(new Student(2, "Hans", "Mayer"));
	    sc.addStudent(new Student(3, "Karl", "Gruber"));
	    sc.addStudent(new Student(4, "Ernst", "Kaiser"));
	    sc.addStudent(new Student(5, "Richard", "Zeisel"));
	    sc.addStudent(new Student(40, "Herbert", "Hanser"));
	    sc.addStudent(new Student(20, "Richard", "Klaus"));

	    // save students
	    sc.saveSchoolclass();
	    System.out.println("Students saved:");
	    sc.printStudents();

	} catch (MyStudentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (StudentInsertException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

}
