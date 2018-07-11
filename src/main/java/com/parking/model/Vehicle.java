package com.parking.model;

public class Vehicle {
	private String regNo;
	private String colour;
	private String slotNo;

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	/**
	 * @return the slotNo
	 */
	public String getSlotNo() {
		return slotNo;
	}
	/**
	 * @param slotNo the slotNo to set
	 */
	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	@Override
	public String toString() {
		return this.slotNo+"			"+this.regNo+"			"+this.colour;
		
		/*return "Slot No.  "+ this.slotNo
				+"Reg. No : "+ this.regNo 
				+"Vehicle. colour : "+ this.colour;*/
	}


}
