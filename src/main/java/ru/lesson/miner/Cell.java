package ru.lesson.miner;

/**
 * Created by Сергей on 13.04.2017.
 */
public interface Cell<T> {

    boolean isBomb();

    void setBomb();

    /**считает бомбы вокруг
     *
     * @param x координаты ячейки
     * @param y коорд
     * @return
     */
    int counter(int x, int y);

    /**проверяет не открыта ли ячейка
     *
     * @return тру если открыта
     */
    boolean isOpened();

    void setOpened();

    void setDrawBomb(boolean b);

    void draw (T paint);

}
