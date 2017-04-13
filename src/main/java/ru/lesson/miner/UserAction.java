package ru.lesson.miner;

/**
 * Created by Сергей on 13.04.2017.
 */
public interface UserAction {

    void initGame();

    void select(int x, int y, boolean bomb);
}
