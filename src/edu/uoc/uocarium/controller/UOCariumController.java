package edu.uoc.uocarium.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import edu.uoc.uocarium.model.Animal;
import edu.uoc.uocarium.model.AnimalException;
import edu.uoc.uocarium.model.AnimalStatus;
import edu.uoc.uocarium.model.Corydoras;
import edu.uoc.uocarium.model.Danio;
import edu.uoc.uocarium.model.Fish;
import edu.uoc.uocarium.model.Food;
import edu.uoc.uocarium.model.Gender;
import edu.uoc.uocarium.model.Item;
import edu.uoc.uocarium.model.ItemException;
import edu.uoc.uocarium.model.Keeper;
import edu.uoc.uocarium.model.Movable;
import edu.uoc.uocarium.model.MovableException;
import edu.uoc.uocarium.model.Snail;
import edu.uoc.uocarium.model.SubmarineToy;
import edu.uoc.uocarium.model.Tank;
import edu.uoc.uocarium.model.TankException;
import edu.uoc.uocarium.model.Tetra;

public class UOCariumController {

	Database database;
	String tankSelected;
	
	public UOCariumController(String folderName) throws ItemException {
		database = new Database(folderName);
		tankSelected = (database.getTanks().size()!=0)? database.getTanks().get(0).getId():null;
	}
		
	public String getTankSelected() {
		return tankSelected;
	}
	
	public void setTankSelected(String tankSelected) {
		this.tankSelected = tankSelected;
	}

	public List<Tank> getTanks(){
		List<Tank> tanks = database.getTanks();
		//TODO
		Collections.sort(tanks);
		return tanks;
	}
	
	public Tank getTank(String id) {
		return database.getTank(id);
	}
	
	public List<Item> getMovableItems(){
		//TODO
		return this.getItems().stream().filter(item -> item instanceof Movable).collect(Collectors.toList());			
	}
	
	public List<Item> getItems(){		
		return database.getTank(getTankSelected()).getItems();
	}
	
	public void addFish() throws AnimalException, ItemException, MovableException, TankException{
		//TODO
		int random = (int) (Math.random() * 10);
		Gender gender = (Math.random() < 0.5) ? Gender.MALE : Gender.FEMALE;
		Fish fish;
		if(random < 3) {
			new Danio(Math.random()*300,Math.random()*300, gender , 0, 100, getTank(getTankSelected()));
		} else if (random >= 3 && random < 6) {
			new Tetra(Math.random()*300,Math.random()*300, gender , 0, 100, getTank(getTankSelected()));
		} else {
			new Corydoras(Math.random()*300,Math.random()*300, gender , 0, 100, getTank(getTankSelected()));
		}
		
	}
	
	public SubmarineToy getSubmarineToy() {
		
		Optional<Item> op = database.getTank(getTankSelected()).getItems().stream().filter(p -> p instanceof SubmarineToy).findFirst();
		
		return op.isEmpty() ? null : (SubmarineToy) op.get();			
				
	}
	
	public boolean isSubmarineToy() {
		return getSubmarineToy() != null;
	}
	
	public void toggleSubmarineToy() throws TankException, ItemException, MovableException{
		//TODO
		if(isSubmarineToy()) {
			getTank(getTankSelected()).removeItem(getSubmarineToy());
		} else {
			new SubmarineToy(50,50,100,50,getTank(getTankSelected()));
		}
	}
	
	public String getTankInfo() {
		return getTank(getTankSelected()).toString();
	}
	
	public List<Item> removeDeadItems(){
		//TODO
		List<Item> deadItems = new ArrayList<Item>();
		
		//Guardamos en una lista auxiliar los items a borrar
		for(Item item : getItems()) {
			if(item instanceof Animal && ((Animal)item).getStatus() == AnimalStatus.DEAD) {
				deadItems.add(item);
			}
		}
		/*
		List<Item> deadItems = getTank(getTankSelected()).getItems().stream()
				.map(it -> (Animal) it)
				.filter(animal -> animal.isDead())
				.collect(Collectors.toList());
		*/
		getTank(getTankSelected()).removeDeadItems();
		return deadItems;
	}
	
	public void feed() throws Exception {
		new Food((new Random()).nextInt(Movable.TANK_PANE_WIDTH-10),0,1,1,5,getTank(getTankSelected()));	
		
	}
	
	public List<Keeper> getKeepers(){
		return database.getKeepers();
	}
}
