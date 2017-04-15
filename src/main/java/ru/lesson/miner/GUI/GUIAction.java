package ru.lesson.miner.GUI;

import ru.lesson.miner.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Сергей on 13.04.2017.
 * описывает действия игрока
 */
public class GUIAction  implements  UserAction, ActionListener, MouseListener {

    private GUIBoard board;
    private MinerLogic logic;
    private GeneratorBoard generator;

    public GUIAction( MinerLogic logic, GUIBoard board,GeneratorBoard generator) {
        this.board = board;
        this.board.addMouseListener(this);
        this.logic = logic;
        this.generator = generator;
    }

    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    /**
     * обрабатывает клик правой и левой кнопок мыши
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();
        if(button == 1) {
            int x = e.getX();
            int y = e.getY();
            select(x / 50, y / 50).setOpened();
            select(x / 50, y / 50).setDrawBomb(false);
        } else {

            int x = e.getX();
            int y = e.getY();
            select(x / 50, y / 50).setDrawBomb(true);
        }

        board.repaint();
    }


    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    /**
     * инициализирует игру
     */
    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    /**
     * выбираем ячейку и рисуем в ней взрыв если бомба или победа.
     * @param x координаты ячейки
     * @param y
     */
    public Cell select(int x, int y) {
        board.drawCell(x,y);
        if(this.logic.shouldBang(x,y)) {
            this.board.drawBang();
        }
        if (logic.finish()) {
            board.drawCongratulate();
        }
        return board.getCell()[x][y];
    }

    /**
     * не работает!
     * @param x
     * @param y
     */
    public void checkNext(int x, int y) {
        if (board.getCell()[x][y].counter(x,y) == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {

                    board.getCell()[i][j].setOpened();
                }
            }
        }
    }
}
