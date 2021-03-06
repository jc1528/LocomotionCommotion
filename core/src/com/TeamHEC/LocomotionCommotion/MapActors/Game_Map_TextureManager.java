package com.TeamHEC.LocomotionCommotion.MapActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_Map_TextureManager{
	private static Game_Map_TextureManager instance = null;
	
	protected Game_Map_TextureManager()
	{}
	
	public static Game_Map_TextureManager getInstance() {
		if(instance == null)
			instance = new Game_Map_TextureManager();
		return instance;
	}	
	
	//Map
	public Texture map = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
	public Texture mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
	public Texture station = new Texture(Gdx.files.internal("gameScreen/game_map/station.png"));
	public Texture stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/Stop.png"));
	
	public Texture stationInfo = new Texture(Gdx.files.internal("gameScreen/game_map/stationInfoframe.png"));
	public Texture stationSelect = new Texture(Gdx.files.internal("gameScreen/game_map/stationSelectBtn.png"));
	public Texture trainInfo = new Texture(Gdx.files.internal("gameScreen/game_map/trainInfo.png"));
	public Texture trainInfoPlanRoute = new Texture(Gdx.files.internal("gameScreen/game_map/trainInfoPlanRoute.png"));
	
	public Texture junction = new Texture(Gdx.files.internal("gameScreen/game_map/junction.png"));
	public Texture junctionx2 = new Texture(Gdx.files.internal("gameScreen/game_map/junction2.png"));
	
	public Texture p1Station = new Texture(Gdx.files.internal("gameScreen/game_map/p1station.png"));
	public Texture p1Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1station2.png"));
	public Texture p1Train = new Texture(Gdx.files.internal("gameScreen/game_map/p1train.png"));
	public Texture p1Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p1train2.png"));
	
	public Texture p2Station = new Texture(Gdx.files.internal("gameScreen/game_map/p2station.png"));
	public Texture p2Stationx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2station2.png"));
	public Texture p2Train = new Texture(Gdx.files.internal("gameScreen/game_map/p2train.png"));
	public Texture p2Trainx2 = new Texture(Gdx.files.internal("gameScreen/game_map/p2train2.png"));
	
	public Texture routeBlip = new Texture(Gdx.files.internal("gameScreen/game_map/routeBlip.png"));
	public Texture redRouteBlip = new Texture(Gdx.files.internal("gameScreen/game_map/routeBlip2.png"));
	
}
