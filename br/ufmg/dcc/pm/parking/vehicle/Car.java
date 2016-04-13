package br.ufmg.dcc.pm.parking.vehicle;

public class Car extends Vehicle {

	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.VG;

	public Car(String plate) {
		super(plate);
	}

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}

}
