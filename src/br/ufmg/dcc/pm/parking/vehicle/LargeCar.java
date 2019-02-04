package br.ufmg.dcc.pm.parking.vehicle;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;

/**
 * Represents a large car
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
 *
 */
public class LargeCar extends Vehicle {

	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.VG;

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}

	@Override
	public String enterBuilding(Building building, Calendar enterTime) {
		return building.enterVehicle(this, enterTime);
	}

}
