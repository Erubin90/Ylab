package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.enums.ResultGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void checkWin() {

        char[][] matrixNextMove1 = {
                {'X', 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        char[][] matrixNextMove2 = {
                {'X', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 0, 'O'}};

        char[][] matrixDrawMove = {
                {'X', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}};

        char[][] matrixWinMove1 = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}};

        char[][] matrixWinMove2 = {
                {'O', 'O', 'O'},
                {'X', 'X', 0},
                {'X', 0, 'X'}};

        char[][] matrixWinMove3 = {
                {'X', 'O', 0},
                {'X', 'O', 0},
                {'X', 0, 0}};

        assertEquals(ResultGame.NEXT_MOVE, AbstractGame.checkWin(matrixNextMove1));
        assertEquals(ResultGame.NEXT_MOVE, AbstractGame.checkWin(matrixNextMove2));
        assertEquals(ResultGame.DRAW, AbstractGame.checkWin(matrixDrawMove));
        assertEquals(ResultGame.WIN, AbstractGame.checkWin(matrixWinMove1));
        assertEquals(ResultGame.WIN, AbstractGame.checkWin(matrixWinMove2));
        assertEquals(ResultGame.WIN, AbstractGame.checkWin(matrixWinMove3));
    }
}