package br.ufmg.dcc.pm.parking;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

/**
 * Represents one vacancy of a level
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 * @param <T> Which kind of vehicle can this vacancy hold
 */
public class Vacancy<T extends Vehicle> {
	
	/**
	 * The vehicle placed in the vacancy
	 */
	private T vehicle;
	
	/**
	 * When did the last vehicle entered
	 */
	private Calendar entranceTime;
	
	/**
	 * If there is any vehicle occupying the vacancy
	 * @return
	 */
	public boolean isOccupied() {
		return vehicle!=null;
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