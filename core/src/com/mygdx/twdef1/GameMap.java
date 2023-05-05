package com.mygdx.twdef1;

import com.badlogic.gdx.math.MathUtils;

import java.util.Random;
import java.util.Stack;

public class GameMap {
    int sizex, sizey; // Map size
    int sx, sy; // Start coords
    int fx, fy; // Finish coords

    int map[][]; // 1 - wall, 2 - road, 3 - start, 4 - finish,
                    // 5 - tower1, 6 - tower2, 7 - tower3

    class cell {
        int x;
        int y;
    }

    Stack<cell> mapStack; // Map generation stack

    GameMap () {
        sizex = 11;
        sizey = 7;
        sx = 0; sy = 1;
        fx = sizex-1; fy = sizey-2;
    }

    // Generate map
    public void createMap () {
        int i, j;
        map = new int [sizey][sizex];
        // Делаем клетку из пустых ячеек и стен
        for(i = 0; i < sizey; i++){
            for(j = 0; j < sizex; j++){
                if((i % 2 != 0  && j % 2 != 0) && //если ячейка нечетная по x и y,
                        (i < sizey-1 && j < sizex-1))   //и при этом находится в пределах стен лабиринта
                    map[i][j] = 0;       //то это КЛЕТКА, не посещенная
                else map[i][j] = 1;           //в остальных случаях это СТЕНА.
            }
        }
        // Create stack
        mapStack = new Stack();
        // Generate map
        cell c = new cell ();
        // Start cell
        c.x = 1; c.y = 1;
        map[c.y][c.x] = 2;
        nextCell2(c);
        // Set start cell
        map[sy][sx] = 3;
        // Set finish cell
        map[fy][fx] = 4;
    }

    private void nextCell (cell c) {

    }

    private void nextCell2 (cell c) {
        do {
            cell n = new cell (); // Соседняя ячейка
            cell new_c = new cell ();
            n = checkNeighbours(c);
            if (n!=null) {
                // Помещаем текущую ячейку в стек
                mapStack.push(c);
                // Убираем стенку между текущей ячейкой и соседней
                if (n.x<c.x) map[c.y][c.x-1] = 2;
                if (n.x>c.x) map[c.y][c.x+1] = 2;
                if (n.y<c.y) map[c.y-1][c.x] = 2;
                if (n.y>c.y) map[c.y+1][c.x] = 2;
                // Делаем соседнюю ячейку текущей
                new_c.x = n.x; new_c.y = n.y;
                map[new_c.y][new_c.x] = 2;
                c = new_c;
                //nextCell(new_c);
            }
            else {
                if (!mapStack.empty()) {
                    new_c = mapStack.pop();
                    map[new_c.y][new_c.x] = 2;
                    c = new_c;
                    //nextCell(new_c);
                }
            }
        } while (!mapStack.empty());
    }

    //  = Если у ячейки есть более 1го непосещенного соседа =
    private cell checkNeighbours (cell c) {
        cell n = new cell ();
        cell t;
        Stack<cell> neighboursStack =  new Stack(); // Стек соседей текущей ячейки
        int neigh_count = 0; // Количество непосещенных соседних ячеек
        // Обрабатываем крайние случаи: углы
        if ((c.x == 1)&&(c.y == 1)) {
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
        }
        if ((c.x == sizex-2)&&(c.y == sizey-2)) {
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
        }
        if ((c.x == 1)&&(c.y == sizey-2)) {
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
        }
        if ((c.x == sizex-2)&&(c.y == 1)) {
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
        }
        // Обрабатываем крайние случаи: края
        if ((c.x == 1)&&(c.y>1)&&(c.y<sizey-2)) {
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
        }
        if ((c.x == sizex-2)&&(c.y>1)&&(c.y<sizey-2))  {
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
        }
        if ((c.y == 1)&&(c.x>1)&&(c.x<sizex-2))  {
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
        }
        if ((c.y == sizey-2)&&(c.x>1)&&(c.x<sizex-2))  {
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
        }
        // Если ячейка не с краю
        if ((c.x>1)&&(c.x<sizex-2)&&(c.y>1)&&(c.y<sizey-2)) {
            if (map[c.y][c.x+2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x+2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y][c.x-2] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x-2; t.y = c.y;
                neighboursStack.push(t);
            }
            if (map[c.y+2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y+2;
                neighboursStack.push(t);
            }
            if (map[c.y-2][c.x] == 0) {
                neigh_count++;
                t = new cell();
                t.x = c.x; t.y = c.y-2;
                neighboursStack.push(t);
            }
        }
        // Если нет соседних ячеек
        if (neigh_count == 0)
            return null;
        else { // Иначе возвращаем соседнюю
            if (neigh_count>=2) {
                int k;
                k = MathUtils.random (1, neigh_count);
                //k = 1;
                //k = r.nextInt((neigh_count - 1) + 1) + 1; // Выбираем случайно одного из соседей
                for (int i=0; i<k; i++)
                    n = neighboursStack.pop();
            }
            else { // Если только один сосед
                n = neighboursStack.pop();
            }
            neighboursStack.clear();
            return n;
        }
    }
}
