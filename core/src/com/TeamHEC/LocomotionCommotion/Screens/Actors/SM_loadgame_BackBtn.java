package com.TeamHEC.LocomotionCommotion.Screens.Actors;

import com.TeamHEC.LocomotionCommotion.Screens.StartMenu;
import com.TeamHEC.LocomotionCommotion.Screens.TextureManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SM_loadgame_BackBtn extends Actor {

	Texture texture = TextureManager.sm_newgame_BackBtn; // Reuse Texture the BackButton from new game
	float actorX = 1250+ 180 ,actorY = 675;
	public boolean started = false;

	public SM_loadgame_BackBtn(){
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
		addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				((SM_loadgame_BackBtn)event.getTarget()).started = true;
				return true;
			}
		});
	}


	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(texture,actorX,actorY);
	}

	@Override
	public void act(float delta){
		if(started){
			StartMenu.changeCam(-1250, 0);
			started = false;
		}
	}
}