package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * @author Leo
 *
 */
public class Schoolclass {
	
	private ArrayList<Student> students;   // generic arraylist for student objects
	
	private HashMap<Integer,Student> studentsAsHashMap;
	
	public Schoolclass(){
		students=new ArrayList<Student>();	
		studentsAsHashMap=new HashMap<Integer,Student>();
	}
	
	/**
	 * Add a student to the collection
	 * @param student
	 * @return
	 * @throws StudentInsertException 
	 */
	public Student addStudent(Student student) throws StudentInsertException{
		// check if the student exists
		if (students.contains(student)) throw new StudentInsertException("Student exists");
		// add the student
		if (students.add(student)){ studentsAsHashMap.put(student.getStudentNr(), student);     return student;}
		return null;
	}
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	public Student removeStudent(Student student){
		if (students.remove(student)) return student;
		return null;
	}
	
	/**
	 * 
	 * @param lastname
	 * @param firstname
	 * @return
	 */
	public Student removeStudent(Integer studentNr, String lastname, String firstname){
		try {
			return removeStudent(new Student(studentNr,lastname,firstname));
		} catch (MyStudentException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param studentNr
	 * @return
	 */
	public Student findStudentByNumber(Integer studentNr){
		return studentsAsHashMap.get(studentNr);
	}
	
	/**
	 * 
	 */
	public void printStudents(){
		for (Student s:students){
			System.out.println(s);
		}
	}
	

	/**
	 * 
	 */
	public void sortByLastname(){
		Collections.sort(students);
	}
	
	/**
	 * 
	 * @param asc
	 */
	public void sortByNumber(boolean asc){
	    Collections.sort(students,new ComparatorStudentNumber(asc));
	}
	
	
	/**
	 * Serialize objects
	 * 
	 * @throws IOException
	 */
	public void saveSchoolclass() throws IOException{
		FileOutputStream fo=new FileOutputStream("save.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fo);
		oos.writeObject(students);
		oos.close();
		System.out.println("Schoolclass serialized");
	}

	/**
	 * Serialize objects
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public void readSchoolclass() throws IOException, ClassNotFoundException{
		FileInputStream fi=new FileInputStream("save.ser");
		ObjectInputStream ois=new ObjectInputStream(fi);
		students=null;
		students=(ArrayList<Student>)ois.readObject();
		ois.close();
		System.out.println("Serialized schoolclass read");
	}

}
