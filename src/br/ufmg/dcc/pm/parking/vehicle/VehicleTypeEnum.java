package br.ufmg.dcc.pm.parking.vehicle;

/**
 * An enum containing all vehicles that can access the Parking lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jerônimo Nunes Rocha
 *
 */
public enum VehicleTypeEnum {
		
	VP(6d   , LargeCar.class                  ),
	VG(8d   , SmallCar.class             ),
	MT(3.5d , Motocycle.class            ),
	NE(6d   , DisabledPersonVehicle.class);
	
	private double price;
	
	private Class<? extends Vehicle> vehicleClass;
	
	private VehicleTypeEnum(double price,Class<? extends Vehicle> vehicleClass) {
		this.price = price;
		this.vehicleClass = vehicleClass;
	}

	public double getPrice() {
		return price;
	}
	
	public Class<? extends Vehicle> getVehicleClass() {
		return vehicleClass;
	}

}
