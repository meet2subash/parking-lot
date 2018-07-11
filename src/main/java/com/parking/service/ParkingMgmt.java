package com.parking.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.parking.model.Vehicle;

public class ParkingMgmt {
	SlotMgmtServiceImpl slMgmt = new SlotMgmtServiceImpl();
	List<Vehicle> carList = null;


	public static void main(String[] args) {
		String cmd = null;
		ParkingMgmt pMgmt = new ParkingMgmt();
		if(args.length == 1){
			System.out.println("Entering to FIle mode");
			try {
				System.out.println("file name : "+args[0]);
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				while ((cmd = br.readLine())!=null)
				{
					pMgmt.cmdProcess(cmd);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(args.length == 0 || args[0].isEmpty()){			
			System.out.println("Give txt file path like -\n java -jar parking-lot-jar-with-dependencies.jar file_inputs.txt for file mode");
			System.out.println("Entering to CMD mode");
			while(true){
				Scanner sc = new Scanner(System.in);
				cmd = sc.nextLine();
				pMgmt.cmdProcess(cmd);
			}
		}


	} 


	public void cmdProcess(String cmd)
	{
		String keys[] = cmd.split(" ");
		switch (keys[0]) {
		case "create_parking_lot" :
			System.out.println(slMgmt.createParkingLot(Integer.parseInt(keys[1])));
			break;
		case "park" :	
			Vehicle v = new Vehicle();
			v.setRegNo(keys[1]);
			v.setColour(keys[2]);				
			slMgmt.parkVehicle(v);
			break;		
		case "leave" :
			System.out.println(slMgmt.leaveVehicle(Integer.parseInt(keys[1])));
			break;
		case "status" :
			carList = slMgmt.getAllParkingStatus();
			System.out.println("Slot No.		Registration No			colour ");
			for(Vehicle cv : carList)
			{
				if(cv != null)
					System.out.println(cv.toString());
			}
			break;

		case "registration_numbers_for_cars_with_colour" :
			carList = slMgmt.getRegistrationNumbersForCarsWithColour(keys[1]);
			if(carList.size()>0)
			{
				for(Vehicle cv : carList)
				{
					if(cv != null)
						System.out.println(cv.getRegNo());
				}
			}
			else
				System.out.println("Not found");
			break;		
		case "slot_numbers_for_cars_with_colour" :
			carList = slMgmt.getSlotNumbersForCarsWithColour(keys[1]);
			if(carList.size()>0)
			{
				for(Vehicle cv : carList){
					if(cv != null)	
						System.out.println(cv.getSlotNo());
				}
			}
			else
				System.out.println("Not found");
			break;	

		case "slot_number_for_registration_number" :
			carList = slMgmt.getSlotNumbersForRegistrationNumber(keys[1]);				
			if(carList.size()>0)
			{
				for(Vehicle cv : carList){
					if(cv != null)
						System.out.println(cv.getSlotNo());
				}
			}
			else
				System.out.println("Not found");
			break;		
		default:
			System.exit(0);
			break;
		}
	}
}
