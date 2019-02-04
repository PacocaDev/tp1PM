package br.ufmg.dcc.pm.parking.event;

import br.ufmg.dcc.pm.parking.Building;

/**
 * An event that represents a vehicle exitting the parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
 *
 */
public class ExitEvent extends AbstractEvent {

	@Override
	public void handle(Building building) {
		String info = getVehicle().exitBuilding(building,getDate()); 
		if(info==null){
			getWriter().println("O veículo não está no estacionamento");
		} else {
			getWriter().println(info);
		}
	}

}
