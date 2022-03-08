package io.ylab.lesson2.ticTacToeGame.objects;

import io.ylab.lesson2.ticTacToeGame.game.Symbol;
import io.ylab.lesson2.ticTacToeGame.game.Game;
import io.ylab.lesson2.ticTacToeGame.game.Message;
import io.ylab.lesson2.ticTacToeGame.game.ResultGame;

import java.util.Scanner;

public class Bot extends Player {

    private Symbol opponentSymbol;

    public Bot(Player player) {
        super(player.getName(), player.getPoint());
    }

    @Override
    public Move move(Scanner scanner, char[][] matrix) {
        int bestVal = -1000;
        Move move = new Move(-1, -1, this.symbol);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][col] = this.symbol.getSing();
                    int moveVal = minMax(matrix, 0, false);
                    matrix[row][col] = 0;
                    if (moveVal > bestVal) {
                        bestVal = moveVal;
                        move.setRow(row);
                        move.setCol(col);
                    }
                }
            }
        }
        Message.printBotMove(this.name, move);
        return move;
    }

    private int minMax(char[][] matrix, int depth, Boolean isMax) {
        int score = evaluate(matrix);
        int best;

        if (score == 10)
            return score;

        if (score == -10)
            return score;

        if (!isMovesLeft(matrix))
            return 0;

        if (isMax) {
            best = -1000;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = symbol.getSing();
                        best = Math.max(best, minMax(matrix, depth + 1, false));
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        else {
            best = 1000;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = opponentSymbol.getSing();
                        best = Math.min(best, minMax(matrix, depth + 1, true));
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return best;
    }

    private int evaluate(char[][] matrix) {
        ResultGame resultGame = Game.checkWin(matrix);
        switch (resultGame) {
            case WIN:
                return resultGame.getSymbol() == this.symbol ? 10 : -10;
            case DRAW:
            case NEXT_MOVE:
                return 0;
        }
        return 0;
    }

    private boolean isMovesLeft(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                if (c == 0)
                    return true;
            }
        }
        return false;
    }


    @Override
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.opponentSymbol = Symbol.getOpponentSymbol(symbol);
    }
}
