package io.ylab.ticTacToeGame.objects.players;

import io.ylab.ticTacToeGame.objects.enums.Symbol;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractPlayer implements Player {

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

    public AbstractPlayer() {
        count++;
        this.id = count;
    }

    public AbstractPlayer(String name) {
        this.name = name;
        this.point = 0;
        count++;
        this.id = count;
    }

    public AbstractPlayer(String name, int point) {
        this.name = name;
        this.point = point;
        count++;
        this.id = count;
    }

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
