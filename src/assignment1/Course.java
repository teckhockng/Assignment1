/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Teck Hock
 */
public class Course {
    
    String courseCode, courseName, room, description;
    Instructor instructor;
    int maxNumOfStudents, duration;
    DayOfWeek day;
    LocalTime start;
    ArrayList<Student> students;
    
    public Course( String courseCode, String courseName, String description, String room, 
                    Instructor instructor, DayOfWeek day, LocalTime startOfClass,int duration, int maxStudents)
    {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.room = room;
        this.description = description;
        this.duration = duration;
        setProf(instructor);
        setMaxNumberOfStudents(maxStudents);
        setDayOfClass(day);
        setStartTime(startOfClass);
        students = new ArrayList<Student>();
        
    }
    
    
    /**
     * This method validates that the instructor is able to teach the course
     */
    public void setProf(Instructor instructor)
    {
        if (instructor.canTeach(courseCode))
                this.instructor = instructor;
        else 
            throw new IllegalArgumentException("The instructor cannot teach the course");
    }
    
    /**
     * This method sets the maximum number of student in the course
     */
    public void setMaxNumberOfStudents(int num)
    {
        if(num >=10 & num <=50)
            maxNumOfStudents = num;
        else
            throw new IllegalArgumentException("The number of student in a class must be less than 50 and more than 10");
    }
    
    /**
     * This method sets the day of class
     */
    public void setDayOfClass(DayOfWeek day)
    {
        if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
            throw new IllegalArgumentException("No one likes to study in Saturday or Sunday");
        else
            this.day = day;
    }
    
    /**
     * This method validates the time is between 8.00am and 6.00pm and sets the start time
     */
    public void setStartTime(LocalTime time)
    {
        
        if((time.isBefore(LocalTime.of(8,0))) || (time.isAfter(LocalTime.of(18,0))))
            throw new IllegalArgumentException("The time must be between 8.00am and 6.00pm");
        else
            start = time;
    }
    
    /**
     * Adds a student into the course if he/she is in good standing
     */
    public void addStudent(Student student)
    {
        if(student.inGoodStanding() && students.size() < maxNumOfStudents)
            students.add(student);
        else
            throw new IllegalArgumentException("The student is either not in good standing or the class is full");
            
    }
    
    /**
     * Shows the average number of years students registered in the class has been at the college
     */
    public double averageStudentTimeAtCollege()
    {
        double totalTimeAtCollege = 0;
        
        for(int i =0; i< students.size();i++)
        {
            totalTimeAtCollege += students.get(i).getYearsAtCollege();
        }
        
        double averageTime = (totalTimeAtCollege/students.size());
        
        if (totalTimeAtCollege == 0)
            return 0.0;
        else
            return averageTime;
    }
    
    /**
     * Returns the course code
     */
    public String getCourseCode()
    {
        return courseCode;
    }
    
    /**
     * Returns the courseName
     */
    public String getCourseName()
    {
        return courseName;
    }
    
    /**
     * returns a DayOfWeek object with the day the class is offered
     */
    public DayOfWeek getDayOfClass()
    {
        return day;
    }
    
    /**
     * returns the description of the course
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * returns the duration of each class as an int
     */
    public int getDuration()
    {
        return duration;
    }
    
    /**
     * returns the maximum number of students that can be registered in the class
     */
    public int getMaxNumberOfStudents()
    {
        return maxNumOfStudents;
    }
    
    /**
     * returns the number of students currently registered in the course
     */
    public int getNumberOfStudentsEnrolled()
    {
        return students.size();
    }
    
    /**
     * returns the Instructor object that will be teaching the course
     */
    public Instructor getProf()
    {
        return instructor;
    }
    
    /**
     * return the room location
     */
    public String getRoom()
    {
        return room;
    }
    
    /**
     * returns a LocalTime object representing the start time of the class
     */
    public LocalTime getStartTime()
    {
        return start;
    }
    
    /**
     * returns an ArrayList of students registered in the course
     */
    public ArrayList getStudents()
    {
        return students;
    }
    
    /**
     * This will return a String with the Student's registered in the course
     */
    public String showClassList()
    {
        String students = "";
        for(int i=0; i< this.students.size();i++)
        {
            students += String.format("%s%n", this.students.get(i).toString());
        }
                
        return students;
    }
    
    /**
     * returns a String with the course name and course code
     */
    public String toString()
    {
        return courseName + " " + courseCode;
    }
}
