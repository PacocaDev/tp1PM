package br.ufmg.dcc.pm.parking;
public class Car{
	
	private String time;
	private String plate;
	private String carSpotType;

	public Car(String time,String plate,String carSpotType){
		this.time=time;
		this.plate=plate;
		this.carSpotType=carSpotType;

	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getCarSpotType() {
		return carSpotType;
	}

	public void setCarSpotType(String carSpotType) {
		this.carSpotType = carSpotType;
	}
}