package br.ufmg.dcc.pm.parking.event;

import br.ufmg.dcc.pm.parking.Building;

/**
 * An event that represents a vehicle exitting the parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public class ExitEvent extends AbstractEvent {

	@Override
	public void handle(Building building) {
		getVehicle().exitBuilding(building,getDate());
	}

}
