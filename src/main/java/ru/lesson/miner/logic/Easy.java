package ru.lesson.miner.logic;

import ru.lesson.miner.Cell;
import ru.lesson.miner.MinerLogic;

/**
 * Created by Сергей on 13.04.2017.
 */
public class Easy implements MinerLogic {

    private Cell[][] cells;
    public boolean finish;
    public static int counter = 0;

    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && selected.isOpened();
    }

    /**
     * проверяет, не закончена ли игра - если все клетки без бомб открыты
     * и все с бомбами закрыты
     * @return
     */
    public boolean finish() {

        for(Cell[] row: cells) {
            for (Cell cell : row) {
                if ((!cell.isBomb() && !cell.isOpened())) {
                    finish = false;
                    return finish;
                }
                else finish = true;
            }
        }
        System.out.println(finish);
            return finish;
    }
}
