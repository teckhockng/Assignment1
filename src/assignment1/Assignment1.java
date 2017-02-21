/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Teck Hock
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person jaretW = new Person("Teck","Hock","1 Georgian Drive","Barrie","Ontario","L4M7B6",
                                    LocalDate.of(1997, Month.MAY, 25));
        System.out.printf("%d", jaretW.getAge());
    }
    
}
