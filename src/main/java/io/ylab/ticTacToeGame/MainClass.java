package io.ylab.ticTacToeGame;

import io.ylab.ticTacToeGame.objects.enums.ContinueGame;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.objects.game.GameBuilder;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Game game = null;
        ContinueGame continueGame = ContinueGame.NEW_GAME;
        Scanner scanner = new Scanner(System.in);

        do {
            if (continueGame == ContinueGame.NEW_GAME)
                game = GameBuilder.createGame(scanner);
            //Возвращает ContinueGame.NEW_GAME или ContinueGame.EXIT
            continueGame = game.play();
        }
        while (continueGame != ContinueGame.EXIT);
        scanner.close();
    }
}
