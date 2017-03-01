package assignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Teck Hock
 */
public class Student extends Person {
    
    LocalDate enrolDate;
    int studentNum;
    boolean goodStanding;
    String major;
    
    public Student(String first, String last, String streetAddress, String city, String province, String postalCode, LocalDate dob,
                     String major, int studentNum, LocalDate enrollmentDate)
    {
        
        super(first,last,streetAddress,city,province,postalCode,dob);
        goodStanding = true;
        setBirthdate(dob);
        setBirthday(dob);
        enrolDate = enrollmentDate;
        setStudentNumber(studentNum);
        this.major = major;
    }
    
    /**
     * This method validate and sets the student number
     * @param studentNum 
     */
    public void setStudentNumber(int studentNum) 
    {
        if (studentNum < 1)
            throw new IllegalArgumentException ("Student number must be greater than 0");
        else
            this.studentNum = studentNum;
    }
    
    /**
     * Returns the year of enrollment
     * @return 
     */
    public int getYearEnrolled() 
    {
        return enrolDate.getYear();
    }
    
    /**
     * Returns the year in College
     */
    public int getYearsAtCollege()
    {
        LocalDate today = LocalDate.now();
        int yearsAtCollege = Period.between(enrolDate, today).getYears();
        return yearsAtCollege;
    }
    
    /**
     Returns whether the student is in good standing
     */
    public boolean inGoodStanding()
    {
        return goodStanding;
    }
    
    /**
     * Sets the student into good standing
     */
    public void reinstateStudent()
    {
        goodStanding = true;
    }
    

    
    /**
     * Sets the birth date of the student 
     */
    public void setBirthday(LocalDate dob)
    {
        
        LocalDate today = LocalDate.now();
        if((today.getYear() - dob.getYear()) < 14)
            throw new IllegalArgumentException("The student is too young");
        else if((today.getYear() - dob.getYear()) > 90)
            throw new IllegalArgumentException("The student is too old");
        else super.setBirthdate(dob);
    }
    
    /**
     * Returns the birthday of the student
     */
    public LocalDate getBirthday()
    {
        return birthdate;
    }
    /**
     * This method puts the student into suspension
     */
    public void suspendStudent() 
    {
        goodStanding = false;
    }
    
    /**
     * Returns the student name and student number
     */
    public String toString()
    {
        return firstName + " " + lastName + ", student number is " + studentNum;
    }
    
    
}
