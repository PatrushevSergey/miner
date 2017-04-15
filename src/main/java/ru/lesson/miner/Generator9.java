package ru.lesson.miner;

import ru.lesson.miner.GUI.GUICell;

/**
 * Created by Сергей on 14.04.2017.
 */
public class Generator9 implements GeneratorBoard {
    public Cell[][] generate() {
        Cell[][] cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new GUICell(i, j);
            }

        }
        for (int i = 0; i < 1; i++) {
            cells[(int)(Math.random()*3)][(int)(Math.random()*3)].setBomb();
        }
        return cells;
    }
}
