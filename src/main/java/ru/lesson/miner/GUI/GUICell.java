package ru.lesson.miner.GUI;

import ru.lesson.miner.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергей on 13.04.2017.
 * описывает графическую ячейку
 */
public class GUICell implements Cell<Graphics> {
    public int x;
    public int y;
    private boolean bomb = false;
    private boolean opened = false;
    private final char[] chars = {' ','1','2','3','4','5', '6', '7', '8'};
    private Image image;
    private boolean drawBomb = false;

    public GUICell(int x,int y) {
        this.x = x * 50 + 5;
        this.y = y * 50 + 5;
    }

    /**
     * возвращает есть или нет бомба
     * @return
     */
    public boolean isBomb() {
        return bomb;
    }

    /**
     * устанавливает бомбу в клеточку
     */
    public void setBomb() { bomb = true; }

    /**
     * считает бомбы вокруг ячейки
     * @param x координаты ячейки
     * @param y коорд
     * @return
     */
    public int counter(int x, int y) {
        Cell[][] cells = Main.board.getCell();
        int counter = 0;
        for( int i = x/50 -1; i <= x/50+1; i++) {
            for (int j = y/50-1; j <= y/50+1 ; j++) {

                if(i >= 0 && j >= 0 && i < cells.length && j < cells[0].length && cells[i][j].isBomb()) counter++;
            }
        }
        return counter;
    }

    /**
     * проверяет, открыта ячейка или нет
     * @return
     */
    public boolean isOpened() {
        return opened;
    }

    /**
     * устанавливает ячейку открытой
      */
    public void setOpened() {
        opened = true;
    }

    /**
     * рисует ячейку и изменения в ней в зависимости от ее состояния
     * @param paint
     */
    public void draw(Graphics paint) {
        image = new ImageIcon("C:\\images\\middle.gif").getImage();
        Image boom = new ImageIcon("C:\\images\\bomb.gif").getImage();
        if(drawBomb) paint.drawImage(boom, x, y, null);
        if(!isOpened()) {
            paint.drawRect(x, y, 45, 45);
        }
        else {
            if (isBomb()) {
                //paint.drawOval(x+10, y+10, 20, 20);
                //paint.drawOval(x+5 , y+5, 30, 30);
                paint.drawImage(image, x, y, null);
            } else {
                paint.drawChars(chars, counter(x,y), 1, x+20, y+20);
            }
        }

        paint.setColor(Color.BLUE);

    }

    /**
     * обозначает, отмечена ли клетка как бомба:
     * тру - отмечена, фалс - нет.
     * @return
     */
    public void setDrawBomb(boolean drawBomb) {
        this.drawBomb = drawBomb;
    }




}
