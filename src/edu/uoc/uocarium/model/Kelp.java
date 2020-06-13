package edu.uoc.uocarium.model;

public class Kelp extends Item {

	private int growStep = 50;
	
	public Kelp(double xCoord, double height, Tank tank) throws ItemException {
		super(xCoord, Movable.TANK_PANE_HEIGHT-30, "./images/kelp/kelp_baby.png", 100, height, tank);		
	}
	
//	public void grow() throws ItemException {
//		this.setHeight(this.getHeight() + growStep);
//		if (this.getHeight() > 100 && this.getHeight() < 200) {
//			this.setSpriteImage("./images/kelp/kelp_medium.png");
//		}
//		if (this.getHeight() > 200) {
//			this.setSpriteImage("./images/kelp/kelp_big.png");
//		}
//	}

}
