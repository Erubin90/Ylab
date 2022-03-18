package io.ylab.ticTacToeGame.parsers.gameParsers.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.game.Game;
import io.ylab.ticTacToeGame.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.parsers.gameParsers.adapters.NumberStepAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"Player", "Game", "GameResult"})
public class GamePlay implements ParserObject {

    @JsonProperty("Player")
    private List<PlayerPojo> playerPojoList;

    @JsonProperty("Game")
    private GamePojo gamePOJO;

    @JsonProperty("GameResult")
    private GameResult gameResult;

    @JsonIgnore
    public GamePlay(Game game) {
        this.playerPojoList = new ArrayList<>();
        for (var player : game.getPlayers())
            playerPojoList.add(new PlayerPojo(player));

        var stepParserList = new ArrayList<StepPojo>();
        for (var step : game.getSteps())
            stepParserList.add(new StepPojo(step));
        this.gamePOJO = new GamePojo(stepParserList);

        PlayerPojo winPlayer = null;
        if (game.getWinPlayer() != null)
            winPlayer = new PlayerPojo(game.getWinPlayer());
        this.gameResult = new GameResult(winPlayer);
    }

    @JsonIgnore
    public Game getGame() throws StepNoCorrectValueException {
        var players = new ArrayList<Player>();
        for (var player : playerPojoList)
            players.add(player.getPlayer());

        var stepAdapter = new NumberStepAdapter(players);
        for (var step : gamePOJO.getSteps())
            stepAdapter.addStep(step.getNum(), step.getPlayerId(), step.getText());
        List<Step> steps = stepAdapter.getStepList();

        int sizeMatrix = stepAdapter.getSizeMatrix();

        Game game = new SimulationGame(players, steps, sizeMatrix);

        var player = gameResult.getPlayerPojo();
        if (player != null)
            game.setWinPlayer(player.getPlayer());
        return game;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "player=" + playerPojoList +
                ", game=" + gamePOJO +
                ", gameResult=" + gameResult +
                '}';
    }
}
