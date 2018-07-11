package com.parking.service;

import java.util.List;

import com.parking.model.Vehicle;

public interface SlotMgmtservice {
	
	public String createParkingLot(int n);
	public void parkVehicle(Vehicle v);
	public String leaveVehicle(int slotNo);	
	public List<Vehicle> getAllParkingStatus();
	
	public List<Vehicle> getRegistrationNumbersForCarsWithColour(String colour);
	public List<Vehicle> getSlotNumbersForCarsWithColour(String colour);	
	public List<Vehicle> getSlotNumbersForRegistrationNumber(String regNo);
	
	
}
