package io.ylab.ticTacToeGame.objects.players;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;

public interface Player {

    Step move(char[][] matrix);

    int getId();

    String getName();

    Symbol getSymbol();

    int getPoint();

    void setId(int id);

    void setName(String name);

    void setSymbol(Symbol symbol);

    void addPoint();
}
