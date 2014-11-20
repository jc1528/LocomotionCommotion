package com.TeamHEC.LocomotionCommotion.Screens.Actors;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

public class ActorManager {
	
	private final static Array<Actor> actors = new Array<Actor>();
	private static NewGameActor newgame;
	private static LinesActor lines;
	
	
	private int h = 1050;
	
	
	public ActorManager(){
		//Lines
//		lines = new LinesActor();
//		actors.add(lines);
//	
//		newgame = new NewGameActor();
//		actors.add(newgame);
//		
	}
	
	public static void create(Stage stage){
		//Lines
				lines = new LinesActor();
				actors.add(lines);
			
				newgame = new NewGameActor();
				actors.add(newgame);
		for (Actor a : actors){
			a.setTouchable(Touchable.enabled);
			stage.addActor(a);
		}
       
	}
	
	public void addActor(Actor actor){
		actors.add(actor);
	}
	

}

