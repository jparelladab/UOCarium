package edu.uoc.uocarium.model;

public class Corydoras extends Fish{
	
	public Corydoras(double xCoord, 
			double yCoord, 
			Gender gender,
			int age, 
			int energy, 
			Tank tank) throws AnimalException, ItemException, MovableException {
		super(xCoord, 
				yCoord,
				"./images/corydoras/corydoras",
				64,
				64,
				gender, 
				age, 
				0.1,
				0.5,
				0.001,
				Color.BLUE,
				energy, 
				tank);
		// TODO Auto-generated constructor stub
	}
	
	public int getOxygenConsumption() {
		return 18;
	}

	public void breathe() {
		// TODO
	}


}
