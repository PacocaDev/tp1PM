package br.ufmg.dcc.pm.parking;

import java.io.FileNotFoundException;

import br.ufmg.dcc.pm.parking.event.AbstractEvent;

/**
 * The parking itself, will read all events
 * and prints the output
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
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

