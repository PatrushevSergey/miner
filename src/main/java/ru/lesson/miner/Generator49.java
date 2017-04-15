package ru.lesson.miner;

import ru.lesson.miner.GUI.GUICell;

/**
 * Created by Сергей on 15.04.2017.
 */
public class Generator49 implements GeneratorBoard {
    public Cell[][] generate() {
        Cell[][] cells = new Cell[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                cells[i][j] = new GUICell(i, j);
            }

        }
        for (int i = 0; i < 10; i++) {
            cells[(int)(Math.random()*7)][(int)(Math.random()*7)].setBomb();
        }
        return cells;
    }
}