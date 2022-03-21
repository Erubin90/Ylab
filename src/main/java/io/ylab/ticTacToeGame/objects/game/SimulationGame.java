package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.objects.players.Player;

import java.util.List;
import java.util.Scanner;

public class SimulationGame extends AbstractGame {

    public SimulationGame(List<Player> players, List<Step> steps, int sizeMatrix) {
        this.players = players;
        this.steps = steps;
        this.scan = new Scanner(System.in);
        this.matrix = new char[sizeMatrix][sizeMatrix];
        this.typeGame = TypeGame.SIMULATION;
    }

    public SimulationGame(List<Player> players, List<Step> steps) {
        super();
        this.players = players;
        this.steps = steps;
        this.scan = new Scanner(System.in);
        this.typeGame = TypeGame.SIMULATION;
    }

    @Override
    public void play() {
        Message.printSeparator("-", countPattern);
        Message.printStartGame(players);
        Message.printSeparator("-", countPattern);
        for (Step step: steps) {
            Player player = step.getPlayer();
            Message.printBotMove(player.getName(), step);
            int row = step.getRow();
            int col = step.getCol();
            char sing = player.getSymbol().getSing();
            matrix[row][col] = sing;
            Message.printMatrix(matrix);
            Message.printSeparator("-", countPattern);
        }

        if (winPlayer != null) {
            String winName = winPlayer.getName();
            Message.printWinPlayer(winName);
        }
        else
            Message.printDrawPlayers();
    }
}
