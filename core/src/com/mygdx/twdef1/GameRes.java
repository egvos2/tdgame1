package com.mygdx.twdef1;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.twdef1.MainGameScreen.*;

public class GameRes {
    AssetManager manager;
    FileHandleResolver resolver;

    GameRes () {
        manager = new AssetManager();
        resolver = new InternalFileHandleResolver();
    }

    // Background
    public static Texture img_bg1; //
    //public static TextureRegion reg_bg1; //
    public static Texture img_bg2; //
    //public static TextureRegion reg_bg2; //
    public static Texture img_bg3; //
    //public static TextureRegion reg_bg3; //

    // GUI
    public static Texture img_but_l; //
    public static Texture img_but_r;
    public static Texture img_but1;
    public static Texture img_but2;

    // Towers
    public static Texture img_tow1; //
    public static Texture img_tow2;
    public static Texture img_tow3;

    // Monsters
    public static Texture img_mon1d;
    public static Texture img_mon11;
    public static Texture img_mon111;
    public static Texture img_mon112;
    public static Texture img_mon12;
    public static Texture img_mon121;
    public static Texture img_mon122;
    public static Texture img_mon13;
    public static Texture img_mon131;
    public static Texture img_mon132;
    public static Texture img_mon14;
    public static Texture img_mon141;
    public static Texture img_mon142;
    public static Texture img_mon2d;
    public static Texture img_mon21;
    public static Texture img_mon211;
    public static Texture img_mon212;
    public static Texture img_mon22;
    public static Texture img_mon221;
    public static Texture img_mon222;
    public static Texture img_mon23;
    public static Texture img_mon231;
    public static Texture img_mon232;
    public static Texture img_mon24;
    public static Texture img_mon241;
    public static Texture img_mon242;
    public static Texture img_mon3d;
    public static Texture img_mon31;
    public static Texture img_mon311;
    public static Texture img_mon312;
    public static Texture img_mon32;
    public static Texture img_mon321;
    public static Texture img_mon322;
    public static Texture img_mon33;
    public static Texture img_mon331;
    public static Texture img_mon332;
    public static Texture img_mon34;
    public static Texture img_mon341;
    public static Texture img_mon342;

    // Tower Fireball
    public static Texture img_fb1;
    public static Texture img_fb2;
    public static Texture img_fb3;
    public static Texture img_fb4;
    public static Texture img_fb5;

    // Life frame
    public static Texture img_life_frame2;
    public static Texture img_life_frame2_emp;

    // Load png asserts
    public void loadPng () {
        // Background
        manager.load("png/bg/back1_80.png", Texture.class);
        manager.load("png/bg/back2_80.png", Texture.class);
        manager.load("png/bg/back3_80.png", Texture.class);
        // GUI
        manager.load("png/gui/but1.png", Texture.class);
        manager.load("png/gui/but2.png", Texture.class);
        manager.load("png/gui/but_l.png", Texture.class);
        manager.load("png/gui/but_r.png", Texture.class);
        // Towers
        manager.load("png/tows/tw1.png", Texture.class);
        manager.load("png/tows/tw2.png", Texture.class);
        manager.load("png/tows/tw3.png", Texture.class);
        // Monsters
        manager.load("png/mons/mons1_dead.png", Texture.class);
        manager.load("png/mons/mons11.png", Texture.class);
        manager.load("png/mons/mons111.png", Texture.class);
        manager.load("png/mons/mons112.png", Texture.class);
        manager.load("png/mons/mons12.png", Texture.class);
        manager.load("png/mons/mons121.png", Texture.class);
        manager.load("png/mons/mons122.png", Texture.class);
        manager.load("png/mons/mons13.png", Texture.class);
        manager.load("png/mons/mons131.png", Texture.class);
        manager.load("png/mons/mons132.png", Texture.class);
        manager.load("png/mons/mons14.png", Texture.class);
        manager.load("png/mons/mons141.png", Texture.class);
        manager.load("png/mons/mons142.png", Texture.class);
        manager.load("png/mons/mons51_dead.png", Texture.class);
        manager.load("png/mons/mons51.png", Texture.class);
        manager.load("png/mons/mons511.png", Texture.class);
        manager.load("png/mons/mons512.png", Texture.class);
        manager.load("png/mons/mons52.png", Texture.class);
        manager.load("png/mons/mons521.png", Texture.class);
        manager.load("png/mons/mons522.png", Texture.class);
        manager.load("png/mons/mons53.png", Texture.class);
        manager.load("png/mons/mons531.png", Texture.class);
        manager.load("png/mons/mons532.png", Texture.class);
        manager.load("png/mons/mons54.png", Texture.class);
        manager.load("png/mons/mons541.png", Texture.class);
        manager.load("png/mons/mons542.png", Texture.class);
        manager.load("png/mons/mons31_dead.png", Texture.class);
        manager.load("png/mons/mons31.png", Texture.class);
        manager.load("png/mons/mons311.png", Texture.class);
        manager.load("png/mons/mons312.png", Texture.class);
        manager.load("png/mons/mons32.png", Texture.class);
        manager.load("png/mons/mons321.png", Texture.class);
        manager.load("png/mons/mons322.png", Texture.class);
        manager.load("png/mons/mons33.png", Texture.class);
        manager.load("png/mons/mons331.png", Texture.class);
        manager.load("png/mons/mons332.png", Texture.class);
        manager.load("png/mons/mons34.png", Texture.class);
        manager.load("png/mons/mons341.png", Texture.class);
        manager.load("png/mons/mons342.png", Texture.class);
        // Tower Fireball
        manager.load("png/fb/1.png", Texture.class);
        manager.load("png/fb/2.png", Texture.class);
        manager.load("png/fb/3.png", Texture.class);
        manager.load("png/fb/4.png", Texture.class);
        manager.load("png/fb/5.png", Texture.class);
        // Life frame
        manager.load("png/life_frame4_6.png", Texture.class);
        manager.load("png/life_frame4_6_emp.png", Texture.class);
    }

