package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.*;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.parsers.gameParsers.GameParser;
import io.ylab.ticTacToeGame.tools.Creator;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class AbstractGame implements Game {

    @Getter
    protected Map<String, Integer> scope;

    protected char[][] matrix;

    @Getter
    protected TypeGame typeGame;

    @Getter
    @Setter
    protected List<Player> players;

    @Getter
    @Setter
    protected Player winPlayer;

    @Getter
    @Setter
    protected List<Step> steps;

    protected final int countPattern = 30;

    public AbstractGame() {
        this.matrix = new char[3][3];
    }

    /*
    Проверяет результат игры.
    Если ничья возвращает null
     */
    public static ResultGame checkWin(char[][] matrix) {
        ResultGame resultGame = ResultGame.NEXT_MOVE;
        int numberEmptyCells = 0;

        //Проверка по столбцам и по столбцам и строкам на победу Х или О
        for (int i = 0; i < matrix.length; i++) {

            //проверка по строке
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                if (matrix[i][0] != 0) {
                    resultGame = ResultGame.WIN;
                    Symbol symbol = Symbol.getSymbol(String.valueOf(matrix[i][0]));
                    resultGame.setSymbol(symbol);
                    return resultGame;
                }
            }

            //проверка по столбцу
            if ((matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i])) {
                if (matrix[0][i] != 0) {
                    resultGame = ResultGame.WIN;
                    Symbol symbol = Symbol.getSymbol(String.valueOf(matrix[0][i]));
                    resultGame.setSymbol(symbol);
                    return resultGame;
                }
            }

            //подсчет пустых ячеек
            for (char c : matrix[i]) {
                if (c == 0)
                    numberEmptyCells++;
            }
        }

        //Проверка по диагоналям на победу Х или О
        if ((matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) ||
                (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]))
            if (matrix[1][1] != 0) {
                resultGame = ResultGame.WIN;
                Symbol symbol = Symbol.getSymbol(String.valueOf(matrix[1][1]));
                resultGame.setSymbol(symbol);
                return resultGame;
            }

        //Проверка на ничью
        if (numberEmptyCells == 0)
            resultGame = ResultGame.DRAW;

        return resultGame;
    }

    protected void saveGame(Directory directory, FileFormat... fileFormats) throws IOException {
        for (var formatFile : fileFormats) {
            File file = Creator.createFile(players, formatFile, directory);
            GameParser parser = new GameParser(formatFile);
            parser.write(this, file);
        }
    }
}
