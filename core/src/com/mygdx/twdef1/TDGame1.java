package com.mygdx.twdef1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TDGame1 extends Game {
	public static GameRes gr;

	@Override
	public void create () {
		// Load Game Resources
		gr = new GameRes();
		gr.loadPng();
		gr.loadFonts ();
		gr.manager.finishLoading();
		// Run Main menu screen
		this.setScreen(new MainGameScreen(this));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
