package br.ufmg.dcc.pm.parking.vehicle;

import java.util.Calendar;
import java.text.MessageFormat;
import java.util.Locale;

import br.ufmg.dcc.pm.parking.Building;
import br.ufmg.dcc.pm.parking.Vacancy;

/**
 * A vehicle representation to the parking lot, 
 * must know how to find it's place inside the building
 * and how to get out of it
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public abstract class Vehicle {
	
	private String plate;

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public abstract VehicleTypeEnum getVehicleType();

	public abstract String enterBuilding(Building building, Calendar enterTime);
	
	public String calculatePrice(Calendar entranceTime, Calendar exitTime){
		int hourEntered,minutesEntered,hourGone,minutesGone;
		long iPart,aux2;
		double fPart;

		double minutesElapsed,hoursElapsed;

		hourEntered = entranceTime.get(Calendar.HOUR_OF_DAY);
		minutesEntered = entranceTime.get(Calendar.MINUTE);

		hourGone = exitTime.get(Calendar.HOUR_OF_DAY);
		minutesGone = exitTime.get(Calendar.MINUTE);

		minutesElapsed=(hourGone*60+minutesGone)-(hourEntered*60+minutesEntered);
		hoursElapsed=minutesElapsed/60;

		iPart = (long) hoursElapsed;
		fPart = hoursElapsed - iPart;

		fPart = fPart*60;
		aux2 = Math.round( fPart);

		MessageFormat format = new MessageFormat("{0}';'{1,number,#00}':'{2,number,#00}';'{3,number,#.00}",new Locale("pt","BR"));

		String msg = format.format(new Object[]{
			getVehicleType().toString(),
			iPart,
			aux2,
			hoursElapsed*getVehicleType().getPrice()
		});

		return msg;
	}

	public String exitBuilding(Building building, Calendar exitTime){
		Vacancy<Vehicle> vacancy = building.findCarSpot(this);
		if(vacancy==null){
			return null;
		} else {
			return calculatePrice(vacancy.getEntranceTime(), exitTime);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

}