    // Get png asserts
    public void getPng () {
        // Background
        img_bg1 = manager.get("png/bg/back1_80.png", Texture.class);
        img_bg2 = manager.get("png/bg/back2_80.png", Texture.class);
        img_bg3 = manager.get("png/bg/back3_80.png", Texture.class);
        // GUI
        img_but_l = manager.get("png/gui/but_l.png", Texture.class);
        img_but_r = manager.get("png/gui/but_r.png", Texture.class);
        img_but1 = manager.get("png/gui/but1.png", Texture.class);
        img_but2 = manager.get("png/gui/but2.png", Texture.class);
        // Towers
        img_tow1 = manager.get("png/tows/tw1.png", Texture.class);
        img_tow2 = manager.get("png/tows/tw2.png", Texture.class);
        img_tow3 = manager.get("png/tows/tw3.png", Texture.class);
        // Monsters
        img_mon1d = manager.get("png/mons/mons1_dead.png", Texture.class);
        img_mon11 = manager.get("png/mons/mons11.png", Texture.class);
        img_mon111 = manager.get("png/mons/mons111.png", Texture.class);
        img_mon112 = manager.get("png/mons/mons112.png", Texture.class);
        img_mon12 = manager.get("png/mons/mons12.png", Texture.class);
        img_mon121 = manager.get("png/mons/mons121.png", Texture.class);
        img_mon122 = manager.get("png/mons/mons122.png", Texture.class);
        img_mon13 = manager.get("png/mons/mons13.png", Texture.class);
        img_mon131 = manager.get("png/mons/mons131.png", Texture.class);
        img_mon132 = manager.get("png/mons/mons132.png", Texture.class);
        img_mon14 = manager.get("png/mons/mons14.png", Texture.class);
        img_mon141 = manager.get("png/mons/mons141.png", Texture.class);
        img_mon142 = manager.get("png/mons/mons142.png", Texture.class);
        img_mon2d = manager.get("png/mons/mons51_dead.png", Texture.class);
        img_mon21 = manager.get("png/mons/mons51.png", Texture.class);
        img_mon211 = manager.get("png/mons/mons511.png", Texture.class);
        img_mon212 = manager.get("png/mons/mons512.png", Texture.class);
        img_mon22 = manager.get("png/mons/mons52.png", Texture.class);
        img_mon221 = manager.get("png/mons/mons521.png", Texture.class);
        img_mon222 = manager.get("png/mons/mons522.png", Texture.class);
        img_mon23 = manager.get("png/mons/mons53.png", Texture.class);
        img_mon231 = manager.get("png/mons/mons531.png", Texture.class);
        img_mon232 = manager.get("png/mons/mons532.png", Texture.class);
        img_mon24 = manager.get("png/mons/mons54.png", Texture.class);
        img_mon241 = manager.get("png/mons/mons541.png", Texture.class);
        img_mon242 = manager.get("png/mons/mons542.png", Texture.class);
        img_mon3d = manager.get("png/mons/mons31_dead.png", Texture.class);
        img_mon31 = manager.get("png/mons/mons31.png", Texture.class);
        img_mon311 = manager.get("png/mons/mons311.png", Texture.class);
        img_mon312 = manager.get("png/mons/mons312.png", Texture.class);
        img_mon32 = manager.get("png/mons/mons32.png", Texture.class);
        img_mon321 = manager.get("png/mons/mons321.png", Texture.class);
        img_mon322 = manager.get("png/mons/mons322.png", Texture.class);
        img_mon33 = manager.get("png/mons/mons33.png", Texture.class);
        img_mon331 = manager.get("png/mons/mons331.png", Texture.class);
        img_mon332 = manager.get("png/mons/mons332.png", Texture.class);
        img_mon34 = manager.get("png/mons/mons34.png", Texture.class);
        img_mon341 = manager.get("png/mons/mons341.png", Texture.class);
        img_mon342 = manager.get("png/mons/mons342.png", Texture.class);
        // Tower Fireball
        img_fb1 = manager.get("png/fb/1.png", Texture.class);
        img_fb2 = manager.get("png/fb/2.png", Texture.class);
        img_fb3 = manager.get("png/fb/3.png", Texture.class);
        img_fb4 = manager.get("png/fb/4.png", Texture.class);
        img_fb5 = manager.get("png/fb/5.png", Texture.class);
        // Life frame
        img_life_frame2 = manager.get("png/life_frame4_6.png", Texture.class);
        img_life_frame2_emp = manager.get("png/life_frame4_6_emp.png", Texture.class);
    }

