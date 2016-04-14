package br.ufmg.dcc.pm.parking.vehicle;

import java.util.Calendar;

import br.ufmg.dcc.pm.parking.Building;

public class SmallCar extends LargeCar {
	
	public static final VehicleTypeEnum type = VehicleTypeEnum.VP;

	@Override
	public String enterBuilding(Building building, Calendar enterTime) {
		String info = building.enterVehicle(this, enterTime);
		return info==null?super.enterBuilding(building, enterTime):info;
	}

}
