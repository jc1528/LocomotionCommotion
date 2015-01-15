package com.TeamHEC.LocomotionCommotion.Game_Actors;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.TeamHEC.LocomotionCommotion.Screens.GameScreen;
import com.TeamHEC.LocomotionCommotion.UI_Elements.Sprite;
import com.TeamHEC.LocomotionCommotion.UI_Elements.SpriteButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_ScreenMenu {
	public static ScreenMenuManager actorManager;
	public static Game_ResourcesManager resourceActorManager;

	public void create(Stage stage){
		actorManager = new ScreenMenuManager();
		actorManager.create(stage);
		resourceActorManager = new Game_ResourcesManager();
		resourceActorManager.create(stage);
	}
	public static class ScreenMenuManager {

		private final static Array<Actor> actors = new Array<Actor>();

		public  Sprite game_menuobject_topbar;
		public  SpriteButton game_menuobject_menubtn;

		public  SpriteButton game_menuobject_tickettoggle;
		public 	Sprite game_menuobject_ticketenclosure;
		public  SpriteButton game_menuobject_endturnbutton;
		public  Sprite game_menuobject_cornerframe;
		public  SpriteButton game_menuobject_infobutton;

		public  SpriteButton game_menuobject_shopbtn;
		public  SpriteButton game_menuobject_traindepotbtn;

		public  SpriteButton game_menuobject_goalscreenbtn;
		public  Label playerScore;

		public int menuobjectsStageStart, menuobjectsStageEnd;

		public ScreenMenuManager(){		}

		public void create(Stage stage){
			actors.clear();

			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = 32;

			BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
			generator.dispose();
			LabelStyle style = new LabelStyle();
			style.font = font;


			playerScore = new Label(null, style);
			playerScore.setColor(0,0,0,1);

			playerScore.setText(GameScreen.player1name+"    " + GameScreen.player1score +
					"     SCORE     "+ GameScreen.player2score+"     "+GameScreen.player2name
					+"                      "+" it's your turn ");
			playerScore.setX(600);
			playerScore.setY(Gdx.graphics.getHeight()- playerScore.getHeight() -45);

			
			
			game_menuobject_topbar = new Sprite(-20, Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_menuobject_topbar.getHeight() +10,
					Game_TextureManager.getInstance().game_menuobject_topbar );
			actors.add(game_menuobject_topbar);	

			game_menuobject_cornerframe=new Sprite((LocomotionCommotion.screenX-Game_TextureManager.getInstance().game_menuobject_cornerframe.getWidth()),14
					,Game_TextureManager.getInstance().game_menuobject_cornerframe);
			actors.add(game_menuobject_cornerframe);

			
			game_menuobject_menubtn = new SpriteButton(LocomotionCommotion.screenX-60, 
					Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_menuobject_menubtn.getHeight() - 30, Game_TextureManager.getInstance().game_menuobject_menubtn){
				
					@Override
					protected void onClicked()
					{
						if (Game_PauseMenu.actorManager.open== false)
						{
							Game_PauseMenu.actorManager.open= true;
							for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
								if (i > GameScreen.getStage().getActors().size-1){

								}else
									GameScreen.getStage().getActors().get(i).setVisible(true);

							}			}
						else
						{	Game_PauseMenu.actorManager.open= false;
						for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
							if (i > GameScreen.getStage().getActors().size-1){

							}else
								GameScreen.getStage().getActors().get(i).setVisible(false);

						}

						}
					}
			};
			
			actors.add(game_menuobject_menubtn);	
			
			game_menuobject_tickettoggle=new SpriteButton(30, Gdx.graphics.getHeight() - Game_TextureManager.getInstance().game_menuobject_ticketbtn.getHeight()-15,
					Game_TextureManager.getInstance().game_menuobject_ticketbtn){
				
					@Override
					protected void onClicked()
					{
						if (Game_goal_PlayerGoals.open== false)
						{
							Game_goal_PlayerGoals.open= true;
							for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
								if (i > GameScreen.getStage().getActors().size-1){

								}else
									GameScreen.getStage().getActors().get(i).setVisible(true);

							}
							Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(true);
						}
						else
						{	Game_goal_PlayerGoals.open= false;
						for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
							if (i > GameScreen.getStage().getActors().size-1){

							}else
								GameScreen.getStage().getActors().get(i).setVisible(false);

						}
						Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(false);
						}
					}
			};
			actors.add(game_menuobject_tickettoggle);

		
			game_menuobject_endturnbutton = new SpriteButton(LocomotionCommotion.screenX-Game_TextureManager.getInstance().game_menuobject_endturnbutton.getWidth()-15,
												15, Game_TextureManager.getInstance().game_menuobject_endturnbutton){
				
						@Override
						protected void onClicked()
						{
							
						}
			};
			actors.add(game_menuobject_endturnbutton);

			game_menuobject_infobutton = new SpriteButton(LocomotionCommotion.screenX-310, 63, Game_TextureManager.getInstance().game_menuobject_infobutton){
				
					@Override
					protected void onClicked()
					{
						if (Game_Map_Manager.infoVisible){
							Game_Map_Manager.mapInfo.setVisible(false);
							Game_Map_Manager.infoVisible= false;

						}else{
							Game_Map_Manager.mapInfo.setVisible(true);
							Game_Map_Manager.infoVisible= true;
						}
					}
			};
			actors.add(game_menuobject_infobutton);

			game_menuobject_shopbtn = new SpriteButton(LocomotionCommotion.screenX-310, 125, Game_TextureManager.getInstance().game_shop_shopbtn){
				
					@Override
					protected void onClicked()
					{
						if (Game_Shop.actorManager.open== false)
						{
							Game_Shop.actorManager.open= true;
							for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
								if (i > GameScreen.getStage().getActors().size-1){

								}else
									GameScreen.getStage().getActors().get(i).setVisible(true);

							}			}
							else
							{	Game_Shop.actorManager.open= false;
							for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
								if (i > GameScreen.getStage().getActors().size-1){
	
								}else
									GameScreen.getStage().getActors().get(i).setVisible(false);
	
							}
						}
					}
			};
			actors.add(game_menuobject_shopbtn);

			game_menuobject_traindepotbtn = new SpriteButton(LocomotionCommotion.screenX-310, 193, Game_TextureManager.getInstance().game_traindepot_traindepotbtn){
				
					@Override
					protected void onClicked()
					{
						if (Game_TrainDepot.actorManager.open== false)
						{
							Game_TrainDepot.actorManager.open= true;
							for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
								if (i > GameScreen.getStage().getActors().size-1){

								}else
									GameScreen.getStage().getActors().get(i).setVisible(true);

							}			}
						else
						{	
							Game_TrainDepot.actorManager.open= false;
							for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
								if (i > GameScreen.getStage().getActors().size-1){
	
								}else
									GameScreen.getStage().getActors().get(i).setVisible(false);
	
							}
						}
					}
			};
			actors.add(game_menuobject_traindepotbtn);

			game_menuobject_goalscreenbtn = new SpriteButton(110, Gdx.graphics.getHeight()- Game_TextureManager.getInstance().game_goals_goalscreenbtn.getHeight() -25,
							Game_TextureManager.getInstance().game_goals_goalscreenbtn){
				
						@Override
						protected void onClicked()
						{
							if (Game_Goal_GoalScreenManager.open== false)
							{
								Game_Goal_GoalScreenManager.open= true;
								Game_goal_PlayerGoals.goalMenuOpen();
								for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
									if (i > GameScreen.getStage().getActors().size-1){

									}else
										GameScreen.getStage().getActors().get(i).setVisible(true);

								}			}
							else
							{	
								Game_Goal_GoalScreenManager.open= false;
								Game_goal_PlayerGoals.goalMenuClose();
								
								for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
									if (i > GameScreen.getStage().getActors().size-1){
	
									}else
										GameScreen.getStage().getActors().get(i).setVisible(false);
									
								}
							}
						}
			};
			actors.add(game_menuobject_goalscreenbtn);

			actors.add(playerScore);

			menuobjectsStageStart = stage.getActors().size;
			menuobjectsStageEnd = menuobjectsStageStart+ actors.size-1;
			for (Actor a : actors){
				a.setTouchable(Touchable.enabled);
				a.setVisible(false);
				stage.addActor(a);
			}
			//Add the enclosure straight in as is not visible at start
			game_menuobject_ticketenclosure=new Sprite(-1,Gdx.graphics.getHeight()-Game_TextureManager.getInstance().game_menuobject_ticketenclosure.getHeight()-82
					,Game_TextureManager.getInstance().game_menuobject_ticketenclosure);
			game_menuobject_ticketenclosure.setVisible(false);
			stage.addActor(game_menuobject_ticketenclosure);




		}
		public int getStageStart(){
			return menuobjectsStageStart;
		}
		public int getStageEnd(){
			return menuobjectsStageEnd;
		}

		/*
		 * Serializes all actors and stores them in an array. This and the Game object
		 * are then saved and stored to be loaded.
		 */
		public static void saveActors()
		{
		}
	}

	//Screen Menu Actors--------------------------------------------------------------------------
