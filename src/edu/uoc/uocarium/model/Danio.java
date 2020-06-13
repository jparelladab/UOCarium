package edu.uoc.uocarium.model;

public class Danio extends Fish {

	public Danio(double xCoord, 
			double yCoord, 
			Gender gender,
			int age, 
			int energy, 
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, 
				yCoord,
				"./images/danio/danio",
				64.0,
				64.0,
				gender, 
				age, 
				1.0,
				0.2,
				0.002,
				Color.BRONZE,
				energy, 
				tank);
	}
	
	public int getOxygenConsumption() {
		return 12;
	}

	public void breathe() {
		// TODO
		
	}

}
