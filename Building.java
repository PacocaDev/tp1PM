public class Building{
	Level[] levels;

	public Building(int i){
		levels = new Level[i];
		
		for(int z=0;z<i;z++)
		levels[z]= new Level();
		
	}

	public boolean eventHandler(String info){
		
		if(info != null){
			
			String[] attributes = info.split(";");
			System.out.print (attributes[0]);
			System.out.print (attributes[1]);
			System.out.print (attributes[2]);
			System.out.println (attributes[3]);
			
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



	public void exitVehicle(String time,String plate,String type){}

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
	
}