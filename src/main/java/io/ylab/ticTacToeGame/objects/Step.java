package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.Symbol;

public class Step {

    private Player player;

    private int num;

    private int row;

    private int col;

    private Symbol symbol;

    public Step() {
    }

    public Step(int row, int col, Symbol symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Step{" +
                "playerId=" + player +
                ", num=" + num +
                ", row=" + row +
                ", col=" + col +
                ", symbol=" + symbol +
                '}';
    }
}