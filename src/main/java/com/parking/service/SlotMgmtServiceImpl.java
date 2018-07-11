/**
 * 
 */
package com.parking.service;

import static com.parking.model.VehiclePredicates.filterReviews;
import static com.parking.model.VehiclePredicates.getByColour;
import static com.parking.model.VehiclePredicates.getByRegNo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parking.model.Vehicle;

/**
 * @author singhsub
 *
 */
public class SlotMgmtServiceImpl implements SlotMgmtservice {
	
	private Map<Integer,Vehicle> parkinglot = new HashMap<Integer, Vehicle>();
	public static int parkingLotSize = 0;
	private List<Vehicle> carList = null;

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#createParkingLot(int)
	 */
	@Override
	public String createParkingLot(int n) {
		parkingLotSize = n;
		for(int i=1; i <= parkingLotSize; i++)
			parkinglot.put(i, null);
		return "Created a parking lot with "+parkingLotSize+" slots";
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#parkVehicle(com.parking.model.Vehicle)
	 */
	@Override
	public void parkVehicle(Vehicle v) {		
		
		boolean isFull = true;
		for(int key=1; key <= parkingLotSize; key++)
		{
			Vehicle cv = parkinglot.get(key);
			if (null == cv)
			{
				v.setSlotNo(String.valueOf(key));
				parkinglot.put(key, v);
				System.out.println("Allocated slot number: "+v.getSlotNo());
				isFull = false;
				break;
			}			
		}
		if (isFull)
			System.out.println("Sorry, parking lot is full ");
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#leaveVehicle(com.parking.model.Vehicle)
	 */
	@Override
	public String leaveVehicle(int slotNo) {
		if(slotNo > 0 && slotNo<=parkingLotSize)
			parkinglot.put(slotNo, null);		
		else
			System.err.println("Not a Valid  slotNo");
		return "Slot number "+slotNo+" is free";
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#getAllParkingStatus()
	 */
	@Override
	public List<Vehicle> getAllParkingStatus() {
		carList =  new ArrayList<Vehicle>(parkinglot.values());		
		return carList;
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#getRegistrationNumbersForCarsWithColour(java.lang.String)
	 */
	@Override
	public List<Vehicle> getRegistrationNumbersForCarsWithColour(String colour) {
		if(null != colour)
			carList = filterReviews(getAllParkingStatus(), getByColour(colour));
			
		return carList;
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#getSlotNumbersForCarsWithColour(java.lang.String)
	 */
	@Override
	public List<Vehicle> getSlotNumbersForCarsWithColour(String colour) {
		if(null != colour)
			carList = filterReviews(getAllParkingStatus(), getByColour(colour));
			
		return carList;
	}

	/* (non-Javadoc)
	 * @see com.parking.repo.SlotMgmtservice#getSlotNumbersForRegistrationNumber(java.lang.String)
	 */
	@Override
	public List<Vehicle> getSlotNumbersForRegistrationNumber(String regNo) {
		if(null != regNo)
			carList = filterReviews(getAllParkingStatus(), getByRegNo(regNo));
		
		return carList;
	}

}
