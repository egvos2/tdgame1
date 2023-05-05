package com.mygdx.twdef1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.twdef1.GameRes.*;
import static com.mygdx.twdef1.MainGameScreen.*;

public class GameDraw {
    // Draw flying stars
    public static void drawFlyingStars() {
        //batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (int i=0; i<nFlyingStars; i++) {
            int c = (int) stars[i][2];
            switch (c) {
                case 1:
                    sr.setColor(Color.LIGHT_GRAY);
                    break;
                case 2:
                    sr.setColor(Color.GRAY);
                    break;
                case 3:
                    sr.setColor(Color.DARK_GRAY);
                    break;
            }
            sr.rect(stars[i][0], stars[i][1], stars[i][2], stars[i][2]);
        }
        sr.end();
        //batch.begin();
    }

    public static void drawGameOver() {
        font3.draw(batch, "GAME OVER!", cameraWidth-unit*3, start_y-unit*4);
        font2.draw(batch, "Press Create Map button!", cameraWidth-unit*3.5f, start_y-unit*5);
    }

    public static void drawWinGame() {
        font3.draw(batch, "YOU WIN!", cameraWidth-unit*3, start_y-unit*4);
        font2.draw(batch, "Press Create Map button!", cameraWidth-unit*3.5f, start_y-unit*5);
    }

    public static void drawMap () {
        int i, j;
        for (i=0; i<gm.sizey; i++) {
            for (j=0; j<gm.sizex; j++) {
                switch (gm.map[i][j]) {
                    case 1:
                        batch.draw(img_bg2, j*unit+start_x, start_y-i*unit, unit, unit);
                        break;
                    case 2:
                        batch.draw(img_bg1, j*unit+start_x, start_y-i*unit, unit, unit);
                        break;
                    case 3:
                        batch.draw(img_bg1, j*unit+start_x, start_y-i*unit, unit, unit);
                        break;
                    case 4:
                        batch.draw(img_bg1, j*unit+start_x, start_y-i*unit, unit, unit);
                        break;
                }
            }
        }
    }

    // Draw towers
    public static void drawTowers () {
        int i;
        for (i=0; i<towers.size(); i++) {
            switch (towers.get(i).type) {
                case 0:
                    batch.draw(img_tow1, towers.get(i).x*unit+start_x, start_y-towers.get(i).y*unit, unit, unit);
                    break;
                case 1:
                    batch.draw(img_tow2, towers.get(i).x*unit+start_x, start_y-towers.get(i).y*unit, unit, unit);
                    break;
                case 2:
                    batch.draw(img_tow3, towers.get(i).x*unit+start_x, start_y-towers.get(i).y*unit, unit, unit);
                    break;
            }
        }
    }

    // Draw monsters
    public static void drawMonsters () {
        int i;
        for (i=0; i<monsters.size(); i++) {
            switch (monsters.get(i).type) {
                case 1:
                    switch (monsters.get(i).dir) {
                        case 1:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon11);
                            //batch.draw(img_mon11, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 2:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon12);
                            //batch.draw(img_mon12, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 3:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon13);
                            //batch.draw(img_mon13, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 4:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon14);
                            //batch.draw(img_mon14, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                    }
                    break;
                case 2:
                    switch (monsters.get(i).dir) {
                        case 1:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon21);
                            //batch.draw(img_mon21, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 2:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon22);
                            //batch.draw(img_mon22, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 3:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon23);
                            //batch.draw(img_mon23, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 4:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon24);
                            //batch.draw(img_mon24, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                    }
                    break;
                case 3:
                    switch (monsters.get(i).dir) {
                        case 1:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon31);
                            //batch.draw(img_mon31, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 2:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon32);
                            //batch.draw(img_mon32, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 3:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon33);
                            //batch.draw(img_mon33, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                        case 4:
                            drawMonsterAnim(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y, anim_mon34);
                            //batch.draw(img_mon34, monsters.get(i).or_x, monsters.get(i).or_y);
                            break;
                    }
                    break;
            }
            drawMonsterLifeFrame(monsters.get(i), monsters.get(i).or_x, monsters.get(i).or_y);
        }
    }

    // === Draw player life frame ===
    private static void drawMonsterLifeFrame (Monster mo, float x, float y) {
        // Draw life row value
        float t1 = (float)(mo.max_life) / 10;
        float t2 = (float)(mo.life) / t1;
        if (t2<1) t2 = 1;
        float t0 = unit/20;
        int i;
        for (i = 0; i < t2; i++) {
            if (i<t2)
                batch.draw (img_life_frame2, x+i*t0, y+unit/2+unit/10, unit/20, 6);
            else
                batch.draw (img_life_frame2_emp, x+i*t0, y+unit/2+unit/10, unit/20, unit/6);
        }
    }

    // Draw dead monsters
    public static void drawDeadMonsters() {
        int i;
        for (i=0; i<dead_monsters.size(); i++) {
            switch (dead_monsters.get(i).type) {
                case 1:
                    batch.draw(img_mon1d, dead_monsters.get(i).or_x, dead_monsters.get(i).or_y);
                    break;
                case 2:
                    batch.draw(img_mon2d, dead_monsters.get(i).or_x, dead_monsters.get(i).or_y);
                    break;
                case 3:
                    batch.draw(img_mon3d, dead_monsters.get(i).or_x, dead_monsters.get(i).or_y);
                    break;
            }
        }
    }

    // Draw fireballs
    public static void drawFireBalls() {
        int i, j;
        for (i=0; i<towers.size(); i++) {
            for (j=0; j<towers.get(i).fbs.size(); j++) {
                //batch.draw(img_fb1, towers.get(i).fbs.get(j).or_x, towers.get(i).fbs.get(j).or_y);
                drawFBAnim(towers.get(i).fbs.get(j), towers.get(i).fbs.get(j).or_x, towers.get(i).fbs.get(j).or_y, anim_fb);
            }
        }
    }

    // Draw monster animation
    public static void drawMonsterAnim (Monster mo, float x, float y, Animation anim) {
        mo.frame_anim_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = (TextureRegion) anim.getKeyFrame(mo.frame_anim_state, true);
        batch.draw(currentFrame, x, y, x+unit/4, y+unit/4, unit/2, unit/2, 1, 1, 0);
    }

    // Draw fireball animation
    public static void drawFBAnim (FireBall fb, float x, float y, Animation anim) {
        fb.frame_anim_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = (TextureRegion) anim.getKeyFrame(fb.frame_anim_state, true);
        batch.draw(currentFrame, x, y, x+unit/4, y+unit/4, unit/2, unit/2, 1, 1, 0);
    }

    // Draw selected tower
    public static void drawSelTower () {
        switch (sel_tower) {
            case 0:
                batch.draw(img_tow1, sel_x*unit+start_x, start_y-sel_y*unit, unit, unit);
                break;
            case 1:
                batch.draw(img_tow2, sel_x*unit+start_x, start_y-sel_y*unit, unit, unit);
                break;
            case 2:
                batch.draw(img_tow3, sel_x*unit+start_x, start_y-sel_y*unit, unit, unit);
                break;
        }
    }

    // Draw FPS
    public static void drawFPS () {
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 710);
        font.draw(batch, "Monsters: " + monsters.size(), 10, 695);
        /*if (monsters.size()>0) {
            font.draw(batch, "tx: " + monsters.getFirst().tx + " ty: " + monsters.getFirst().ty
                    + " tor_x: " + monsters.getFirst().tor_x + " tor_y: " + monsters.getFirst().tor_y, 10, 680);
            font.draw(batch, "x: " + monsters.getFirst().x + " y: " + monsters.getFirst().y
                    +" or_x: " + monsters.getFirst().or_x+ " or_y: " + monsters.getFirst().or_y, 10, 665);
        }*/

    }
}
