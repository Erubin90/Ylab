package io.ylab.ticTacToeGame.game;

import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.ContinueGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimulationGame extends Game {

    public SimulationGame(List<Player> players, List<Step> steps) {
        super();
        this.players = players;
        this.steps = steps;
        this.scan = new Scanner(System.in);
    }

    @Override
    public ContinueGame play() {
        Message.printStartGame(players);
        Message.printSeparator("-", countPattern);
        for (Step step: steps) {
            Player player = step.getPlayer();
            Message.printBotMove(player.getName(), step);
            int row = step.getRow();
            int col = step.getCol();
            char sing = step.getSymbol().getSing();
            matrix[row][col] = sing;
            Message.printMatrix(matrix);
            Message.printSeparator("-", countPattern);
        }
        Player winPlayer = players.get(2);

        if (winPlayer.getName() != null) {
            String winName = winPlayer.getName();
            Message.printWinPlayer(winName);
        }
        else
            Message.printDrawPlayers();
        Message.printContinueSimulationGame();
        return this.isContinueGame(scan);
    }

    @Override
    public String toString() {
        return "SimulationGame{" +
                "typeGame=" + typeGame +
                ", players=" + players +
                ", scope=" + scope +
                ", matrix=" + Arrays.toString(matrix) +
                ", countPattern=" + countPattern +
                ", steps=" + steps +
                '}';
    }
}
