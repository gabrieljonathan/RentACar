/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;


import java.util.Map;
import java.util.HashMap;
import ooc.enums.Month;
import ooc.enums.Make;


/**
 *
 * @author Gabriel 2020362
 */
public class Car implements CarInterface {
    
    /**
     * Variables for the car  
     * boolean map created to define the number of days in the month
     */
    
    private int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]> map;
    
    public Car (int id, Make make, double rate){
        this.id = id;
        this.rate = rate;
        this.make = make;
        
        createAvailability();
    
    }
    
    /**
     * including every day of the month
     * including retuning 
     */
    
    @Override
    public Map createAvailability() {
        map = new HasMap<>();
        
        map.put(Month.JANUARY, new Boolean[31]);
        map.put(Month.FEBRUARY, new Boolean[28]);
        map.put(Month.MARCH, new Boolean[31]);
        map.put(Month.APRIL, new Boolean[30]);
        map.put(Month.MAY, new Boolean[31]);
        map.put(Month.JUNE, new Boolean[30]);
        map.put(Month.JULY, new Boolean[31]);
        map.put(Month.AUGUST, new Boolean[31]);
        map.put(Month.SEPTEMBER, new Boolean[30]);
        map.put(Month.OCTOBER, new Boolean[31]);
        map.put(Month.NOVEMBER, new Boolean[30]);
        map.put(Month.DECEMBER, new Boolean[31]);

        return map;
    }
    //get and set for make
    public Make getmake(){
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }
    //get and set for rate
    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }
    //
    @Override
    public Map getAvailability() {
        return map;
    }
    //get and set for availability
    @Override
    public void setAvailability(Map availability) {
        this.map = map;
    }
    //return ID
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * passing the parameters and return availability if the answer is "true" 
     * -1 because it needs to follow the matrix with start 0  
     */
    @Override
    public boolean isAvailable(Month month, int day) {
        Boolean[] availability = map.get(month);
        if (availability[day-1] == null) {
            availability[day-1] = true;
        }
        return availability[day-1];
    }

    
     //*checking conditions
     
    @Override
    public boolean book(Month month, int day) {
        if (map.get(month)[day-1]) {
            map.get(month)[day-1] = false;
            return true;
        }

        return false;
    }
}