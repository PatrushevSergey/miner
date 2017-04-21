package ru.lesson.miner.GUI;

import ru.lesson.miner.Board;
import ru.lesson.miner.Cell;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергей on 13.04.2017.
 * представляет собой игровую доску
 */
public class GUIBoard extends JPanel implements Board {

    public static final int PADDING = 50;
    public  static Cell<Graphics>[][] cells;

    /**
     * рисует компоненты доски
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.cells != null) {
            for (int x = 0; x != cells.length ; x++) {
                for (int y = 0; y != cells[0].length; y++) {
                    g.setColor(Color.black);
                    cells[x][y].draw(g);
                    g.drawRect(x*PADDING, y*PADDING, PADDING, PADDING);
                }
                
            }
        }
    }

    public void drawBoard(Cell[][] cell) {
        this.cells = cell;
        this.repaint();
    }

    public void drawCell(int x, int y) {
        this.repaint();
    }

    /**
     * создает окно в случае "взрыва" бомбы
     */
    public void drawBang() {
        ImageIcon boom = new ImageIcon(getClass().getResource("/images/1.png"));
        JFrame frame = new JFrame("BOOM!");
        frame.setSize(200, 200);
        JLabel label = new JLabel(boom);
        frame.getContentPane().add(label);
        frame.setVisible(true);
        Main.centre(frame);
        this.repaint();
    }

    /**
     * создает окно победы с фейерверком
     */
    public void drawCongratulate() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/2.jpg"));
        JFrame frame = new JFrame("Yeah!!");
        frame.setSize(200, 200);
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);
        frame.setVisible(true);
        Main.centre(frame);
        this.repaint();
    }

    /**
     * возвращает массив клеток
     * @return
     */
    public Cell[][] getCell() {
        return cells;
    }
}
