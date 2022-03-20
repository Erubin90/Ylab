package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.ContinueGame;
import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.objects.players.Player;

import java.util.List;
import java.util.Scanner;

public interface Game {

    void play();

    ContinueGame isContinueGame(Scanner scan);

    List<Player> getPlayers();

    List<Step> getSteps();

    Player getWinPlayer();

    void setPlayers(List<Player> players);

    void setSteps(List<Step> steps);

    void setWinPlayer(Player winPlayer);

    TypeGame getTypeGame();

    String getInfoForTest();
}
