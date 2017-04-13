package ru.lesson.miner.GUI;

import ru.lesson.miner.Cell;

import java.awt.*;

/**
 * Created by Сергей on 13.04.2017.
 */
public class GUICell implements Cell<Graphics> {
    public int x;
    public int y;
    private boolean bomb = false;
    private boolean suggestBomb = false;
    private boolean suggestEmpty = false;


    public GUICell(int x,int y) {
        this.x = x * 50 + 5;
        this.y = y * 50 + 5;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb() { bomb = true; }

    public boolean isSuggestBomb() {
        return false;
    }

    public boolean isSuggestEmpty() {
        return false;
    }

    public void suggestEmpty() {
        this.suggestEmpty = true;
    }

    public void suggestBomb() {
        this.bomb = true;
    }

    public void draw(Graphics paint, boolean real) {

        if(!real) {
            paint.drawRect(x,y, 45, 45);
        } else {
            if (isBomb()) {
                paint.drawRect(x, y, 20, 20);
            } else {
                paint.drawOval(x, y, 40, 40);
            }
        }




        paint.setColor(Color.BLUE);

    }
}