    // Monster 1
    public static Animation<TextureRegion> anim_mon11; // Move down animation
    public static Animation<TextureRegion> anim_mon12; // Move up animation
    public static Animation<TextureRegion> anim_mon13; // Move left animation
    public static Animation<TextureRegion> anim_mon14; // Move right animation
    // Monster 2
    public static Animation<TextureRegion> anim_mon21;
    public static Animation<TextureRegion> anim_mon22;
    public static Animation<TextureRegion> anim_mon23;
    public static Animation<TextureRegion> anim_mon24;
    // Monster 3
    public static Animation<TextureRegion> anim_mon31;
    public static Animation<TextureRegion> anim_mon32;
    public static Animation<TextureRegion> anim_mon33;
    public static Animation<TextureRegion> anim_mon34;
    // Fireball
    public static Animation<TextureRegion> anim_fb;

    // Load animation
    public void loadAnim () {
        // Monster 1
        // Move down animation
        TextureRegion[] tx_mon11 = new TextureRegion[4];
        tx_mon11[0] = new TextureRegion(img_mon11);
        tx_mon11[1] = new TextureRegion(img_mon111);
        tx_mon11[2] = new TextureRegion(img_mon11);
        tx_mon11[3] = new TextureRegion(img_mon112);
        anim_mon11 = new Animation<TextureRegion>(0.2f, tx_mon11);
        // Move up animation
        TextureRegion[] tx_mon12 = new TextureRegion[4];
        tx_mon12[0] = new TextureRegion(img_mon12);
        tx_mon12[1] = new TextureRegion(img_mon121);
        tx_mon12[2] = new TextureRegion(img_mon12);
        tx_mon12[3] = new TextureRegion(img_mon122);
        anim_mon12 = new Animation<TextureRegion>(0.2f, tx_mon12);
        // Move left animation
        TextureRegion[] tx_mon13 = new TextureRegion[4];
        tx_mon13[0] = new TextureRegion(img_mon13);
        tx_mon13[1] = new TextureRegion(img_mon131);
        tx_mon13[2] = new TextureRegion(img_mon13);
        tx_mon13[3] = new TextureRegion(img_mon132);
        anim_mon13 = new Animation<TextureRegion>(0.2f, tx_mon13);
        // Move right animation
        TextureRegion[] tx_mon14 = new TextureRegion[4];
        tx_mon14[0] = new TextureRegion(img_mon14);
        tx_mon14[1] = new TextureRegion(img_mon141);
        tx_mon14[2] = new TextureRegion(img_mon14);
        tx_mon14[3] = new TextureRegion(img_mon142);
        anim_mon14 = new Animation<TextureRegion>(0.2f, tx_mon14);
        // Monster 2
        // Move down animation
        TextureRegion[] tx_mon21 = new TextureRegion[4];
        tx_mon21[0] = new TextureRegion(img_mon21);
        tx_mon21[1] = new TextureRegion(img_mon211);
        tx_mon21[2] = new TextureRegion(img_mon21);
        tx_mon21[3] = new TextureRegion(img_mon212);
        anim_mon21 = new Animation<TextureRegion>(0.2f, tx_mon21);
        // Move up animation
        TextureRegion[] tx_mon22 = new TextureRegion[4];
        tx_mon22[0] = new TextureRegion(img_mon22);
        tx_mon22[1] = new TextureRegion(img_mon221);
        tx_mon22[2] = new TextureRegion(img_mon22);
        tx_mon22[3] = new TextureRegion(img_mon222);
        anim_mon22 = new Animation<TextureRegion>(0.2f, tx_mon22);
        // Move left animation
        TextureRegion[] tx_mon23 = new TextureRegion[4];
        tx_mon23[0] = new TextureRegion(img_mon23);
        tx_mon23[1] = new TextureRegion(img_mon231);
        tx_mon23[2] = new TextureRegion(img_mon23);
        tx_mon23[3] = new TextureRegion(img_mon232);
        anim_mon23 = new Animation<TextureRegion>(0.2f, tx_mon23);
        // Move right animation
        TextureRegion[] tx_mon24 = new TextureRegion[4];
        tx_mon24[0] = new TextureRegion(img_mon24);
        tx_mon24[1] = new TextureRegion(img_mon241);
        tx_mon24[2] = new TextureRegion(img_mon24);
        tx_mon24[3] = new TextureRegion(img_mon242);
        anim_mon24 = new Animation<TextureRegion>(0.2f, tx_mon24);
        // Monster 3
        // Move down animation
        TextureRegion[] tx_mon31 = new TextureRegion[4];
        tx_mon31[0] = new TextureRegion(img_mon31);
        tx_mon31[1] = new TextureRegion(img_mon311);
        tx_mon31[2] = new TextureRegion(img_mon31);
        tx_mon31[3] = new TextureRegion(img_mon312);
        anim_mon31 = new Animation<TextureRegion>(0.2f, tx_mon31);
        // Move up animation
        TextureRegion[] tx_mon32 = new TextureRegion[4];
        tx_mon32[0] = new TextureRegion(img_mon32);
        tx_mon32[1] = new TextureRegion(img_mon321);
        tx_mon32[2] = new TextureRegion(img_mon32);
        tx_mon32[3] = new TextureRegion(img_mon322);
        anim_mon32 = new Animation<TextureRegion>(0.2f, tx_mon32);
        // Move left animation
        TextureRegion[] tx_mon33 = new TextureRegion[4];
        tx_mon33[0] = new TextureRegion(img_mon33);
        tx_mon33[1] = new TextureRegion(img_mon331);
        tx_mon33[2] = new TextureRegion(img_mon33);
        tx_mon33[3] = new TextureRegion(img_mon332);
        anim_mon33 = new Animation<TextureRegion>(0.2f, tx_mon33);
        // Move right animation
        TextureRegion[] tx_mon34 = new TextureRegion[4];
        tx_mon34[0] = new TextureRegion(img_mon34);
        tx_mon34[1] = new TextureRegion(img_mon341);
        tx_mon34[2] = new TextureRegion(img_mon34);
        tx_mon34[3] = new TextureRegion(img_mon342);
        anim_mon34 = new Animation<TextureRegion>(0.2f, tx_mon34);
        // Fireball
        TextureRegion[] tx_fb = new TextureRegion[5];
        tx_fb[0] = new TextureRegion(img_fb1);
        tx_fb[1] = new TextureRegion(img_fb2);
        tx_fb[2] = new TextureRegion(img_fb3);
        tx_fb[3] = new TextureRegion(img_fb4);
        tx_fb[4] = new TextureRegion(img_fb5);
        anim_fb = new Animation<TextureRegion>(0.05f, tx_fb);
    }

    // Load fonts
    public void loadFonts () {
        manager.load("fonts/olney18.fnt", BitmapFont.class);
        manager.load("fonts/olney20.fnt", BitmapFont.class);
        manager.load("fonts/olney24.fnt", BitmapFont.class);
    }

    // Get fonts
    public void getFonts () {
        font = manager.get("fonts/olney18.fnt", BitmapFont.class);
        font2 = manager.get("fonts/olney20.fnt", BitmapFont.class);
        font3 = manager.get("fonts/olney24.fnt", BitmapFont.class);
    }
}
