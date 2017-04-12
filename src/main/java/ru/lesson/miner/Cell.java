package ru.lesson.miner.logic;

/**
 * Created by Сергей on 13.04.2017.
 */
public interface Cell<T> {

    void isBomb();

    boolean isSuggestBomb();

    boolean isSuggestEmpty();

    void suggestEmpty();

    void suggestBomb();

    void draw (T paint, boolean real);

}
