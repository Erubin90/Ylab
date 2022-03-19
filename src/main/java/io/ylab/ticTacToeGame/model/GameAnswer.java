package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.objects.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameAnswer {

    @JsonProperty("gameplay")
    private GamePlayModel gamePlay;

    @JsonIgnore
    public GameAnswer(Game game) {
        this.gamePlay = new GamePlayModel(game);
    }

    @JsonIgnore
    public Game getGame() throws StepNoCorrectValueException {
        return gamePlay.getGame();
    }
}
