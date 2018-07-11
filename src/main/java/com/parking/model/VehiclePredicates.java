/**
 * 
 */
package com.parking.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author singhsub
 *
 */
public class VehiclePredicates
{
	/**
	 * 
	 * @param colour
	 * @return
	 */
    public static Predicate<Vehicle> getByColour(String colour) {
        return p -> p.getColour().equalsIgnoreCase(colour);
    }
    /**
     * 
     * @param regNo
     * @return
     */
    public static Predicate<Vehicle> getByRegNo(String regNo) {
        return p -> p.getRegNo().equalsIgnoreCase(regNo);
    }
    /**
     * 
     * @param slotNo
     * @return
     */
    public static Predicate<Vehicle> getBySlotNo(String slotNo) {
        return p -> p.getSlotNo().equalsIgnoreCase(slotNo);
    }
   
	/**
	 * 
	 * @param vList
	 * @param predicate
	 * @return
	 */
    public static List<Vehicle> filterReviews (List<Vehicle> vList, Predicate<Vehicle> predicate) {
        return vList.stream().filter( predicate ).collect(Collectors.<Vehicle>toList());
    }
    
    
}  
