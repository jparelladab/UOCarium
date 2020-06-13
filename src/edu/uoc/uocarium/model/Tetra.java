package edu.uoc.uocarium.model;

public class Tetra extends Fish{
	
	public Tetra(double xCoord, 
			double yCoord, 
			Gender gender,
			int age, 
			int energy, 
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, 
				yCoord,
				"./images/tetra/tetra",
				64,
				64,
				gender, 
				age, 
				0.5,
				0.3,
				0.002,
				Color.RED,
				energy, 
				tank);
		// TODO Auto-generated constructor stub
	}
	
	public int getOxygenConsumption() {
		return 10;
	}

	public void breathe() {
		// TODO
	}

}
