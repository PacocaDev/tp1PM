package br.ufmg.dcc.pm.parking.event;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

/**
 * Class that represents an event 
 * that can happen in a Parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 */
public abstract class AbstractEvent {

	/**
	 * When the event occur
	 */
	private Calendar date;
	
	/**
	 * Which vehicle was it associated with
	 */
	private Vehicle vehicle;
	
	/**
	 * The Type
	 */
	private EventTypeEnum type;
	
	/**
	 * Method that will handle what happens when the event is triggered 
	 * @param building The building where the event happened
	 */
	public abstract void handle(Building building);

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public EventTypeEnum getType() {
		return type;
	}

	public void setType(EventTypeEnum type) {
		this.type = type;
	}
	
}
