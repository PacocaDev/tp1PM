package br.ufmg.dcc.pm.parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.PrintStream;

import br.ufmg.dcc.pm.parking.event.AbstractEvent;
import br.ufmg.dcc.pm.parking.event.EventTypeEnum;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

/**
 * Reads events that happened at the parking lot from a file
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
 *
 */
public class IOHandler {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");
	private Scanner scanner;
	private PrintStream writer;	
	
	/**
	 * Constructs a new {@link IOHandler} that will read the events from a file
	 * @param file A file containing the elements
	 * @throws FileNotFoundException if the file isn't found
	 */
	public IOHandler(File input, File output) throws FileNotFoundException{
		scanner = new Scanner(input);
		writer = new PrintStream(output);
	}

	/**
	 * Constructs a new {@link IOHandler} that will read from a file
	 * called entrada.txt
	 * The file must be at running directory of the program
	 * @throws FileNotFoundException
	 */
	public IOHandler() throws FileNotFoundException {
		this(new File("entrada.txt"),new File("saida.txt"));
	}

	/**
	 * Reads the next line of input and transforms it into an event
	 * @return The {@link AbstractEvent} represented by the line
	 */
	public AbstractEvent read(){
		try {
			if (scanner.hasNextLine())   {
				String[] attributes = scanner.nextLine().split(";");
				Calendar date = Calendar.getInstance();
				date.setTime(DATE_FORMAT.parse(attributes[1]));
				VehicleTypeEnum vehicleType = VehicleTypeEnum.valueOf(attributes[3]);
				Vehicle vehicle = vehicleType.getVehicleClass().newInstance();
				vehicle.setPlate(attributes[2]);
				AbstractEvent event = EventTypeEnum.valueOf(attributes[0]).getEventClass().newInstance();
				event.setDate(date);
				event.setVehicle(vehicle);
				event.setWriter(writer);
				return event;
			} else {
				scanner.close();
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}
}