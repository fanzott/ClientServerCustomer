package test;

import java.io.IOException;

import model.MyStudentException;
import model.Schoolclass;
import model.Student;
import model.StudentInsertException;

public class TestRead
{

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
	Schoolclass sc = new Schoolclass();

	try {
	    // read students
	    sc.readSchoolclass();
	    System.out.println("Students read:");
	    sc.printStudents();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

}
