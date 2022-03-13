package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.Symbol;

import java.util.Scanner;

public abstract class Player {
    protected int id;

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

    public abstract Step move(Scanner scan, char[][] matrix);

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
