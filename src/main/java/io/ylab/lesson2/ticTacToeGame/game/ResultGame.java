package io.ylab.lesson2.ticTacToeGame.game;

public enum ResultGame {
    WIN(),
    DRAW(),
    NEXT_MOVE();

    private Symbol symbol;

    ResultGame() {
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
