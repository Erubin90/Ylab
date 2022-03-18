package io.ylab.ticTacToeGame.parsers.gameParsers.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameAnswer {

    @JsonProperty("Gameplay")
    private GamePlay gamePlay;

    @JsonIgnore
    public GameAnswer(Game game) {
        this.gamePlay = new GamePlay(game);
    }

    @JsonIgnore
    public Game getGame() throws StepNoCorrectValueException {
        return gamePlay.getGame();
    }
}
