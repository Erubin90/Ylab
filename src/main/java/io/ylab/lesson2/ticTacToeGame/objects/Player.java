package io.ylab.lesson2.ticTacToeGame.objects;


import io.ylab.lesson2.ticTacToeGame.game.Symbol;

import java.util.Scanner;

public abstract class Player {
    protected String name;

    protected Symbol symbol;

    protected int point;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
        this.point = 0;
    }

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public abstract Move move(Scanner scanner, char[][] matrix);

    public void addPoint() {
        point++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getPoint() {
        return point;
    }
}
