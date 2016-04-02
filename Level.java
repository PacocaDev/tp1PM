public class Level{
	CarSpot vp[];
	CarSpot mt[];
	CarSpot vg[];
	CarSpot ne[];

	public Level(){
		vp = new CarSpot[4];
		mt = new CarSpot[2];
		vg = new CarSpot[2];
		ne = new CarSpot[2];

		for(int z=0;z<4;z++)
		vp[z]= new CarSpot();

		for(int z=0;z<2;z++)
		mt[z]= new CarSpot();

		for(int z=0;z<2;z++)
		vg[z]= new CarSpot();

		for(int z=0;z<2;z++)
		ne[z]= new CarSpot();
	}

	public boolean isVpSpotFull(){
		for(int z=0;z<4;z++){
			if(!vp[z].occupied)
				return false;
		}

		return true;
	}
	public boolean isMtSpotFull(){
		for(int z=0;z<2;z++){
			if(!mt[z].occupied)
				return false;
		}

		return true;
	}
	public boolean isVgSpotFull(){
		for(int z=0;z<2;z++){
			if(!vg[z].occupied)
				return false;
		}

		return true;
	}
	public boolean isNeSpotFull(){
		for(int z=0;z<2;z++){
			if(!ne[z].occupied)
				return false;
		}

		return true;
	}

	public void insertVehicle(String carSpotType,int level,String time,String plate){
		int carSpotNumber=0;
		Car car = new Car(time,plate,carSpotType);

		switch(carSpotType){
			case "VP":
				for(int i=0;i<4;i++){
					if(!vp[i].occupied){
						vp[i].occupied = true;
						carSpotNumber=i;
						vp[i].car=car;
						break;
					}
				}
				
			break;
			case "MT":
				for(int i=0;i<2;i++){
					if(!mt[i].occupied){
						mt[i].occupied = true;
						carSpotNumber=i;
						mt[i].car=car;
						break;
					}
				}
				
			break;
			case "VG":
				for(int i=0;i<2;i++){
					if(!vg[i].occupied){
						vg[i].occupied = true;
						carSpotNumber=i;
						vg[i].car=car;
						break;
					}
				}
				
			break;
			case "NE":
				for(int i=0;i<2;i++){
					if(!ne[i].occupied){
						ne[i].occupied = true;
						carSpotNumber=i;
						ne[i].car=car;
						break;
					}
				}
				
			break;

			default:
             throw new IllegalArgumentException("Invalid vehicle type: " + carSpotType);
		}

		System.out.println("N"+(++level)+carSpotType+(++carSpotNumber));
	}
}