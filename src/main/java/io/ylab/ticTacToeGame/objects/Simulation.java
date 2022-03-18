package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.Symbol;

import java.util.Scanner;

public class Simulation extends Player {

    public Simulation() {
        super();
    }

    public Simulation(String name) {
        super(name);
    }

    public Simulation(int  id, String name, Symbol symbol) {
        super(name);
        this.id = id;
        this.symbol = symbol;
    }

    @Override
    public Step move(Scanner scanner, char[][] matrix) {
        return null;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                ", point=" + point +
                '}';
    }
}
