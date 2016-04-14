package br.ufmg.dcc.pm.parking;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

public class Vacancy<T extends Vehicle> {
	
	private boolean occupied = false;
	
	private Calendar entranceTime;
	
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

	public Calendar getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(Calendar entranceTime) {
		this.entranceTime = entranceTime;
	}

}