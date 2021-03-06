/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

// This line will give you an error until you create the needed class.
import ooc.yoursolution.BookingSystem;

import ooc.yoursolution.BookingSystemInterface;
import ooc.yoursolution.RentACarInterface;
import ooc.enums.Make;
import ooc.enums.Month;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



//github.com/gabrieljonathan/RentACar

//Gabriel Jonathan 2020362
//Pedro Henrique Simoes Marcal 2020300

/**
 *
 * @author apont
 */
public class Driver {

    /**
     * Do not change the signature of the main method!
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BookingSystemInterface bookingSystem = new BookingSystem();

        String file = "amilcar_rentals.txt";
        BufferedReader in = new BufferedReader(new FileReader(file));

        RentACarInterface rentCar = bookingSystem.setupRentACar(in);

        // Get the name of the car rental
        System.out.println("The name of the Car Retal: " + rentCar.getName());
        
        // Print the number of cars in the rent-a-car
        System.out.println("\nQuantity of cars: " + rentCar.getNumberOfCars());  
        
        // Check if there is a BMW car available for 5 days from the 1st
        // of January
        System.out.println("\nChecking BMW Avaiability: " + rentCar.checkAvailability(Month.JANUARY, 1, Make.BMW, 5)); 
        
        // Get the id of the car available
        System.out.println("\nChecking BMW ID:" + rentCar.getCarAvailable(Month.JANUARY, 1, Make.BMW, 5));
        
        System.out.println("\nChecking Avaiability for dates:");
        // Try some bookings
        System.out.println(rentCar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentCar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentCar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentCar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentCar.bookCar(Month.FEBRUARY, 3, Make.FIAT, 10));
        System.out.println(rentCar.bookCar(Month.MARCH, 10, Make.FORD, 12));
        
    }

}
