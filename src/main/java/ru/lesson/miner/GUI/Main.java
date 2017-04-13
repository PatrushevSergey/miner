package ru.lesson.miner.GUI;

import ru.lesson.miner.Generator100;
import ru.lesson.miner.logic.Easy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Сергей on 14.04.2017.
 */
public class Main {
    private static final JPanel controlPanel = new JPanel();
    public static final GUIBoard board = new GUIBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Сапер");
                frame.setLayout(new BorderLayout());;
                frame.setSize(515, 580);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());
                final  JButton generate = new JButton("Начать");
                generate.addActionListener(new GUIAction(new Easy(), board, new Generator100()));
                controlPanel.add(generate);
                centre(frame);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        closePerform(frame);
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public static void centre(Window w) {
        Dimension us = w.getSize();
        Dimension then = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (then.width - us.width) / 2;
        int newY = (then.height - us.height) / 2;
        w.setLocation(newX, newY);
    }

    public static void closePerform( JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
