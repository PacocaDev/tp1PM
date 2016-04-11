package br.ufmg.dcc.pm;
public class Level{
	private CarSpot vp[];
	private CarSpot mt[];
	private CarSpot vg[];
	private CarSpot ne[];

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
			if(!vp[z].isOccupied())
				return false;
		}

		return true;
	}
	public boolean isMtSpotFull(){
		for(int z=0;z<2;z++){
			if(!mt[z].isOccupied())
				return false;
		}

		return true;
	}
	public boolean isVgSpotFull(){
		for(int z=0;z<2;z++){
			if(!vg[z].isOccupied())
				return false;
		}

		return true;
	}
	public boolean isNeSpotFull(){
		for(int z=0;z<2;z++){
			if(!ne[z].isOccupied())
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
					if(!vp[i].isOccupied()){
						vp[i].setOccupied();
						carSpotNumber=i;
						vp[i].setCar(car);
						break;
					}
				}
				
			break;
			case "MT":
				for(int i=0;i<2;i++){
					if(!mt[i].isOccupied()){
						mt[i].setOccupied();
						carSpotNumber=i;
						mt[i].setCar(car);
						break;
					}
				}
				
			break;
			case "VG":
				for(int i=0;i<2;i++){
					if(!vg[i].isOccupied()){
						vg[i].setOccupied();
						carSpotNumber=i;
						vg[i].setCar(car);
						break;
					}
				}
				
			break;
			case "NE":
				for(int i=0;i<2;i++){
					if(!ne[i].isOccupied()){
						ne[i].setOccupied();
						carSpotNumber=i;
						ne[i].setCar(car);
						break;
					}
				}
				
			break;

			default:
             throw new IllegalArgumentException("Invalid vehicle type: " + carSpotType);
		}

		System.out.println("N"+(++level)+carSpotType+(++carSpotNumber));
	}

	public CarSpot[] getVp() {
		return vp;
	}

	public void setVp(CarSpot[] vp) {
		this.vp = vp;
	}

	public CarSpot[] getMt() {
		return mt;
	}

	public void setMt(CarSpot[] mt) {
		this.mt = mt;
	}

	public CarSpot[] getVg() {
		return vg;
	}

	public void setVg(CarSpot[] vg) {
		this.vg = vg;
	}

	public CarSpot[] getNe() {
		return ne;
	}

	public void setNe(CarSpot[] ne) {
		this.ne = ne;
	}
}