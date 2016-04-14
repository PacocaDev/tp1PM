package br.ufmg.dcc.pm.parking.event;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import java.io.PrintStream;

/**
 * Class that represents an event 
 * that can happen in a Parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 */
public abstract class AbstractEvent {

	private Calendar date;
	private Vehicle vehicle;
	private EventTypeEnum type;
	private PrintStream writer;
	
	/**
	 * Method that will handle what happens when the event is triggered 
	 * @param building The building where the event happened
	 */
	public abstract void handle(Building building);

	/**
	 * @return The date that the event occur
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date The date that the event occur
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return Which vehicle was it associated with this
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Associates a {@link Vehicle} to this
	 * @param vehicle A vehicle to associate with
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return The {@link EventTypeEnum} of the event
	 */
	public EventTypeEnum getType() {
		return type;
	}

	/**
	 * Defines the {@link EventTypeEnum} of the event
	 * @param type The {@link EventTypeEnum} to associate
	 */
	public void setType(EventTypeEnum type) {
		this.type = type;
	}

	/**
	 * @return The writer to write event info
	 */
	public PrintStream getWriter() {
		return writer;
	}

	/**
	 * @param writer Sets the writer to print event info
	 */
	public void setWriter(PrintStream writer) {
		this.writer = writer;
	}
	
}
