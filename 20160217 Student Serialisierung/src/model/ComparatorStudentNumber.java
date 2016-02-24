package model;

import java.util.Comparator;

/**
 * 
 * @author Leo Fanzott
 *
 */
public class ComparatorStudentNumber implements Comparator<Student>
{
    private boolean asc; // sort ascending order
    
    /**
     * 
     * @param asc
     */
    public ComparatorStudentNumber(boolean asc){
	this.asc=asc;
    }

    @Override
    public int compare(Student o1, Student o2) {
	// TODO Auto-generated method stub
	// if ascending order is forced
	if (asc) return o1.getStudentNr().compareTo(o2.getStudentNr());
	// descending order
	else return o2.getStudentNr().compareTo(o1.getStudentNr());
    }



}
