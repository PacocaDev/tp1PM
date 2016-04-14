package br.ufmg.dcc.pm.parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import br.ufmg.dcc.pm.parking.event.AbstractEvent;
import br.ufmg.dcc.pm.parking.event.EventTypeEnum;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

public class IOHandler{

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");
	private Scanner scanner;

	public IOHandler() throws FileNotFoundException {
		scanner = new Scanner(new File("entrada.txt"));
	}

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