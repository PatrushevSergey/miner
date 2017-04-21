package ru.lesson.miner.GUI;

import ru.lesson.miner.Generator100;
import ru.lesson.miner.Generator49;
import ru.lesson.miner.logic.Easy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Сергей on 14.04.2017.
 * тут реализуется графический интерфейс игры и запускаются все вспомогательные классы
 */
public class Main {
    public static final JPanel controlPanel = new JPanel();
    public static final GUIBoard board = new GUIBoard();
    public static final GUIBoard board100 = new GUIBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Сапер");
                board.setFont(new Font("Verdana", Font.BOLD, 20));
                board100.setFont(new Font("Verdana", Font.BOLD, 20));
                frame.setLayout(new BorderLayout());
                frame.setSize(250, 180);

                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                board100.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());
                final JPanel instruction = new JPanel();
                instruction.setLayout(new FlowLayout());
                frame.add(instruction, BorderLayout.CENTER);
                JLabel instruction1 = new JLabel("ИНСТРУКЦИЯ:");
                JLabel instruction2 = new JLabel("левой кнопкой открываем поле");
                JLabel instruction3 = new JLabel("правой ставим маркер  БОМБА");
                JLabel instruction4 = new JLabel("Выберите размер поля:");
                instruction.add(instruction1);
                instruction.add(instruction2);
                instruction.add(instruction3);
                instruction.add(instruction4);
                final  JButton generate49 = new JButton("Поле на 49");
                final  JButton generate100 = new JButton("Поле на 100");
                generate100.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.remove(instruction);
                        frame.remove(board100);
                        frame.remove(board);
                        new GUIAction(new Easy(), board100, new Generator100()).initGame();
                        frame.add(board100, BorderLayout.CENTER);
                        frame.setSize(515, 580);
                    }
                });
                generate49.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.remove(instruction);
                        frame.remove(board100);
                        frame.remove(board);
                        new GUIAction(new Easy(), board, new Generator49()).initGame();
                        frame.add(board, BorderLayout.CENTER);
                        frame.setSize(365, 430);
                    }
                });


                controlPanel.add(generate49);
                controlPanel.add(generate100);
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

    /**
     * располагает окно по центру экрана
     * @param w
     */
    public static void centre(Window w) {
        Dimension us = w.getSize();
        Dimension then = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (then.width - us.width) / 2;
        int newY = (then.height - us.height) / 2;
        w.setLocation(newX, newY);
    }

    /**
     * отключает окно при закрытии
     * @param frame
     */
    public static void closePerform( JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
