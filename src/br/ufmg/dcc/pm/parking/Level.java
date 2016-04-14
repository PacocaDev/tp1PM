package br.ufmg.dcc.pm.parking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufmg.dcc.pm.parking.vehicle.LargeCar;
import br.ufmg.dcc.pm.parking.vehicle.DisabledPersonVehicle;
import br.ufmg.dcc.pm.parking.vehicle.SmallCar;
import br.ufmg.dcc.pm.parking.vehicle.Motocycle;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

public class Level {

	private List<Vacancy<SmallCar>> vp;
	private List<Vacancy<Motocycle>> mt;
	private List<Vacancy<LargeCar>> vg;
	private List<Vacancy<DisabledPersonVehicle>> ne;
	private Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> vacancys;
	
	private int level;

	@SuppressWarnings("unchecked")
	public Level(int level){
		this.level = level+1;
		vacancys = new HashMap<>(4);
		vp = new ArrayList<>(4);
		vacancys.put(VehicleTypeEnum.VP,(List<Vacancy<Vehicle>>)(List<?>)vp);
		mt = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.MT,(List<Vacancy<Vehicle>>)(List<?>)mt);
		vg = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.VG,(List<Vacancy<Vehicle>>)(List<?>)vg);
		ne = new ArrayList<>(2);
		vacancys.put(VehicleTypeEnum.NE,(List<Vacancy<Vehicle>>)(List<?>)ne);

		for(int z=0;z<4;z++)
			vp.add(new Vacancy<SmallCar>());

		for(int z=0;z<2;z++){
			mt.add(new Vacancy<Motocycle>());
			vg.add(new Vacancy<LargeCar>());
			ne.add(new Vacancy<DisabledPersonVehicle>());
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

	public List<Vacancy<SmallCar>> getVp() {
		return vp;
	}

	public void setVp(List<Vacancy<SmallCar>> vp) {
		this.vp = vp;
	}

	public List<Vacancy<Motocycle>> getMt() {
		return mt;
	}

	public void setMt(List<Vacancy<Motocycle>> mt) {
		this.mt = mt;
	}

	public List<Vacancy<LargeCar>> getVg() {
		return vg;
	}

	public void setVg(List<Vacancy<LargeCar>> vg) {
		this.vg = vg;
	}

	public List<Vacancy<DisabledPersonVehicle>> getNe() {
		return ne;
	}

	public void setNe(List<Vacancy<DisabledPersonVehicle>> ne) {
		this.ne = ne;
	}

	public Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> getCarSpots() {
		return vacancys;
	}

	public void setCarSpots(Map<VehicleTypeEnum, List<Vacancy<Vehicle>>> vacancys) {
		this.vacancys = vacancys;
	}
}