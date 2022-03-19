package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.objects.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.parsers.adapters.NumberStepAdapter;
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
@JacksonXmlRootElement(localName = "GamePlay")
@JsonPropertyOrder({"Players", "Game", "GameResult", "players", "game", "gameResult"})
public class GamePlayModel implements Model {

    @JsonProperty("players")
    @JacksonXmlProperty(localName = "Players")
    private List<PlayerModel> playerList;

    @JsonProperty("game")
    @JacksonXmlProperty(localName = "Game")
    private GameModel gameModel;

    @JsonProperty("gameResult")
    @JacksonXmlProperty(localName = "GameResult")
    private GameResultModel gameResult;

    @JsonIgnore
    public GamePlayModel(Game game) {
        this.playerList = new ArrayList<>();
        for (var player : game.getPlayers())
            playerList.add(new PlayerModel(player));

        var stepParserList = new ArrayList<StepModel>();
        for (var step : game.getSteps())
            stepParserList.add(new StepModel(step));
        this.gameModel = new GameModel(stepParserList);

        PlayerModel winPlayer = null;
        if (game.getWinPlayer() != null)
            winPlayer = new PlayerModel(game.getWinPlayer());
        this.gameResult = new GameResultModel(winPlayer);
    }

    @JsonIgnore
    public Game getGame() throws StepNoCorrectValueException {
        var players = new ArrayList<Player>();
        for (var player : playerList)
            players.add(player.getPlayer());

        var stepAdapter = new NumberStepAdapter(players);
        for (var step : gameModel.getSteps())
            stepAdapter.addStep(step.getNum(), step.getPlayerId(), step.getText());
        List<Step> steps = stepAdapter.getStepList();

        int sizeMatrix = stepAdapter.getSizeMatrix();

        Game game = new SimulationGame(players, steps, sizeMatrix);

        var player = gameResult.getPlayer();
        if (player != null)
            game.setWinPlayer(player.getPlayer());
        return game;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "player=" + playerList +
                ", game=" + gameModel +
                ", gameResult=" + gameResult +
                '}';
    }
}
