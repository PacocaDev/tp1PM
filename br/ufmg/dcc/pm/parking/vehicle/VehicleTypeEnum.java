package br.ufmg.dcc.pm.parking.vehicle;

public enum VehicleTypeEnum {
		
	VP(6d  ),
	VG(8d  ),
	MT(3.5d),
	NE(6d  );
	
	private double price;
	
	private VehicleTypeEnum(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}
