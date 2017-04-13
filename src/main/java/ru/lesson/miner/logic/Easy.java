package ru.lesson.miner.logic;

import ru.lesson.miner.Cell;
import ru.lesson.miner.MinerLogic;

/**
 * Created by Сергей on 13.04.2017.
 */
public class Easy implements MinerLogic {

    private Cell[][] cells;

    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSuggestBomb();
    }

    public boolean finish() {
        boolean finish = false;
        for(Cell[] row: cells) {
            for (Cell cell: row) {
                finish = ((cell.isSuggestBomb() && cell.isBomb()) || (cell.isSuggestEmpty() && !cell.isBomb()));
            }
        }
        return finish;
    }

    public void suggest(int x, int y, boolean bomb) {
        if(bomb) {
            this.cells[x][y].suggestBomb();
        } else  {
            this.cells[x][y].suggestEmpty();
        }
    }
}
