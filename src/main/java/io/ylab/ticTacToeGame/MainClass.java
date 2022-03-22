package io.ylab.ticTacToeGame;

import io.ylab.ticTacToeGame.objects.Menu;
import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.enums.ContinueGame;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.objects.game.GameBuilder;
import io.ylab.ticTacToeGame.objects.game.OfflineGame;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Game game = null;
        ContinueGame continueGame = ContinueGame.NEW_GAME;

        do {
            if (continueGame == ContinueGame.NEW_GAME)
                game = GameBuilder.createGame();
            game.play();
            switch (game.getTypeGame()) {
                case SIMULATION:
                    Message.printContinueSimulationGame();
                    break;
                case BOT_PLAYER:
                case PLAYER_PLAYER:
                    Message.printContinuePersonGame();
                    break;
            }
            continueGame = Menu.isContinueGame();
            if (continueGame == ContinueGame.CONTINUE)
                game.newRound();
        }
        while (continueGame != ContinueGame.EXIT);
    }
}
