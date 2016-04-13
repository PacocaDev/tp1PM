package br.ufmg.dcc.pm.parking;

import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

public class CarSpot<T extends Vehicle> {
	
	private boolean occupied = false;
	
	private String entranceTime;
	
	private T vehicle;
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public void setOccupied() {
		this.occupied = true;
	}

	public T getVehicle() {
		return vehicle;
	}

	public void setVehicle(T vehicle) {
		this.vehicle = vehicle;
	}

	public String getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(String entranceTime) {
		this.entranceTime = entranceTime;
	}

}