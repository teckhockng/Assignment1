package assignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Teck Hock
 */
public class Instructor extends Person{
    
    ArrayList<String> courseCodes;
    LocalDate dateHired;
    int employeeNum;
    
    public Instructor(String first, String last, String streetAddress, String city, String province, String postalCode, LocalDate dob,
                       int employeeNum, LocalDate dateHired )
    {
        super(first,last,streetAddress,city,province,postalCode,dob);
        setBirthday(dob);
        setHireDate(dateHired);
        this.employeeNum = employeeNum;
        this.dateHired = dateHired;
        courseCodes = new ArrayList<>();
    }
    
    /**
     * Add the course code into list of teachable courses
     */
    public void addTeachableCourse(String code)
    {
        
        courseCodes.add(code.toUpperCase());
    }
    
    /**
     * Identify whether the course code is teachable
     */
    public boolean canTeach(String code)
    {
        boolean canTeach = false;
        for (int i=0; i< courseCodes.size();i++)
        {
            if(courseCodes.get(i).equalsIgnoreCase(code))
                canTeach = true;
            else
                canTeach = false;
        }
        return canTeach;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getTeachableCourses() {
        return courseCodes;
    }
    
    /**
     * Returns the years the instructor worked at the college
     */
    public int getYearsAtCollege()
    {
        LocalDate today = LocalDate.now();
        int yearsAtCollege = Period.between(dateHired, today).getYears();
        return yearsAtCollege;
    }
    
    /**
     * Returns list of course code the Instructor can teach
     */
    public String listOfSubjectsCertifiedToTeach()
    {
        String codes = "";
        for(int i=0; i< courseCodes.size()-1;i++)
        {
            codes += String.format("%s, ", courseCodes.get(i));
        }
        
        codes += String.format("%s", courseCodes.get(courseCodes.size()-1));
                
        return codes;
    }
    
    /**
     * Validate and set the birthday of the instructor
     */
    public void setBirthday(LocalDate dob)
    {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dob.getYear();
        if(age > 100)
            throw new IllegalArgumentException("The instructor is too old");
        else if (age < 18)
            throw new IllegalArgumentException("The instructor is too young");
        else birthdate = dob;
    }
    
    /**
     * Set the hire date of the instructor
     */
    public void setHireDate(LocalDate hiredDate)
    {
        LocalDate today = LocalDate.now();
        if(Period.between(hiredDate, today).getYears() > 80)
            throw new IllegalArgumentException("The instructor was hired for 80years!!!");
        else if (hiredDate.isAfter(today))
            throw new IllegalArgumentException("The date hired cannot be in from the future unless he's Jaret");
        else dateHired = hiredDate;
    }

    public ArrayList<String> getCourseCodes() {
        return courseCodes;
    }

    public void setCourseCodes(ArrayList<String> courseCodes) {
        this.courseCodes = courseCodes;
    }

    public LocalDate getHireDate() {
        return dateHired;
    }

    


    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }
    
    /**
     * Returns the Instructor's name and employee number
     */
    public String toString()
    {
        return firstName + " " + lastName + ", employee number is " + employeeNum;
    }
}
