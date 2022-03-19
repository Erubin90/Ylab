package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.objects.players.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {

    private Player player;

    private int num;

    private int row;

    private int col;

    private Symbol symbol;

    public Step() {
    }

    public Step(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.symbol = player.getSymbol();
    }

    public Step(int num, int row, int col, Player player) {
        this.num = num;
        this.row = row;
        this.col = col;
        this.player = player;
        this.symbol = player.getSymbol();
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.symbol = player.getSymbol();
    }

    //Для теста
    @Override
    public String toString() {
        return "Step{" +
                "playerId=" + player.getId() +
                ", num=" + num +
                ", row=" + row +
                ", col=" + col +
                ", symbol=" + symbol +
                '}';
    }
}
