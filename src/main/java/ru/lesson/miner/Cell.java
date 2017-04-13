package ru.lesson.miner;

/**
 * Created by Сергей on 13.04.2017.
 */
public interface Cell<T> {

    boolean isBomb();

    void setBomb();

    boolean isSuggestBomb();

    boolean isSuggestEmpty();

    void suggestEmpty();

    void suggestBomb();

    void draw (T paint, boolean real);

}
