package br.ufmg.dcc.pm.parking;

import java.io.FileNotFoundException;

import br.ufmg.dcc.pm.parking.event.AbstractEvent;

public class Parking {

	public static void main(String[] args) throws FileNotFoundException {
		
		Building parkingBuilding = new Building(4);
		IOHandler eventReader = new IOHandler();

		AbstractEvent event = null;
		while((event=eventReader.read())!=null){
			event.handle(parkingBuilding);
		}
		
	}
}

