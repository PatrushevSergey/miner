package ru.lesson.miner.GUI;

import ru.lesson.miner.Board;
import ru.lesson.miner.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергей on 13.04.2017.
 */
public class GUIBoard extends JPanel implements Board {

    public static final int PADDING = 50;
    public  static Cell<Graphics>[][] cells;
    public boolean real = false;

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

    public void drawBang() {
        ImageIcon boom = new ImageIcon("C:\\images\\1.png");
        JFrame frame = new JFrame("BOOM!");
        frame.setSize(200, 200);
        JLabel label = new JLabel(boom);
        frame.getContentPane().add(label);
        frame.setVisible(true);
        Main.centre(frame);
        this.repaint();
    }


    public void drawCongratulate() {
        ImageIcon congr = new ImageIcon("C:\\images\\2.jpg");
        JFrame frame = new JFrame("Yeah!!");
        frame.setSize(200, 200);
        JLabel label = new JLabel(congr);
        frame.getContentPane().add(label);
        frame.setVisible(true);
        Main.centre(frame);
        this.repaint();

    }

    public Cell[][] getCell() {
        return cells;
    }
}
