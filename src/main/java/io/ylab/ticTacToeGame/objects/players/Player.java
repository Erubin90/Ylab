package io.ylab.ticTacToeGame.objects.players;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;

import java.util.Scanner;

public interface Player {

    Step move(Scanner scan, char[][] matrix);

    int getId();

    String getName();

    Symbol getSymbol();

    int getPoint();

    void setId(int id);

    void setName(String name);

    void setSymbol(Symbol symbol);

    void addPoint();
}
