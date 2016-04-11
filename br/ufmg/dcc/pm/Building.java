package br.ufmg.dcc.pm;

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
		Car car;
		car=findVehicle(plate);
		if(car==null){
			System.out.println("O veículo não está no estacionamento");
			return;
		}
		else
			calculatePrice(car,time);
	}

	public void insertMT(String time,String plate){

		//CHECK ALL MT SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isMtSpotFull()){
				levels[i].insertVehicle("MT",i,time,plate);
				return;
			}
		}
		//CHECK ALL VP SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVpSpotFull()){
				levels[i].insertVehicle("VP",i,time,plate);
				return;
			}
		}

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle("VG",i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertVP(String time,String plate){

		//CHECK ALL VP SPOTS IN ALL LEVELS

		for(int i=0;i<4;i++){
			if(!levels[i].isVpSpotFull()){
				levels[i].insertVehicle("VP",i,time,plate);
				return;
			}
		}

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle("VG",i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertVG(String time,String plate){

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isVgSpotFull()){
				levels[i].insertVehicle("VG",i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public void insertNE(String time,String plate){

		//CHECK ALL VG SPOTS IN ALL LEVELS
		for(int i=0;i<4;i++){
			if(!levels[i].isNeSpotFull()){
				levels[i].insertVehicle("NE",i,time,plate);
				return;
			}
		}
		System.out.println("LOTADO");
	}

	public Car findVehicle(String plate){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(levels[i].getVp()[j].isOccupied()){
					if(levels[i].getVp()[j].getCar().getPlate().equals(plate)){
						return levels[i].getVp()[j].getCar();
					}
				}
			}
			for(int k=0;k<2;k++){
				if(levels[i].getMt()[k].isOccupied()){
					if(levels[i].getMt()[k].getCar().getPlate().equals(plate)){

						return levels[i].getMt()[k].getCar();
					}
				}
			}
			for(int l=0;l<2;l++){
				if(levels[i].getVg()[l].isOccupied()){
					if(levels[i].getVg()[l].getCar().getPlate().equals(plate)){
						return levels[i].getVg()[l].getCar();
					}
				}
			}
			for(int m=0;m<2;m++){
				if(levels[i].getNe()[m].isOccupied()){
					if(levels[i].getNe()[m].getCar().getPlate().equals(plate)){
						return levels[i].getNe()[m].getCar();
					}
				}
			}	
		}
		return null;
	}

	public void calculatePrice(Car car,String exitTime){
		String[] aux;
		int hourEntered,minutesEntered,hourGone,minutesGone;
		long iPart,aux2;
		double fPart;

		double minutesElapsed,hoursElapsed;

		aux = car.getTime().split(":");

		hourEntered = Integer.parseInt(aux[0]);
		minutesEntered = Integer.parseInt(aux[1]);

		aux = exitTime.split(":");

		hourGone = Integer.parseInt(aux[0]);
		minutesGone = Integer.parseInt(aux[1]);

		//System.out.println("testetste");
		//System.out.println(hourEntered+":"+minutesEntered);
		//System.out.println(hourGone+":"+minutesGone);

		//System.out.println("testetste");

		minutesElapsed=(hourGone*60+minutesGone)-(hourEntered*60+minutesEntered);
		hoursElapsed=minutesElapsed/60;

		iPart = (long) hoursElapsed;
		fPart = hoursElapsed - iPart;

		fPart =fPart*60;
		aux2= Math.round( fPart);


		switch(car.getCarSpotType()){
		case "VP":
			System.out.print("VP;");
			System.out.print(String.format("%02d", iPart));
			System.out.print(":");
			System.out.print(String.format("%02d", aux2));
			System.out.print(";");
			System.out.printf("%.2f", hoursElapsed*6);
			System.out.println("");
			break;

		case "MT":
			System.out.print("MT;");
			System.out.print(String.format("%02d", iPart));
			System.out.print(":");
			System.out.print(String.format("%02d", aux2));
			System.out.print(";");
			System.out.printf("%.2f", hoursElapsed*3.5);
			System.out.println("");
			break;

		case "VG":
			System.out.print("VG;");
			System.out.print(String.format("%02d", iPart));
			System.out.print(":");
			System.out.print(String.format("%02d", aux2));
			System.out.print(";");
			System.out.printf("%.2f", hoursElapsed*8);
			System.out.println("");
			break;

		case "NE":
			System.out.print("NE;");
			System.out.print(String.format("%02d", iPart));
			System.out.print(":");
			System.out.print(String.format("%02d", aux2));
			System.out.print(";");
			System.out.printf("%.2f", hoursElapsed*6);
			System.out.println("");
			break;
		}


	}

}