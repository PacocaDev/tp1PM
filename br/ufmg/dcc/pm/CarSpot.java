package br.ufmg.dcc.pm;

public class CarSpot {
	
	private boolean occupied = false;
	
	private Car car;
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public void setOccupied() {
		this.occupied = true;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}