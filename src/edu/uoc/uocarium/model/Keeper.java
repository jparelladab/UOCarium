package edu.uoc.uocarium.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keeper {
	private String id;
	private String name;
	private String surname;
	private List<Item> items;
	private List<Tank> tanks; //max 5!!
	
	public Keeper(String id, String name, String surname) throws KeeperException {
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.tanks = new ArrayList();
		this.items = new ArrayList();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 * @throws KeeperException 
	 */
	public void setId(String id) throws KeeperException{
		if (id == null)
			throw new NullPointerException();
		if (id.charAt(0) != 'G'){
			throw new KeeperException(KeeperException.MSG_ERR_ID_VALUE);
		}
		if (id.length() != 5) {
			throw new KeeperException(KeeperException.MSG_ERR_ID_LENGTH);
		}
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return the tanks
	 */
	public List<Tank> getTanks() {
		return tanks;
	}

	/**
	 * @param tanks the tanks to set
	 */
	public void setTanks(List<Tank> tanks) {
		this.tanks = tanks;
	}
	
	public void addTank(Tank tank) throws KeeperException {
		if(this.tanks.size() >= 5) {
			throw new KeeperException(KeeperException.MSG_ERR_TANKS_SIZE);
		}
		if(tanks.contains(tank)) {}
		else {
			this.tanks.add(tank);
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(String.format("[%s] %s %s: \n", this.getId(), this.getSurname(), this.getName()));
		for (Tank tank : this.getTanks()) {
			str.append(tank.getName() + "\n");
		}
		return str.toString();
	}

	
	
}
