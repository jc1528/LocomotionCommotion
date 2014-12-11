package com.TeamHEC.LocomotionCommotion.Screens;
/*
 * @author Robert Precious <rp825@york.ac.uk>
 * Game Screen is the Screen that handles everything in the game screen.
 * First we sort the Camera- create the stage, create the camera and set the dimensions and update
 * Then we create all the managers- these manage the actors and they are split up in to separate menu sections.
 * 
 * @param stage - The stage for the actors.
 * @param sb - The spritebatch (needed for textbox's etc)
 * @param camera - the camera
 * 
 * we have methods:
 * create - explained above
 * render - updates the camera, lets the actors act and draws the screen
 * resize - updates the screen size when window is resized
 * show - just calls create.
 * dispose - disposes of the stage
 * getStage and setStage - getters and setters for stage
 * resetScreen- used when reentering the screen- it resets all the settings.
 * 
 * 
 */

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_CardHandManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Goal_AManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Map_AManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_Pause_AManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ResourcesManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_ShopManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_TrainDepotManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_menuObject_AManager;
import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_menuobject_TicketAManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
	private static Stage stage;
	public static SpriteBatch sb;
	public OrthographicCamera camera;
	public static int coal, oil, electricity, nuclear,cards,player1score=1000,player2score;
	public static String player1name ="Vladimir", player2name ="Caleb";

	public static void create(){
		//Set up stage camera
		stage = new Stage(); 
		Camera camera = stage.getCamera();
		camera.viewportHeight= LocomotionCommotion.screenY;
		camera.viewportWidth= LocomotionCommotion.screenX;
		camera.update();

		//Instantiate the Managers
		Gdx.input.setInputProcessor(getStage());	
		stage.getActors().clear();
		
		Game_Map_AManager mapManger = new Game_Map_AManager();
		mapManger.create(getStage());
		
		Game_CardHandManager cardHandManager = new Game_CardHandManager();
		cardHandManager.create(getStage());

		Game_ResourcesManager resourceManager = new Game_ResourcesManager();
		resourceManager.create(getStage());

		Game_menuObject_AManager actorManager = new Game_menuObject_AManager();
		actorManager.create(getStage());

		Game_menuobject_TicketAManager ticketManager = new Game_menuobject_TicketAManager();
		ticketManager.create(getStage());

		Game_ShopManager shopManager = new Game_ShopManager();
		shopManager.create(getStage());

		Game_TrainDepotManager trainDepotManager = new Game_TrainDepotManager();
		trainDepotManager.create(getStage());

		Game_Goal_AManager goalScreenManager = new Game_Goal_AManager();
		goalScreenManager.create(getStage());
		
		Game_Pause_AManager pauseManager= new Game_Pause_AManager();
		pauseManager.create(getStage());
		
	}
	@Override
	public void render(float delta) {
		getStage().getCamera().update();

		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		getStage().act(Gdx.graphics.getDeltaTime());
		getStage().draw();

	}

	@Override
	public void resize(int width, int height) {
		getStage().getViewport().update(width, height, true);	
		LocomotionCommotion.screenX = width;
		LocomotionCommotion.screenY = height;
	}

	@Override
	public void show() {
		GameScreen.create();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
	public static void resetStage(){
	}

	@Override
	public  void dispose() {
		getStage().dispose();
		getStage().getActors().clear();
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		GameScreen.stage = stage;
	}

	public void  resetScreen(){
		Game_Map_AManager.infoVisible= false;
		Game_Pause_AManager.open = false;
		Game_menuobject_TicketAManager.open = false;
		Game_ShopManager.open = false;
		Game_TrainDepotManager.open = false;
		Game_ResourcesManager.resourcebarexpanded =false;
		Game_Goal_AManager.open= false;
		Game_CardHandManager.open=false;




	}
}
