package ru.lesson.miner;

import ru.lesson.miner.GUI.GUICell;

/**
 * Created by Сергей on 14.04.2017.
 */
public class Generator100 implements GeneratorBoard {
    public Cell[][] generate() {
        Cell[][] cells = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new GUICell(i, j);
            }

        }
        cells[1][1].setBomb();
        return cells;
    }
}