<<<<<<< Updated upstream
=======
	//End Turn Button
	public static class Game_menuobject_EndTurnBtn extends Game_Actor {
		public Game_menuobject_EndTurnBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_endturnbutton; // reuse the new game back btn texture
			actorX = (LocomotionCommotion.screenX-texture.getWidth()-15) ;
			actorY = 15;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_EndTurnBtn)event.getTarget()).started = true;
					return true;
				}
			});

		}
		public void act(float delta){
			if(started){
				started = false;
			}
		}
	}
	//InfoToggleButton
	public static class Game_menuobject_InfoToggleBtn extends Game_Actor {
		public Game_menuobject_InfoToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_infobutton; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 63;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_InfoToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});

		}
		public void act(float delta){
			if(started){
				if (Game_Map_Manager.infoVisible){
					Game_Map_Manager.mapInfo.setVisible(false);
					Game_Map_Manager.infoVisible= false;

				}else{
					Game_Map_Manager.mapInfo.setVisible(true);
					Game_Map_Manager.infoVisible= true;
				}
				started = false;
			}
		}



	}
	//Pause Menu Button
	public static class Game_menuobject_MenuBtn extends Game_Actor {
		public Game_menuobject_MenuBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_menubtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-60 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() - 30;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_MenuBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_PauseMenu.actorManager.open== false)
				{
					Game_PauseMenu.actorManager.open= true;
					for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_PauseMenu.actorManager.open= false;
				for(int i=Game_PauseMenu.actorManager.getStageStart(); i<=Game_PauseMenu.actorManager.getStageEnd();i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				//				//NEW CARD PROTOTYPING
				//				OilCard newcard = new OilCard();
				//				Game_CardHand.actorManager.addCard(newcard);
				started = false;
			}
		}
	}
	//ShopBtn
	public static class Game_menuobject_ShopBtn extends Game_Actor {
		public Game_menuobject_ShopBtn(){
			texture = Game_TextureManager.getInstance().game_shop_shopbtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 125;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_ShopBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_Shop.actorManager.open== false)
				{
					Game_Shop.actorManager.open= true;
					for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_Shop.actorManager.open= false;
				for(int i=Game_Shop.actorManager.getStageStart(); i<=Game_Shop.actorManager.getStageEnd(); i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}

				}
				started = false;
			}
		}
	}
	//TicketToggle
	public static class Game_menuobject_TicketToggleBtn extends Game_Actor {
		public Game_menuobject_TicketToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_ticketbtn; 
			actorX = 30 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() -15;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_TicketToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_goal_PlayerGoals.open== false)
				{
					Game_goal_PlayerGoals.open= true;
					for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}
					Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(true);
				}
				else
				{	Game_goal_PlayerGoals.open= false;
				for(int i=Game_goal_PlayerGoals.stagestart; i<=Game_goal_PlayerGoals.stagestart +Game_goal_PlayerGoals.ticketActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);

				}
				Game_ScreenMenu.actorManager.game_menuobject_ticketenclosure.setVisible(false);
				}
				started = false;
			}
		}


	}

	//GoalScreenButton
	public static class Game_menuobjects_GoalScreenBtn extends Game_Actor {
		public Game_menuobjects_GoalScreenBtn(){
			texture = Game_TextureManager.getInstance().game_goals_goalscreenbtn; // reuse the new game back btn texture
			actorX = 110 ;
			actorY = Gdx.graphics.getHeight()- texture.getHeight() -25;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobjects_GoalScreenBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}
		public void act(float delta){
			if(started){
				if (Game_Goal_GoalScreenManager.open== false)
				{
					Game_Goal_GoalScreenManager.open= true;
					Game_goal_PlayerGoals.goalMenuOpen();
					Game_startGameManager.getStartedWindow.setVisible(false);
					Game_startGameManager.selectLabel.setVisible(false);
					for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	
				Game_Goal_GoalScreenManager.open= false;
				Game_goal_PlayerGoals.goalMenuClose();
				
				for(int i=Game_Goal_GoalScreenManager.stagestart; i<=Game_Goal_GoalScreenManager.stagestart +Game_Goal_GoalScreenManager.goalActors-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(false);
					
				}

				}
				started = false;
			}
		}
	}
	//TrainDeptButton
	public static class Game_menuobject_TrainDepotBtn extends Game_Actor {
		public Game_menuobject_TrainDepotBtn(){
			texture = Game_TextureManager.getInstance().game_traindepot_traindepotbtn; // reuse the new game back btn texture
			actorX = LocomotionCommotion.screenX-310 ;
			actorY = 193;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_menuobject_TrainDepotBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			if(started){
				if (Game_TrainDepot.actorManager.open== false)
				{
					Game_TrainDepot.actorManager.open= true;
					for(int i=Game_TrainDepot.actorManager.getStageStart(); i<=Game_TrainDepot.actorManager.getStageEnd();i++){
						if (i > GameScreen.getStage().getActors().size-1){
>>>>>>> Stashed changes

	//Resources toggle button
	public static class Game_resources_ToggleBtn extends Game_Actor {
		public Game_resources_ToggleBtn(){
			texture = Game_TextureManager.getInstance().game_menuobject_menubtn; // reuse the new game back btn texture
			actorX = 10 ;
			actorY = 30;
			setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
			addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((Game_resources_ToggleBtn)event.getTarget()).started = true;
					return true;
				}
			});
		}

		public void act(float delta){
			int expandedheight=180;
			if(started){
				if (Game_ScreenMenu.resourceActorManager.resourcebarexpanded== false)
				{	
					//Move up button, bar and quantities
					Game_ScreenMenu.resourceActorManager.game_resources_togglebtn.actorY+=expandedheight;
					setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
					Game_ScreenMenu.resourceActorManager.game_menuobject_resourcesbar.increaseY(expandedheight);
					Game_ResourcesManager.setResourcesHeight(Game_ScreenMenu.resourceActorManager.cardQuant.getY()+expandedheight);
					//move cards up
					Game_ScreenMenu.resourceActorManager.game_card_togglebtn.increaseY(expandedheight);
					Game_ScreenMenu.resourceActorManager.game_card_togglebtn.refreshBounds();
					Game_CardHand.actorManager.organiseDeck();
					Game_CardHand.actorManager.changeHeight(expandedheight);
					Game_CardHand.actorManager.usecardbtn.setVisible(false);


					Game_ScreenMenu.resourceActorManager.resourcebarexpanded= true;
					for(int i=Game_ResourcesManager.resourcesStageStart; i<=Game_ResourcesManager.resourcesStageStart +Game_ResourcesManager.resourcesStageEnd-1;i++){
						if (i > GameScreen.getStage().getActors().size-1){

						}else
							GameScreen.getStage().getActors().get(i).setVisible(true);

					}			}
				else
				{	Game_ScreenMenu.resourceActorManager.resourcebarexpanded= false;
				Game_CardHand.actorManager.usecardbtn.setVisible(false);
				//Move up
				Game_ScreenMenu.resourceActorManager.game_resources_togglebtn.actorY-=expandedheight;
				setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
				Game_ScreenMenu.resourceActorManager.game_menuobject_resourcesbar.increaseY(-expandedheight);
				Game_ResourcesManager.setResourcesHeight(Game_ScreenMenu.resourceActorManager.cardQuant.getY()-expandedheight);

				Game_ScreenMenu.resourceActorManager.game_card_togglebtn.increaseY(-expandedheight);
				Game_ScreenMenu.resourceActorManager.game_card_togglebtn.refreshBounds();
				Game_CardHand.actorManager.selectedCard=0;
				Game_CardHand.actorManager.changeHeight(-expandedheight);
				Game_CardHand.actorManager.organiseDeck();
				//end
				for(int i=Game_ResourcesManager.resourcesStageStart; i<=Game_ResourcesManager.resourcesStageStart +Game_ResourcesManager.resourcesStageEnd-1;i++){
					if (i > GameScreen.getStage().getActors().size-1){

					}else
						GameScreen.getStage().getActors().get(i).setVisible(true);

				}

				}
				started = false;
			}
		}
	}
	//Resources
	public static class Game_ResourcesManager {

		private final static Array<Actor> visibleActors = new Array<Actor>();

		public Sprite game_menuobject_resourcesbar;
		public Game_resources_ToggleBtn game_resources_togglebtn;
		public SpriteButton game_card_togglebtn;
		public boolean resourcebarexpanded = false;
		public static int  resourcesStageStart, resourcesStageEnd, expandedheight= 40;
		public static Label  goldQuant, coalQuant, oilQuant, electricityQuant, nuclearQuant;


		public Label cardQuant;


		public Game_ResourcesManager(){		}

		public void create(Stage stage){
			visibleActors.clear();
			resourcesStageStart=0;
			resourcesStageEnd =0;


			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = 19;

			BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
			generator.dispose();
			LabelStyle style = new LabelStyle();
			style.font = font;


			//Resources bar is now connected to variables for easy update of quantities.
			game_menuobject_resourcesbar = new Sprite(-13,-175,Game_TextureManager.getInstance().game_menuobject_resourcesbar);
			visibleActors.add(game_menuobject_resourcesbar);

			game_resources_togglebtn = new Game_resources_ToggleBtn();
			visibleActors.add(game_resources_togglebtn);


			goldQuant= new Label(null, style);
			goldQuant.setX(100);
			goldQuant.setY(expandedheight);
			goldQuant.setColor(0,0,0,1);

			coalQuant= new Label(null,style);
			coalQuant.setX(240);
			coalQuant.setY(expandedheight);
			coalQuant.setColor(0,0,0,1);


			oilQuant= new Label(null,style);
			oilQuant.setX(350);
			oilQuant.setY(expandedheight);
			oilQuant.setColor(0,0,0,1);

			electricityQuant= new Label(null,style);
			electricityQuant.setX(450);
			electricityQuant.setY(expandedheight);
			electricityQuant.setColor(0,0,0,1);

			nuclearQuant= new Label(null,style);
			nuclearQuant.setX(590);
			nuclearQuant.setY(expandedheight);
			nuclearQuant.setColor(0,0,0,1);

			cardQuant= new Label(null,style);
			cardQuant.setX(920);
			cardQuant.setY(expandedheight);
			cardQuant.setColor(0,0,0,1);

			refreshResources();

			visibleActors.add(goldQuant);
			visibleActors.add(coalQuant);
			visibleActors.add(oilQuant);
			visibleActors.add(electricityQuant);
			visibleActors.add(nuclearQuant);



			resourcesStageStart= stage.getActors().size;
			for (Actor a : visibleActors){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);
				stage.addActor(a);
				resourcesStageEnd ++;
			}
					
			game_card_togglebtn = new SpriteButton(670, 25, Game_TextureManager.getInstance().game_card_cardtoggle){
				
					@Override
					protected void onClicked()
					{
						if (Game_CardHand.actorManager.open== false)
						{
							Game_CardHand.actorManager.open= true; //set hand as open (visible)
							for(int i=Game_CardHand.actorManager.stagestart; i<=Game_CardHand.actorManager.stagestart +Game_CardHand.actorManager.cardActors-1;i++)	//Range of Card Actors
							{ 	
								if (i > GameScreen.getStage().getActors().size-1)
								{//This is just to avoid range errors
								}
								else
									GameScreen.getStage().getActors().get(i).setVisible(true); //Make Card Actors Visible
							}			
						}
						else
						{	
							Game_CardHand.actorManager.open= false; //set hand as closed (hidden)
							for(int i=Game_CardHand.actorManager.stagestart; i<=Game_CardHand.actorManager.stagestart +Game_CardHand.actorManager.cardActors-1;i++) //Range of Card Actors
							{		
								if (i > GameScreen.getStage().getActors().size-1)
								{//This is just to avoid range errors
								}
								else
									GameScreen.getStage().getActors().get(i).setVisible(false); //Make Card Actors Hidden
							}

							Game_CardHand.actorManager.selectedCard=0;	// 0 means that no card is selected 
							Game_CardHand.actorManager.organiseDeck(); 	//call OrganiseDeck - see Game_CardHand.organiseDeck() documentation
							Game_CardHand.actorManager.usecardbtn.setVisible(false);	//hide the usecard button
						}
					}
			};
			game_card_togglebtn.setVisible(false);
			
			stage.addActor(game_card_togglebtn);
			cardQuant.setVisible(false);
			stage.addActor(cardQuant);
		}

		public void refreshResources(){
			goldQuant.setText(""+GameScreen.gold);
			coalQuant.setText(""+GameScreen.coal);
			oilQuant.setText(""+GameScreen.oil);
			electricityQuant.setText(""+GameScreen.electricity);
			nuclearQuant.setText(""+GameScreen.nuclear);
			Game_ScreenMenu.resourceActorManager.cardQuant.setText(""+GameScreen.cards);
		}

		public static void setResourcesHeight(float height){
			goldQuant.setY(height);
			coalQuant.setY(height);
			oilQuant.setY(height);
			electricityQuant.setY(height);
			nuclearQuant.setY(height);
			Game_ScreenMenu.resourceActorManager.cardQuant.setY(height);
		}


		/*
		 * Serializes all actors and stores them in an array. This and the Game object
		 * are then saved and stored to be loaded.
		 */
		public static void saveActors()
		{

		}
	}
}
