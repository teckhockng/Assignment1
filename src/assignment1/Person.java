package assignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Teck Hock
 */
public class Person {
    //create instance variable of person( first name, last name, street address, city, province, postal code, and birthdate)
    String firstName, lastName, streetAddress, city, province, postalCode;
    LocalDate birthdate;
    int age;
    
    public Person(String first, String last, String streetAddress, String city, String province, String postalCode, LocalDate dob)
    {
        firstName = first;
        lastName = last;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        setPostalCode(postalCode);
        birthdate = dob;
        setAge(dob);
        
    }

    /**
     * This method returns the age of the person
     * @return 
     */
    public int getAge() {
        return age;
    }
    
    /**
     * This method will validate the postal code
     */
    public void setPostalCode(String postalCode)
    {
        postalCode.toUpperCase();
        
        if (postalCode.length() != 6)
            throw new IllegalArgumentException ("The postal code must have 6 characters");
        
        else if (!Character.isLetter(postalCode.charAt(0)))
            throw new IllegalArgumentException("The first character of postal code must be a letter");
        
        else if (!Character.isDigit(postalCode.charAt(1)))
            throw new IllegalArgumentException("The second character of postal code must be a number");
        
        else if (!Character.isLetter(postalCode.charAt(2)))
            throw new IllegalArgumentException("The third character of postal code must be a letter");
        
        else if (!Character.isDigit(postalCode.charAt(3)))
            throw new IllegalArgumentException("The fourth character of postal code must be a number");
        
        else if (!Character.isLetter(postalCode.charAt(4)))
            throw new IllegalArgumentException("The fifth character of postal code must be a letter");
        
        else if (!Character.isDigit(postalCode.charAt(5)))
            throw new IllegalArgumentException("The sixth character of postal code must be a number");
        
        this.postalCode = postalCode;            
    }
    
    /**
     * This method determines the age of the person
     * @param dob 
     */
    public void setAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        age = Period.between(dob, today).getYears();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * This method returns the postal code
     * @return 
     */
    public String getPostalCode() {
        return postalCode;
    }
    
    /**
     * This method returns the street address
     * @return 
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    
    /**
     * This method returns the city of the address
     * @return 
     */
    public String getCity() {
        return city;
    }
    
    /**
     * This method returns the province of the address
     * @return 
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * This method returns the full address of the person
     * @return 
     */
    public String getFullAddress() {
        return streetAddress + ", " + city + ", " + province + ", " + postalCode;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public int getYearBorn() {
        return birthdate.getYear();
    }
    
    /**
     * This method will change the current address
     */
    public void changeAddress(String streetAddress, String city, String province, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
}
