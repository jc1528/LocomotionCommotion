package com.TeamHEC.LocomotionCommotion.Train;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Manager;
import com.TeamHEC.LocomotionCommotion.MapActors.Game_Map_Train;
import com.TeamHEC.LocomotionCommotion.Player.Player;
import com.TeamHEC.LocomotionCommotion.Resource.Fuel;

/**
 * @author Matthew Taylor <mjkt500@york.ac.uk>
 */

public class Train {	
	private String name;
	private int baseSpeed, speedMod;
	
	private Fuel fuel;
	public int fuelPerTurn;
	
	private int value; // Might need to change after updgrades
	private boolean inStation;
	private Player owner;
	
	public final Route route;
	
	// The UI blip for the Train:
	private Game_Map_Train trainActor;
	// An ArrayList of upgrades the train possesses
	private ArrayList<TrainUpgrade> upgrades = new ArrayList<TrainUpgrade>();
	
	/**
	 * The superclass of Train types, Creates a Train for player.
	 * @param fuelType Type of fuel the train consumes
	 * @param speedMod Any speed modifications made to the train
	 * @param value The price of the train
	 * @param inStation whether the train is currently in a station
	 * @param route The route the train is currently using
	 * @param owner The owner of the train
	 */
	public Train(String name, Fuel fuelType, int baseSpeed, int speedMod, int value, boolean inStation, Route route, Player owner)
	{
		this.name = name;
		this.fuel = fuelType;
		
		this.baseSpeed = baseSpeed;
		this.speedMod = speedMod;
		this.value = value;
		this.inStation = inStation;
		this.route = route;
		this.route.train = this;
		this.owner = owner;
		
		// The UI blip for each train
		if(Game_Map_Manager.trainBlips.size > 0)
		{
			trainActor = Game_Map_Manager.trainBlips.pop();
			trainActor.createBlip(this);
		}
		else
			throw new NullPointerException("trainActor never initialised");
		
		route.register(owner);
	}
	
	// =========== Getters ===========
	/**
	 * @return The Actor (UI Element) for the train
	 */
	public Game_Map_Train getActor()
	{
		return trainActor;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	/**
	 * @return Speed of the train with upgrades:
	 */
	public int getSpeed()
	{
		return baseSpeed + speedMod;
	}
	
	public int getSpeedMod()
	{
		return speedMod;
	}
	
	public int getFuelPerTurn()
	{
		return fuelPerTurn;
	}
		
	/**
	 * @return The amount of fuel for the remaining route:
	 */
	public int getFuelRouteCost()
	{
		return getFuelLengthCost(route.getLengthRemaining());
	}
	/**
	 * @param length the length of distance you want to travel
	 * @return The amount of fuel needed to travel that distance 
	 */
	public int getFuelLengthCost(float length)
	{
		return Math.round((float)(fuel.cost * fuelPerTurn * (length*0.0002)));
	}
	/**
	 * @return A string of the fuel used by a train:
	 */
	public String getFuelType()
	{
		return fuel.getType();				
	}
	
	public Route getRoute()
	{
		return route;
	}
	
	// =========== Setters ===========
	
	public void setSpeedMod(int speedMod)
	{
		this.speedMod = speedMod;
	}
	
	public void setFuelPerTurn(int fuelPerTurn)
	{
		this.fuelPerTurn = fuelPerTurn;
	}
		
	public void increaseSpeedMod(int by)
	{
		speedMod += by;
	}
	
	public void decreaseFuelPerTurn(int by)
	{
		fuelPerTurn -= by;
	}
	
	public void setInStation(boolean inStation)
	{
		this.inStation = inStation;
	}
	
	// =========== Train Operations ===========
	
	public boolean isInStation()
	{
		return inStation;
	}	
	
	/**
	 * Moves the train through it's route
	 */
	public void moveTrain()
	{
		if(!route.getRoute().isEmpty())
		{
			getActor().canMove = true;
		}
	}
	
	/**
	 * Adds an upgrade to the current train:
	 * @param upgrade The upgrade to be added
	 */
	public void addUpgrade(TrainUpgrade upgrade)
	{
		upgrade.addUpgrade();
		upgrades.add(upgrade);
	}
	/**
	 * Removes an upgrade from a train
	 * @param upgrade the upgrade to be removed
	 */
	public void removeUpgrade(TrainUpgrade upgrade)
	{
		upgrade.undoUpgrade();
		upgrades.remove(upgrade);
	}
}
