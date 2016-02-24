package model;
import java.io.Serializable;
import java.util.Scanner;



/**
 * My student class.
 * 
 * To serialize the interface Serializable must be implemented
 * 
 * @author Leo
 *
 */
public class Student implements Comparable<Student>, Serializable{

	private Integer studentNr;
	private String firstname;
	private String lname;
	
	private int internalUsedNumber; // will not serialized
	/**
	 * @param firstname
	 * @param lname
	 * @throws MyStudentException 
	 */
	public Student(Integer studentNr, String fname, String lname) throws MyStudentException {
		super();
		this.setFirstname(fname);
		this.setLname(lname);
		this.setStudentNr(studentNr);
		
	
	}
	
	
	/**
	 * @throws MyStudentException 
	 * 
	 */
	public Student() throws MyStudentException {
		super();
		this.setFirstname("No firstname");
		this.setLname("No lastname");
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 * @throws MyStudentException 
	 */
	public void setFirstname(String fname) throws MyStudentException {
		if (fname==null) throw new MyStudentException("The name is null->not allowed");
		this.firstname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}


	/**
	 * @return the studentNr
	 */
	public Integer getStudentNr() {
		return studentNr;
	}


	/**
	 * @param studentNr the studentNr to set
	 */
	public void setStudentNr(Integer studentNr) {
		this.studentNr = studentNr;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studentNr=" + studentNr + ", firstname=" + firstname
				+ ", lname=" + lname + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((studentNr == null) ? 0 : studentNr.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNr == null) {
			if (other.studentNr != null)
				return false;
		} else if (!studentNr.equals(other.studentNr))
			return false;
		return true;
	}


	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		// 0 .... means the values are equal
		return this.getLname().compareTo(o.getLname());
	}



	
	






	
}
