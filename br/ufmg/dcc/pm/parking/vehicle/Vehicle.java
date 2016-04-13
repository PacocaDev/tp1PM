package br.ufmg.dcc.pm.parking.vehicle;

public abstract class Vehicle {
	
	private String plate;

	public Vehicle(String plate) {
		super();
		this.plate = plate;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public abstract VehicleTypeEnum getVehicleType();

}
