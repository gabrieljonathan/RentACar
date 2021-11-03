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

    private List<Car> cars;
    private String name;

// Returning cars and name value.
    public RentCar(List<Car> cars, String name) {
        this.cars = cars;
        this.name = name;
    }

    //Getter for return cars.
    @Override
    public List getCars() {
        return cars;
    }

    //Setter for cars.
    @Override
    public void setCars(List cars) {
        this.cars = cars;
    }
    
    //Getter for return name.
    @Override
    public String getName() {
        return name;
    }
    
    //Setter for name.
    @Override
    public void setName(String name){
    this.name=name;
    }
    
    //Check if car is available.
    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent){
    int dayToday;
    int checking;
    
    //Check avaliability of each car.
    //Initialize loop to check.
    for (Car car : cars) {
        if (car.getMake().equals(make)) {
        dayToday = day;
        checking = 0;
          for(int i = 0; i< lengthOfRent ;i++) {
              if (!car.isAvailable(month, dayToday++)) {
                  checking = 1;
                  break;
              }
          }
          if (checking ==0) {
             return true;
          }
          
        }
        
    }
   
    return false;
    }
    
    //Getter to see if car is available
    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent){
    int dayToday;  
    int checking;
    
    //Initialize loop
    //check = 0 returns ID.
    for (Car car : cars) {
        if (car.getMake().equals(make)) {
        dayToday = day;
        checking = 0;
          for(int i = 0; i< lengthOfRent ;i++) {
              if (!car.isAvailable(month, dayToday++)) {
                  checking = 1;
                  break;
              }
          }
          if (checking ==0) {
             return car.getId();
          }
          
        }
        
    }
   
    return -1;
    }

    //Boolean to book the car.
    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        
        if (!checkAvailability(month,day,make,lengthOfRent)) {
        return false;
    }
    
    //check if day wanted is free, if not, returns false.
    int Id = getCarAvailable(month, day ,make,lengthOfRent);
    
    for (Car car : cars)  {
            if (car.getId() == Id && car.getMake() == make) {
                int dayToday = day;
                for (int i=0; i<lengthOfRent; i++) {
                    car.book(month, dayToday++);
                }
            }
        }

        return true;
    }

    //Setter for number of cars.
@Override
    public int getNumberOfCars(){
    return cars.size();
}
    //Getter to display car value.
    public void getName(RentCar car) {
        this.cars=(List<Car>)car;
    }
}
