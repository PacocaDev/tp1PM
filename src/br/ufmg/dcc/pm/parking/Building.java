package br.ufmg.dcc.pm.parking;

import java.util.Calendar;
import java.util.List;

import br.ufmg.dcc.pm.parking.vehicle.DisabledPersonVehicle;
import br.ufmg.dcc.pm.parking.vehicle.LargeCar;
import br.ufmg.dcc.pm.parking.vehicle.Motocycle;
import br.ufmg.dcc.pm.parking.vehicle.SmallCar;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;

/**
 * Class representing the Building of the parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public class Building {
	
	/**
	 * The levels available in the building
	 */
	private Level[] levels;

	/**
	 * Constructs a new Building
	 * @param i The number of levels that will be available
	 */
	public Building(int i){
		levels = new Level[i];

		for(int z=0;z<i;z++) levels[z]= new Level(z);

	}
	
	/**
	 * Places a vehicle in the building
	 * @param vehicle The vehicle to place
	 * @param enterTime When the entrance happened
	 * @return
	 */
	public String enterVehicle(LargeCar vehicle, Calendar enterTime){
		String info = null;
		for(Level level : levels){
			info = level.enterVehicle(vehicle, enterTime);
			if(info!=null){
				return info;
			}
		}
		return info;
	}
	
	/**
	 * Places a vehicle in the building
	 * @param vehicle The vehicle to place
	 * @param enterTime When the entrance happened
	 * @return
	 */
	public String enterVehicle(SmallCar vehicle, Calendar enterTime){
		String info = null;
		for(Level level : levels){
			info = level.enterVehicle(vehicle, enterTime);
			if(info!=null){
				return info;
			}
		}
		return info;
	}
	
	/**
	 * Places a vehicle in the building
	 * @param vehicle The vehicle to place
	 * @param enterTime When the entrance happened
	 * @return
	 */
	public String enterVehicle(Motocycle vehicle, Calendar enterTime){
		String info = null;
		for(Level level : levels){
			info = level.enterVehicle(vehicle, enterTime);
			if(info!=null){
				return info;
			}
		}
		return info;
	}
	
	/**
	 * Places a vehicle in the building
	 * @param vehicle The vehicle to place
	 * @param enterTime When the entrance happened
	 * @return
	 */
	public String enterVehicle(DisabledPersonVehicle vehicle, Calendar enterTime){
		String info = null;
		for(Level level : levels){
			info = level.enterVehicle(vehicle, enterTime);
			if(info!=null){
				return info;
			}
		}
		return info;
	}

	/**
	 * Finds where a vehicle is placed
	 * @param vehicle The vehicle to look for
	 * @return The {@link Vacancy} where the {@link Vehicle} is placed
	 */
	public Vacancy<Vehicle> findVacancy(Vehicle vehicle){
		for(Level l : levels){
			for(List<Vacancy<Vehicle>> vacancys : l.getVacancies().values()){
				for(Vacancy<Vehicle> vacancy : vacancys){
					if(vehicle.equals(vacancy.getVehicle())){
						return vacancy;
					}
				}
			}
		}
		return null;
	}

}