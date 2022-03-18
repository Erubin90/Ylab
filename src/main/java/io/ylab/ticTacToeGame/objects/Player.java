package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.Symbol;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public abstract class Player {

    @Getter
    @Setter
    protected int id;

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected Symbol symbol;

    @Getter
    protected int point;

    private static int count = 0;

    public Player() {
        count++;
        this.id = count;
    }

    public Player(String name) {
        this.name = name;
        this.point = 0;
        count++;
        this.id = count;
    }

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
        count++;
        this.id = count;
    }

    public abstract Step move(Scanner scan, char[][] matrix);

    public void addPoint() {
        point++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
