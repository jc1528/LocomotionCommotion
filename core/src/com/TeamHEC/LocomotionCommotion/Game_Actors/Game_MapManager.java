package com.TeamHEC.LocomotionCommotion.Game_Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class Game_MapManager {

	private final static Array<Actor> actors = new Array<Actor>();
	
	public static Game_Map tempMap;
	public static Game_Map_Info mapInfo;
	


	public Game_MapManager(){	}
	
	public static void create(Stage stage){
		tempMap = new Game_Map();		
		actors.add(tempMap);
		
		mapInfo = new Game_Map_Info();
		actors.add(mapInfo);

		
		
		
		for (Actor a : actors){
				a.setTouchable(Touchable.enabled);
				

			stage.addActor(a);
		}
		
			

	}
	
	/*
	 * Serializes all actors and stores them in an array. This and the Game object
	 * are then saved and stored to be loaded.
	 */
	


}

