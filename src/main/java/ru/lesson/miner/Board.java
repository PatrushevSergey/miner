package ru.lesson.miner.logic;



/**
 * Created by Сергей on 13.04.2017.
 */
public interface Board {
    void drawBoard(Cell[][] cell);

    void drawCell(int x, int y);

    void drawBang();

    void drawCongratulate();
}
