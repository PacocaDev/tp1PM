package br.ufmg.dcc.pm.parking.vehicle;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;

public class Motocycle extends SmallCar {

	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.MT;

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}
	
	@Override
	public String enterBuilding(Building building, Calendar enterTime) {
		String info = building.enterVehicle(this, enterTime);
		return info==null?super.enterBuilding(building, enterTime):info;
	}

}
