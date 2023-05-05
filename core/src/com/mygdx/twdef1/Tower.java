package com.mygdx.twdef1;

import static com.mygdx.twdef1.MainGameScreen.*;

import java.util.LinkedList;

public class Tower {
    int type;
    int x, y;
    float or_x, or_y;
    int strength;
    float speed; // Hit speed
    float range; // Range
    float range2; // Range 2

    float fire_speed_state;

    LinkedList<FireBall> fbs = new LinkedList<FireBall>(); // Fireballs

    Tower () {
        strength = 10;
        speed = 1f;
        range = 100;
        range2 = range*range;
        fire_speed_state = 0;
    }

    // Send fireball to monster
    public void fire (Monster mo) {
        FireBall fb = new FireBall();
        fb.or_x = or_x;
        fb.or_y = or_y;
        fb.tor_x = mo.or_x;
        fb.tor_y = mo.or_y;
        fbs.add(fb);
        // Damage monster
        mo.life -= strength;
        // If monster dead
        if (mo.life <= 0) {
            dead_monsters.add(mo);
            monsters.remove(mo);
        }
    }
}
