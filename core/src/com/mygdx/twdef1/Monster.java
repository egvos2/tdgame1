package com.mygdx.twdef1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

import static com.mygdx.twdef1.MainGameScreen.*;

import java.util.Stack;

public class Monster implements Comparable<Monster> {
    int dir;
    int type;
    int max_life;
    int life;
    float speed;

    int x, y; // monster coords
    float cx, cy; // monster coords in cell
    int tx, ty; //  target coords
    float tcx, tcy; // target coords in cell
    int old_x, old_y; //  old coords
    float or_x, or_y; // original coords
    float tor_x, tor_y; // target original coords

    float frame_anim_state;

    boolean dead;

    // Map generation cell
    static class cell {
        int x;
        int y;
    }
    Stack<cell> moveStack = new Stack<cell>(); // Cell stack for move chois

    Monster () {
        dir = 1;
        dead = false;
        int r = MathUtils.random(1, 100);
        if (r<60) type = 1;
        if (r>=60 && r<90) type = 2;
        if (r>=90) type = 3;
        switch (type) {
            case 1:
                life = 50;
                max_life = life;
                speed = 40;
                break;
            case 2:
                life = 100;
                max_life = life;
                speed = 30;
                break;
            case 3:
                life = 150;
                max_life = life;
                speed = 20;
                break;
        }
        x = gm.sx;
        y = gm.sy;
        cx = 5;
        cy = MathUtils.random(5, unit-10);
        or_x = x*unit+start_x+cx;
        or_y = start_y-y*unit+cy;
        tor_x = or_x;
        tor_y = or_y;
        tx = x;
        ty = y;
        tcx = cx;
        tcy = cy;
        old_x = old_y = 0;
        frame_anim_state = 0;
    }

    // Select new target for monster moving
    public void selectTarget () {
        // If it's Finish cell
        if (gm.map[y][x] == 4) {
            bStartGame = false;
            bFinishGame = true;
            return;
        }
        // Check empty neighbour cells
        if (x<gm.sizex-1)
            checkEmptyNeigCell(x + 1, y);
        if (x>0)
            checkEmptyNeigCell(x - 1, y);
        if (y>0)
            checkEmptyNeigCell(x, y - 1);
        if (y< gm.sizey-1)
            checkEmptyNeigCell(x, y + 1);
        // Check for priority finish cell
        if (gm.map[y][x+1] == 4) {
            moveStack.clear();
            cell c = new Monster.cell();
            c.x = x+1;
            c.y = y;
            moveStack.push(c);
        }
        // if monster deadlocked
        if (moveStack.size() == 0) {
            tx = old_x;
            ty = old_y;
            old_x = x;
            old_y = y;
            setMonsterDirection(tx, ty);
        }
        else {
            int s;
            if (moveStack.size() == 1)
                s = 0;
            else {
                s = MathUtils.random(0, moveStack.size() - 1); // Get random neighbour cell
            }
            // Set last monster coordinates
            old_x = x;
            old_y = y;
            // Set original monster coordinates
            or_x = tor_x;
            or_y = tor_y;
            // Set new monster target coordinates
            cell c = moveStack.get(s);
            setNewTargetCoords(c.x, c.y);
            setMonsterDirection(tx, ty);
            // Clear stack
            moveStack.clear();
        }
    }

    // Set new monster target coordinates
    private void setNewTargetCoords (int xn, int yn) {
        tx = xn;
        ty = yn;
        tcx = MathUtils.random(5, unit-25);
        tcy = MathUtils.random(5, unit-15);
        tor_x = tx*unit+start_x+tcx;
        tor_y = start_y-ty*unit+tcy;
    }

    // Check empty neighbour cells
    private void checkEmptyNeigCell (int xn, int yn) {
        if (gm.map[yn][xn] == 2) {
            if ((xn==old_x)&&(yn==old_y))
                return;
            else {
                cell c = new Monster.cell();
                c.x = xn;
                c.y = yn;
                moveStack.push(c);
            }
        }
    }

    // Set monster direction
    private void setMonsterDirection (int xn, int yn) {
        if (old_y < yn) {
            dir = 1; // Down
        }
        if (old_y > yn) {
            dir = 2; // Up
        }
        if (old_x > xn) {
            dir = 3; // Left
        }
        if (old_x < xn) {
            dir = 4; // Right
        }
    }

    // Move monster
    public void move () {
        float angle; // We use a triangle to calculate the new trajectory
        angle = (float) Math.atan2(tor_y - or_y, tor_x - or_x);
        float dx = (float) Math.cos(angle) * speed * Gdx.graphics.getDeltaTime();
        float dy = (float) Math.sin(angle) * speed * Gdx.graphics.getDeltaTime();
        or_x += dx;
        or_y += dy;
        if (Math.abs(or_x-tor_x)<1 && Math.abs(or_y-tor_y)<1) {
            or_x = tor_x;
            or_y = tor_y;
            x = tx;
            y = ty;
        }
    }

    @Override
    public int compareTo(Monster monster) {
        if (this.or_y > monster.or_y) {
            return -1;
        } else if (this.or_y == monster.or_y) {
            return 0;
        } else {
            return 1;
        }
    }
}
