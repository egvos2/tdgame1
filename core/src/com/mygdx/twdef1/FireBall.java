package com.mygdx.twdef1;

import com.badlogic.gdx.Gdx;

public class FireBall {
    float or_x, or_y;
    float tor_x, tor_y;
    float speed;
    float frame_anim_state;

    FireBall () {
        speed = 500f;
        frame_anim_state = 0;
    }

    // Move FB
    public void move () {
        float angle; // We use a triangle to calculate the new trajectory
        angle = (float) Math.atan2(tor_y - or_y, tor_x - or_x);
        float dx = (float) Math.cos(angle) * speed * Gdx.graphics.getDeltaTime();
        float dy = (float) Math.sin(angle) * speed * Gdx.graphics.getDeltaTime();
        or_x += dx;
        or_y += dy;
        if (Math.abs(or_x-tor_x)<5 && Math.abs(or_y-tor_y)<5) {
            or_x = tor_x;
            or_y = tor_y;
        }
    }
}
