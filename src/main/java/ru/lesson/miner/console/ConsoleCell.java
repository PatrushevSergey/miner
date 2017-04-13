package ru.lesson.miner.console;



import ru.lesson.miner.Cell;

import java.io.PrintStream;

/**
 * Created by Сергей on 13.04.2017.
 */
public class ConsoleCell implements Cell<PrintStream> {

    private boolean bomb;
    private boolean suggestBomb = false;
    private boolean suggestEmpty = false;

    public ConsoleCell(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public void setBomb() {
        this.bomb = true;
    }

    public boolean isSuggestBomb() {
        return this.suggestBomb;
    }

    public boolean isSuggestEmpty() {
        return suggestEmpty;
    }

    public void suggestEmpty() {
        this.suggestEmpty = true;
    }

    public void suggestBomb() {
        this.suggestBomb = true;
    }

    public void draw(PrintStream paint, boolean real) {
        if (real) {
            if (this.isBomb()) {
                paint.print("[*]");
            } else {
                paint.print("[O]");
            }
        } else {
            if (this.suggestBomb) {
                paint.print("[?]");
            } else if (this.suggestEmpty) {
                paint.print("[ ]");
            } else {
                paint.print("[X]");
            }
        }
    }
}
