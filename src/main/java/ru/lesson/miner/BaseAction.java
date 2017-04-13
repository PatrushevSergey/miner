package ru.lesson.miner;

/**
 * Created by Сергей on 13.04.2017.
 */
public class BaseAction implements UserAction {

    private GeneratorBoard generator;
    private Board board;
    private MinerLogic logic;

    public BaseAction(GeneratorBoard generator, Board board, MinerLogic logic) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    public void select(int x, int y, boolean bomb) {
        this.logic.suggest(x,y,bomb);
        board.drawCell(x,y);
        if(this.logic.shouldBang(x,y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.drawCongratulate();
        }
    }
}
