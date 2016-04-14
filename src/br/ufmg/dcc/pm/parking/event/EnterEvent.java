package br.ufmg.dcc.pm.parking.event;

import br.ufmg.dcc.pm.parking.Building;

public class EnterEvent extends AbstractEvent {

	@Override
	public void handle(Building building) {
		String info = getVehicle().enterBuilding(building,getDate()); 
		if(info==null){
			System.out.println("LOTADO");
		} else {
			System.out.println(info);
		}
	}

}
