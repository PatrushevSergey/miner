package ru.lesson.miner.GUI;

import ru.lesson.miner.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Сергей on 13.04.2017.
 */
public class GUIAction extends BaseAction implements ActionListener, MouseListener {

    private GUIBoard board;
    private MinerLogic logic;

    public GUIAction( MinerLogic logic, GUIBoard board,GeneratorBoard generator) {
        super(generator, board, logic);
        this.board = board;
        this.board.addMouseListener(this);
        this.logic = logic;
    }

    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();
        int x = e.getX();
        int y = e.getY();
       select(x/50, y/50, false);

        board.repaint();
    }


    // реализовать!

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void select(int x, int y, boolean bomb) {
        super.select(x, y, bomb);
    }
}
