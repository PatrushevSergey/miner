package ru.lesson.miner.console;

import ru.lesson.miner.Board;
import ru.lesson.miner.Cell;

/**
 * Created by Сергей on 13.04.2017.
 */
public class ConsoleBoard implements Board{

    private Cell[][] cells;

    public void drawBoard(Cell[][] cell) {
        this.cells = cell;
        this.redraw(false);
    }

    public void drawCell(int x, int y) {
        System.out.println("**** SELECT ****");
        this.redraw(false);
    }

    public void drawBang() {
        System.out.println("**** BANG ****");
        this.redraw(true);
    }

    public void drawCongratulate() {
        System.out.println("**** GRATS ****");
    }

    private void redraw(boolean real) {
        for(Cell[] row: cells) {
            for(Cell cell: row) {
                cell.draw(System.out, real);
            }
            System.out.println();
        }
        System.out.println();
    }
}
