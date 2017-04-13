package ru.lesson.miner;

import org.junit.Test;
import ru.lesson.miner.console.ConsoleBoard;
import ru.lesson.miner.console.ConsoleCell;
import ru.lesson.miner.logic.Easy;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 13.04.2017.
 */
public class BaseActionTest {


        final BaseAction action = new BaseAction(
                new GeneratorBoard() {
                    public Cell[][] generate() {
                        return new Cell[][]{
                                {new ConsoleCell(true), new ConsoleCell(false)},
                                {new ConsoleCell(true), new ConsoleCell(false)}
                        };

                    }
                }, new ConsoleBoard(), new Easy()
        );
    @Test
    public void successGame() {
        action.initGame();
        action.select(0,0,true);
        action.select(1,0,true);
        action.select(0,1,false);
        action.select(1,1,false);
    }

    @Test
    public void failureGame() {
        action.initGame();
        action.select(0,0,true);
        action.select(1,0,false);
    }

}