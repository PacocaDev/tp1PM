package br.ufmg.dcc.pm.parking.vehicle;

public class DisabledPersonVehicle extends Vehicle {
	
	public static final VehicleTypeEnum TYPE = VehicleTypeEnum.NE;

	public DisabledPersonVehicle(String plate) {
		super(plate);
	}

	@Override
	public VehicleTypeEnum getVehicleType() {
		return TYPE;
	}

}
