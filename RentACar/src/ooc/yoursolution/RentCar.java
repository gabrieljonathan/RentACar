/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Month;
import ooc.enums.Make;
/**
 *
 * @Pedro Henrique Simoes Marcal 2020300
 */

public class RentCar implements RentACarInterface {
 // Initialize an array to add the cars.
    private List <Car> cars;
    private String name;
    
// Returning cars and name value.
    public RentCar (List <Car> cars,String name) {
    this.cars=cars;
    this.name=name;
    }

    //Getter for return cars.
    @Override
    public List getCars() {
    return cars;
    }
    
    //Setter for update cars value.
    @Override
    public void setCars(List cars) {
    this.cars=cars;
    }
    
    public String getName();

    /**
     * Set the name of the rent-a-car.
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Check through all cars in this hotel and see if there is continuous
     * availability of any specific car. It is not enough to just have
     * any car available for the length of stay, we need it to be in one
     * specific car.
     *
     * @param month	Month of proposed rent
     * @param day	Day of start of proposed rent
     * @param make	Make, what sort of car for the proposed rent
     * @param lengthOfRent	how long is the proposed rent for
     * 
     * @return	true or false is there availability for the proposed rent
     */
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent);

    /**
     * Assuming there is availability, get the id of a car that fits that
     * availability
     *
     * @param month	Month of proposed rent
     * @param day	Day of start of proposed rent
     * @param make	Make, what sort of car for the proposed rent
     * @param lengthOfRent	how long is the proposed rent for
     * @return	the id of a room that fits the bill
     */
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent);

   
     
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent);
    
   
    public int getNumberOfCars();    
}
}
