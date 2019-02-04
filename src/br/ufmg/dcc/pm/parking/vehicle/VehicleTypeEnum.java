package br.ufmg.dcc.pm.parking.vehicle;

/**
 * An enum containing all vehicles that can access the Parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
 *
 */
public enum VehicleTypeEnum {
		
	VP(6d   , SmallCar.class                  ),
	VG(8d   , LargeCar.class             ),
	MT(3.5d , Motocycle.class            ),
	NE(6d   , DisabledPersonVehicle.class);
	
	private double price;
	
	private Class<? extends Vehicle> vehicleClass;
	
	private VehicleTypeEnum(double price,Class<? extends Vehicle> vehicleClass) {
		this.price = price;
		this.vehicleClass = vehicleClass;
	}

	/**
	 * @return How much the {@link Vehicle} that has this {@link VehicleTypeEnum}
	 * @return must pay for every hour spent at the Parking Lot
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return Which {@link Class} of {@link Vehicle} is of this {@link VehicleTypeEnum}
	 */
	public Class<? extends Vehicle> getVehicleClass() {
		return vehicleClass;
	}

}
