package br.ufmg.dcc.pm.parking;

import java.util.List;

import br.ufmg.dcc.pm.parking.vehicle.Vehicle;
import br.ufmg.dcc.pm.parking.vehicle.VehicleTypeEnum;

/**
 * Class representing the Building
 * @author Alexandre Alphonsos
 * @author Jerônimo Nunes Rocha
 *
 */
public class Building {
	
	private Level[] levels;

	public Building(int i){
		levels = new Level[i];

		for(int z=0;z<i;z++)
			levels[z]= new Level();

	}

	public boolean eventHandler(String info){

		if(info != null){

			String[] attributes = info.split(";");
			//System.out.print (attributes[0]);
			//System.out.print (attributes[1]);
			//System.out.print (attributes[2]);
			//System.out.println (attributes[3]);

			if(attributes[0].equals("E")){
				enterVehicle(attributes[1],attributes[2],attributes[3]);
			} else {
				exitVehicle(attributes[1],attributes[2],attributes[3]);
			}

			return true;
		}
		else{
			return false;
		}
	}

	public void enterVehicle(String time,String plate,String type){
		switch (type) {
		case "VP":
			insertVP(time,plate);
			break;
		case "MT":
			insertMT(time,plate);
			break;
		case "VG":
			insertVG(time,plate);
			break;
		case "NE":
			insertNE(time,plate);
			break;

		default:
			throw new IllegalArgumentException("Invalid vehicle type: " + type);

		}
	}



	public void exitVehicle(String time,String plate,String type){
		CarSpot<Vehicle> carSpot;
		carSpot=findCarSpot(plate);
		if(carSpot==null){
			System.out.println("O veículo não está no estacionamento");
			return;
		}
		else
			calculatePrice(carSpot,time);
	}

	public void insertMT(String time,String plate){

		//CHECK ALL MT SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isMtSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.MT,i,time,plate);
				return;
			}
		}
		//CHECK ALL VP SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVpSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.VP,i,time,plate);
				return;
			}
		}

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.VG,i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertVP(String time,String plate){

		//CHECK ALL VP SPOTS IN ALL LEVELS

		for(int i=0;i<4;i++){
			if(!levels[i].isVpSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.VP,i,time,plate);
				return;
			}
		}

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.VG,i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertVG(String time,String plate){

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.VG,i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertNE(String time,String plate){

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isNeSpotFull()){
				levels[i].insertVehicle(VehicleTypeEnum.NE,i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public CarSpot<Vehicle> findCarSpot(String plate){
		for(Level l : levels){
			for(List<CarSpot<Vehicle>> carSpots : l.getCarSpots()){
				for(CarSpot<Vehicle> carSpot : carSpots){
					if(carSpot.getVehicle()!=null && carSpot.getVehicle().getPlate().equals(plate)){
						return carSpot;
					}
				}
			}
		}
		return null;
	}

	public void calculatePrice(CarSpot<Vehicle> carSpot,String exitTime){
		String[] aux;
		int hourEntered,minutesEntered,hourGone,minutesGone;
		long iPart,aux2;
		double fPart;

		double minutesElapsed,hoursElapsed;

		aux = carSpot.getEntranceTime().split(":");

		hourEntered = Integer.parseInt(aux[0]);
		minutesEntered = Integer.parseInt(aux[1]);

		aux = exitTime.split(":");

		hourGone = Integer.parseInt(aux[0]);
		minutesGone = Integer.parseInt(aux[1]);

		minutesElapsed=(hourGone*60+minutesGone)-(hourEntered*60+minutesEntered);
		hoursElapsed=minutesElapsed/60;

		iPart = (long) hoursElapsed;
		fPart = hoursElapsed - iPart;

		fPart =fPart*60;
		aux2= Math.round( fPart);

		System.out.print(carSpot.getVehicle().getVehicleType());
		System.out.print(";");
		System.out.print(String.format("%02d", iPart));
		System.out.print(":");
		System.out.print(String.format("%02d", aux2));
		System.out.print(";");
		System.out.printf("%.2f", hoursElapsed*carSpot.getVehicle().getVehicleType().getPrice());
		System.out.println();

	}

}