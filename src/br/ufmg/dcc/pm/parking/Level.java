package br.ufmg.dcc.pm.parking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufmg.dcc.pm.parking.vehicle.DisabledPersonVehicle;
import br.ufmg.dcc.pm.parking.vehicle.LargeCar;
import br.ufmg.dcc.pm.parking.vehicle.Motocycle;
import br.ufmg.dcc.pm.parking.vehicle.SmallCar;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

/**
 * Represents a Level of a building, contains all vacancies of the level
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public class Level {

	private Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> vacancys;
	
	private int level;

	/**
	 * Constructs a new {@link Level}
	 * @param level The number (starting at zero) of the level
	 */
	public Level(int level){
		this.level = level+1;
		vacancys = new HashMap<>(4);
		ArrayList<Vacancy<Vehicle>> vp = new ArrayList<>(4);
		vacancys.put(VehicleTypeEnum.VP,vp);
		ArrayList<Vacancy<Vehicle>> mt = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.MT,mt);
		ArrayList<Vacancy<Vehicle>> vg = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.VG,vg);
		ArrayList<Vacancy<Vehicle>> ne = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.NE,ne);

		for(int z=0;z<4;z++) {
			vp.add(new Vacancy<Vehicle>());
		}

		for(int z=0;z<2;z++){
			mt.add(new Vacancy<Vehicle>());
			vg.add(new Vacancy<Vehicle>());
			ne.add(new Vacancy<Vehicle>());
		}

	}
	
	public String enterVehicle(LargeCar vehicle, Calendar time) {
		return enterVehicle(vehicle, time, VehicleTypeEnum.VG);
	}
	
	public String enterVehicle(SmallCar vehicle, Calendar time) {
		return enterVehicle(vehicle, time, VehicleTypeEnum.VP);
	}
	
	public String enterVehicle(Motocycle vehicle, Calendar time) {
		return enterVehicle(vehicle, time, VehicleTypeEnum.MT);
	}
	
	public String enterVehicle(DisabledPersonVehicle vehicle, Calendar time) {
		return enterVehicle(vehicle, time, VehicleTypeEnum.NE);
	}

	private String enterVehicle(Vehicle vehicle, Calendar time, VehicleTypeEnum vacancyType){
		int vacancyNumber = 1;
		for(Vacancy<Vehicle> vacancy : vacancys.get(vacancyType)){
			if(!vacancy.isOccupied()){
				vacancy.setOccupied();
				vacancy.setVehicle(vehicle);
				vacancy.setEntranceTime(time);
				return "N"+level+vacancyType+vacancyNumber;
			} else {
				vacancyNumber++;
			}
		}
		return null;
	}

	public Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> getCarSpots() {
		return vacancys;
	}

	public void setCarSpots(Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> vacancys) {
		this.vacancys = vacancys;
	}
}