package br.ufmg.dcc.pm.parking.event;

import br.ufmg.dcc.pm.parking.Building;

/**
 * An event that represents a vehicle entering the parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public class EnterEvent extends AbstractEvent {

	@Override
	public void handle(Building building) {
		String info = getVehicle().enterBuilding(building,getDate()); 
		if(info==null){
			getWriter().println("LOTADO");
		} else {
			getWriter().println(info);
		}
	}

}
