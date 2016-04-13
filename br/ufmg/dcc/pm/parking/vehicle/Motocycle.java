package br.ufmg.dcc.pm.parking.vehicle;

public class Motocycle extends Vehicle {

	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.MT;

	public Motocycle(String plate) {
		super(plate);
	}

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}

}
