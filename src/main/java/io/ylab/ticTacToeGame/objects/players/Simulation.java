package io.ylab.ticTacToeGame.objects.players;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;

public class Simulation extends AbstractPlayer {

    public Simulation(String name) {
        super(name);
    }

    public Simulation(int  id, String name, Symbol symbol) {
        super(name);
        this.id = id;
        this.symbol = symbol;
    }

    @Override
    public Step move(char[][] matrix) {
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
