package br.ufmg.dcc.pm.parking.event;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

public abstract class AbstractEvent {

	private Calendar date;
	private Vehicle vehicle;
	private EventTypeEnum type;
	
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
