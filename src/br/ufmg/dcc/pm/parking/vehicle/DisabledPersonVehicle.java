package br.ufmg.dcc.pm.parking.vehicle;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;

public class DisabledPersonVehicle extends Vehicle {
	
	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.NE;

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}
	
	@Override
	public String enterBuilding(Building building, Calendar enterTime) {
		return building.enterVehicle(this, enterTime);
	}

}
