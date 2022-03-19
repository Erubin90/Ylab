package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.ContinueGame;
import io.ylab.ticTacToeGame.objects.players.Player;

import java.util.List;

public interface Game {

    ContinueGame play();

    List<Player> getPlayers();

    List<Step> getSteps();

    Player getWinPlayer();

    void setPlayers(List<Player> players);

    void setSteps(List<Step> steps);

    void setWinPlayer(Player winPlayer);

    String getInfoForTest();
}
