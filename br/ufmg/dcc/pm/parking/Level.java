package br.ufmg.dcc.pm.parking;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.dcc.pm.parking.vehicle.Car;
import br.ufmg.dcc.pm.parking.vehicle.DisabledPersonVehicle;
import br.ufmg.dcc.pm.parking.vehicle.LargeCar;
import br.ufmg.dcc.pm.parking.vehicle.Motocycle;
import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

public class Level {

	private List<List<CarSpot<Vehicle>>> carSpots;
	private List<CarSpot<Car>> vp;
	private List<CarSpot<Motocycle>> mt;
	private List<CarSpot<LargeCar>> vg;
	private List<CarSpot<DisabledPersonVehicle>> ne;

	@SuppressWarnings("unchecked")
	public Level(){
		carSpots = new ArrayList<>();
		vp = new ArrayList<>(4);
		carSpots.add((List<CarSpot<Vehicle>>)(List<?>)vp);
		mt = new ArrayList<>(2);
		carSpots.add((List<CarSpot<Vehicle>>)(List<?>)mt);
		vg = new ArrayList<>(2);
		carSpots.add((List<CarSpot<Vehicle>>)(List<?>)vg);
		ne = new ArrayList<>(2);
		carSpots.add((List<CarSpot<Vehicle>>)(List<?>)ne);

		for(int z=0;z<4;z++)
			vp.add(new CarSpot<Car>());

		for(int z=0;z<2;z++){
			mt.add(new CarSpot<Motocycle>());
			vg.add(new CarSpot<LargeCar>());
			ne.add(new CarSpot<DisabledPersonVehicle>());
		}

	}

	public boolean isVpSpotFull(){
		for(CarSpot<Car> v : vp){
			if(!v.isOccupied())
				return false;
		}

		return true;
	}

	public boolean isMtSpotFull(){
		for(CarSpot<Motocycle> v : mt){
			if(!v.isOccupied())
				return false;
		}

		return true;
	}

	public boolean isVgSpotFull(){
		for(CarSpot<LargeCar> v : vg){
			if(!v.isOccupied())
				return false;
		}

		return true;
	}

	public boolean isNeSpotFull(){
		for(CarSpot<DisabledPersonVehicle> v : ne){
			if(!v.isOccupied())
				return false;
		}

		return true;
	}

	public void insertVehicle(VehicleTypeEnum type,int level,String time,String plate){
		int carSpotNumber=0;

		switch(type){
			case VP:
				for(CarSpot<Car> carSpot : vp){
					if(!carSpot.isOccupied()){
						carSpot.setOccupied();
						carSpot.setVehicle(new Car(plate));
						carSpot.setEntranceTime(time);
						break;
					} else {
						carSpotNumber++;
					}
				}
				break;
			case MT:
				for(CarSpot<Motocycle> carSpot : mt){
					if(!carSpot.isOccupied()){
						carSpot.setOccupied();
						carSpot.setVehicle(new Motocycle(plate));
						carSpot.setEntranceTime(time);
						break;
					} else {
						carSpotNumber++;
					}
				}
				break;
			case VG:
				for(CarSpot<LargeCar> carSpot : vg){
					if(!carSpot.isOccupied()){
						carSpot.setOccupied();
						carSpot.setVehicle(new LargeCar(plate));
						carSpot.setEntranceTime(time);
						break;
					} else {
						carSpotNumber++;
					}
				}
				break;
			case NE:
				for(CarSpot<DisabledPersonVehicle> carSpot : ne){
					if(!carSpot.isOccupied()){
						carSpot.setOccupied();
						carSpot.setVehicle(new DisabledPersonVehicle(plate));
						carSpot.setEntranceTime(time);
						break;
					} else {
						carSpotNumber++;
					}
				}
				break;
		}

		System.out.println("N"+(++level)+type+(++carSpotNumber));
	}

	public List<CarSpot<Car>> getVp() {
		return vp;
	}

	public void setVp(List<CarSpot<Car>> vp) {
		this.vp = vp;
	}

	public List<CarSpot<Motocycle>> getMt() {
		return mt;
	}

	public void setMt(List<CarSpot<Motocycle>> mt) {
		this.mt = mt;
	}

	public List<CarSpot<LargeCar>> getVg() {
		return vg;
	}

	public void setVg(List<CarSpot<LargeCar>> vg) {
		this.vg = vg;
	}

	public List<CarSpot<DisabledPersonVehicle>> getNe() {
		return ne;
	}

	public void setNe(List<CarSpot<DisabledPersonVehicle>> ne) {
		this.ne = ne;
	}

	public List<List<CarSpot<Vehicle>>> getCarSpots() {
		return carSpots;
	}

	public void setCarSpots(List<List<CarSpot<Vehicle>>> carSpots) {
		this.carSpots = carSpots;
	}
}