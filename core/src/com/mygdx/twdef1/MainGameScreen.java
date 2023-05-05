package com.mygdx.twdef1;

import static com.mygdx.twdef1.GameDraw.*;
import static com.mygdx.twdef1.TDGame1.gr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MainGameScreen implements Screen, InputProcessor {
    public static TDGame1 game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public static SpriteBatch batch;
    public static ShapeRenderer sr;

    private Stage stage;
    private Table table;

    public static BitmapFont font;
    public static BitmapFont font2;
    public static BitmapFont font3;
    public static GlyphLayout layout1;

    public static float cameraWidth, cameraHeight;
    public static int unit;
    public static int start_x, start_y;

    // Flying stars
    public static int nFlyingStars = 50;
    public static float stars [][];

    public static GameMap gm;

    int max_towers = 5;
    static boolean bTowersCompleted = false;
    static LinkedList<Tower> towers = new LinkedList<Tower>();

    static boolean bStartGame = false;
    static boolean bFinishGame = false; // Game Over
    static boolean bWinGame = false;

    static float respawn_speed = 1.0f;
    static float resp_speed_state = 0;
    int monsters_number = 10; // Quantity of monsters
    static int monster_counter = 0; // Counter of monster
    static LinkedList<Monster> monsters = new LinkedList<Monster>();
    static LinkedList<Monster> dead_monsters = new LinkedList<Monster>();

    public static int sel_x = 99;
    public static int sel_y = 99;
    public static int sel_tower = 2;

    public MainGameScreen (final TDGame1 game) {
        this.game = game;

        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        sr = new ShapeRenderer();

        font = new BitmapFont();
        font2 = new BitmapFont();
        font3 = new BitmapFont();

        // Get resources
        gr.getFonts();
        gr.getPng();
        gr.loadAnim();

        layout1 = new GlyphLayout();
        layout1.setText(font, "999/999");

        cameraWidth = Gdx.graphics.getWidth(); // 16
        cameraHeight = Gdx.graphics.getHeight(); // 9
        unit = 80;
        start_x = 100;
        start_y = 580;

        camera.setToOrtho(false, cameraWidth, cameraHeight);
        viewport = new FitViewport(cameraWidth, cameraHeight, camera);
        stage = new Stage(viewport);
        //Gdx.input.setInputProcessor(this);
        Gdx.input.setInputProcessor(stage);

        // User panel table
        table = new Table();
        //table.setDebug(true); // This is optional, but enables debug lines for tables.
        table.setPosition(Gdx.graphics.getWidth()-unit*2,Gdx.graphics.getHeight()-unit*2);
        //table.setFillParent(true);
        GameGUI gameGUI = new GameGUI();
        gameGUI.createGUI(table);
        stage.addActor(table);
        // Stage input
        stage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (sel_x == 99 &&  sel_y == 99)
                    return false;
                for (int i=0; i<towers.size(); i++) {
                    if (towers.get(i).x == sel_x && towers.get(i).y == sel_y)
                        return false;
                }
                Tower tw = new Tower ();
                tw.x = sel_x;
                tw.y = sel_y;
                tw.or_x = tw.x*unit+start_x+unit/2;
                tw.or_y = start_y-tw.y*unit+unit/2;
                tw.type = sel_tower;
                towers.add(tw);
                if (towers.size()>=max_towers) {
                    bTowersCompleted = true;
                    sel_x = 99;
                    sel_y = 99;
                }
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //System.out.println("touched");
            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                super.mouseMoved(event, x, y);
                int i, j;
                if (!bTowersCompleted) {
                    for (i = 0; i < gm.sizey; i++) {
                        for (j = 0; j < gm.sizex; j++) {
                            if (gm.map[i][j] == 1) {
                                if (x > j * unit + start_x && x < (j + 1) * unit + start_x && y < start_y+unit - i * unit && y > start_y+unit - ((i + 1) * unit)) {
                                    //System.out.println("(" + j + "," + i + ")");
                                    sel_x = j;
                                    sel_y = i;
                                }
                            }
                        }
                    }
                    if (x<start_x) {
                        sel_x = 99;
                        sel_y = 99;
                    }
                    if (x>start_x+gm.sizex*unit) {
                        sel_x = 99;
                        sel_y = 99;
                    }
                    if (y>start_y+unit) {
                        sel_x = 99;
                        sel_y = 99;
                    }
                    if (y<start_y-unit*(gm.sizey-1)) {
                        sel_x = 99;
                        sel_y = 99;
                    }
                }
                return false;
            }
        });

        // Init flying stars
        stars = new float[nFlyingStars][5];
        for (int i=0; i<nFlyingStars; i++) {
            stars[i][0] = MathUtils.random(10, (int) (cameraWidth-10)); // x coord
            stars[i][1] = MathUtils.random(10, (int) (cameraHeight-10)); // y coord
            stars[i][2] = MathUtils.random(1, 3); // color
            stars[i][3] = MathUtils.random(3, 4); // speed
            stars[i][4] = MathUtils.random(1, 2); // side
        }

        // Create map
        gm = new GameMap();
        gm.createMap();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        drawFlyingStars ();
        batch.begin();
        if (bFinishGame) {
            drawGameOver();
        }
        if (bWinGame) {
            drawWinGame();
        }
        drawMap();
        drawTowers();
        drawDeadMonsters();
        drawMonsters();
        drawSelTower();
        drawFireBalls();
        drawFPS();
        //drawDebugInfo ();
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        // Game logic
        logic ();
    }

    // Game logic
    private void logic () {
        // Move flying stars
        for (int i = 0; i < nFlyingStars; i++) {
            stars[i][0] += 1 / stars[i][3];
            stars[i][1] -= 1 / stars[i][3];
            if (stars[i][0] > cameraWidth || stars[i][1] <= 0) {
                if (stars[i][4] == 1) {
                    stars[i][0] = MathUtils.random(10, (int) (cameraWidth - 10)); // x coord
                    stars[i][1] = (int) cameraHeight; // y coord
                } else {
                    stars[i][0] = 0; // x coord
                    stars[i][1] = MathUtils.random(10, (int) (cameraHeight - 10)); // y coord
                }
            }
        }
        // Start Game
        if (bStartGame) {
            // You WIN!
            if (monsters.size()==0 && monster_counter==monsters_number) {
                bWinGame = true;
                bStartGame = false;
            }
            // Respawn monsters
            if (monster_counter<monsters_number)
                respMonster ();
            // Move monsters
            moveMonsters ();
            // Check towers
            checkTowers ();
        }
        // Sort monsters
        Collections.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster m1, Monster m2) {
                return m1.compareTo(m2);
            }
        });
    }

    // Respawn monsters
    private void respMonster () {
        resp_speed_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed respawn time
        if (respawn_speed<resp_speed_state) {
            resp_speed_state = 0;
            Monster mo = new Monster ();
            monster_counter++;
            monsters.add(mo);
        }
    }

    // Move monsters
    private void moveMonsters () {
        int i;
        for (i=0; i<monsters.size(); i++) {
            if (monsters.get(i).or_x == monsters.get(i).tor_x && monsters.get(i).or_y == monsters.get(i).tor_y) {
                monsters.get(i).selectTarget ();
            }
            if (monsters.get(i).or_x != monsters.get(i).tor_x || monsters.get(i).or_y != monsters.get(i).tor_y) {
                monsters.get(i).move ();
            }
        }
    }

    // Check towers
    private void checkTowers () {
        int i, j, k;
        for (i=0; i<towers.size(); i++) {
            towers.get(i).fire_speed_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed fire time
            if (towers.get(i).speed<towers.get(i).fire_speed_state) {
                towers.get(i).fire_speed_state = 0;
                for (j=0; j<monsters.size(); j++) {
                    if (towers.get(i).range2 > (monsters.get(j).or_x - towers.get(i).or_x) * (monsters.get(j).or_x - towers.get(i).or_x)
                            + (monsters.get(j).or_y - towers.get(i).or_y) * (monsters.get(j).or_y - towers.get(i).or_y)) {
                        towers.get(i).fire (monsters.get(j));
                        break;
                    }
                }
            }
            for (k=0; k<towers.get(i).fbs.size(); k++) {
                towers.get(i).fbs.get(k).move();
            }
            for (k=0; k<towers.get(i).fbs.size(); k++) {
                if (towers.get(i).fbs.get(k).or_x == towers.get(i).fbs.get(k).tor_x && towers.get(i).fbs.get(k).or_y == towers.get(i).fbs.get(k).tor_y) {
                    towers.get(i).fbs.remove(k);
                }
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        //calcScreenParams();
        //table.setPosition(Gdx.graphics.getWidth()-unit*2,Gdx.graphics.getHeight()-unit*2);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gr.manager.dispose(); // Clear resources
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        gm.map[0][0]=4;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
