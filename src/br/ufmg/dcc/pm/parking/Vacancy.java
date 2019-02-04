package br.ufmg.dcc.pm.parking;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

/**
 * Represents one vacancy of a level
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
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
	
	/**
	 * @return Which vehicle is in this {@link Vacancy}
	 */
	public T getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle A {@link Vehicle} to place in this {@link Vacancy}
	 */
	public void setVehicle(T vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return When the last {@link Vehicle} entered this {@link Vacancy}
	 */
	public Calendar getEntranceTime() {
		return entranceTime;
	}

	/**
	 * Sets the time when the last {@link Vehicle} was placed in this {@link Vacancy}
	 * @param entranceTime The time
	 */
	public void setEntranceTime(Calendar entranceTime) {
		this.entranceTime = entranceTime;
	}

}