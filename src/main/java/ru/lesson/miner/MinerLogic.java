package ru.lesson.miner;


/**
 * Created by Сергей on 13.04.2017.
 */
public interface MinerLogic {

    void loadBoard(Cell[][] cells);

    boolean shouldBang(int x, int y);

    boolean finish();

}
