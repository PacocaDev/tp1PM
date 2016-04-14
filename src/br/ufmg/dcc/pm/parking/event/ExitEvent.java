package br.ufmg.dcc.pm.parking.event;

import br.ufmg.dcc.pm.parking.Building;

public class ExitEvent extends AbstractEvent {

	@Override
	public void handle(Building building) {
		getVehicle().exitBuilding(building,getDate());
	}

}
