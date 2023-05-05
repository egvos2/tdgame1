package com.mygdx.twdef1;

import static com.mygdx.twdef1.GameRes.*;
import static com.mygdx.twdef1.MainGameScreen.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class GameGUI {
    TextButton but1;
    TextButton but2;
    TextButton.TextButtonStyle tb_style_1;
    TextButton.TextButtonStyle tb_style_2;

    public void createGUI (Table tab) {
        // Set button style
        tb_style_1 = new TextButton.TextButtonStyle();
        tb_style_1.font = font;
        tb_style_1.fontColor = Color.LIGHT_GRAY;
        tb_style_1.up = new Image(img_but2).getDrawable();
        tb_style_1.down = new Image(img_but2).getDrawable();
        tb_style_1.checked = new Image(img_but2).getDrawable();
        // Set button "Create Map"
        but1 = new TextButton("", tb_style_1);
        but1.setText("Create Map");
        but1.setWidth(150);
        but1.setHeight(53);
        tab.add(but1).expandX().padTop(10);
        but1.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if (!bStartGame) {
                    monster_counter = 0;
                    bTowersCompleted = false;
                    bWinGame = false;
                    bFinishGame = false;
                    towers.clear();
                    monsters.clear();
                    dead_monsters.clear();
                    gm.createMap();
                }
            }
        });
        tab.row();
        // Set button "Start Game"
        but2 = new TextButton("", tb_style_1);
        but2.setText("Start Game");
        but2.setWidth(150);
        but2.setHeight(53);
        tab.add(but2).expandX().padTop(10);
        but2.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                bStartGame = !bStartGame;
            }
        });
    }

    // Add Game Over Dialog
    public void addGameOverDialog () {

    }
}
