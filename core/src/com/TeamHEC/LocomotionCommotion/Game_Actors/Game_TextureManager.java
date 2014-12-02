package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/*
 * Holds all the textures and file paths for all actors in StartMenu
 * This means if we need to change a file path you come here.
 */
public class Game_TextureManager {
	
	//Top Bar
	public static  Texture game_menuobject_topbar = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/TopBar.png"));
	public static  Texture game_menuobject_menubtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/menubtn.png"));
	
	//Resources
	public static  Texture game_menuobject_resourcesbar = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/resourcesbar.png"));
	//Bottom right corner
	public static  Texture game_menuobject_endturnbutton = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/endTurnBtn.png"));
	public static  Texture game_menuobject_cornerframe = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/cornerframe.png"));
	public static  Texture game_menuobject_infobutton = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/infobutton.png"));
	
	
	//Ticket on screen menu
	public static  Texture game_menuobject_ticketbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticketbtn.png"));
	public static  Texture game_menuobject_ticket = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticket.png"));
	public static  Texture game_menuobject_ticketenclosure = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_tickets/ticketenclosure.png"));
	
	//Map
	public static  Texture tempMap = new Texture(Gdx.files.internal("gameScreen/game_map/map.png"));
	public static  Texture mapInfo = new Texture(Gdx.files.internal("gameScreen/game_map/mapinfo.png"));
	
	//Pause Menu
	public static  Texture game_pause_blackoutscreen = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/screen.png"));
	public static  Texture game_pause_pauselogo = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/pauselogo.png"));
	public static  Texture game_pause_resumegame = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/resumegamebtn.png"));
	public static  Texture game_pause_loadgame = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/loadgamebtn.png"));
	public static  Texture game_pause_settings = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/settingsbtn.png"));
	public static  Texture game_pause_mainmenu = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/mainmenubtn.png"));
	public static  Texture game_pause_background = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/game_Pausemenu/pausebackground.png"));
	
	//shop
	public static  Texture game_shop_backdrop = new Texture(Gdx.files.internal("gameScreen/game_shop/shopbackdrop.png"));
	public static  Texture game_shop_backbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/backbtn.png"));
	public static  Texture game_shop_shopbtn = new Texture(Gdx.files.internal("gameScreen/game_shop/shopbtn.png"));
	public static  Texture game_shop_title = new Texture(Gdx.files.internal("gameScreen/game_shop/title.png"));
	//train depot
	public static  Texture game_traindepot_title = new Texture(Gdx.files.internal("gameScreen/game_traindepot/title.png"));
	public static  Texture game_traindepot_traindepotbtn = new Texture(Gdx.files.internal("gameScreen/game_traindepot/traindepotbtn.png"));
	//goals
	public static  Texture game_goals_goalscreenbtn = new Texture(Gdx.files.internal("gameScreen/game_MenuObjects/goalScreenBtn.png"));
	public static  Texture game_goals_title = new Texture(Gdx.files.internal("gameScreen/game_goalScreen/title.png"));
}
