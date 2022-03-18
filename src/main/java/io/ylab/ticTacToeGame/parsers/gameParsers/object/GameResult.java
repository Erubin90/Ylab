package io.ylab.ticTacToeGame.parsers.gameParsers.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResult implements ParserObject {

    @JsonProperty("Player")
    private PlayerPojo playerPojo;

    @Override
    public String toString() {
        return "GameResult{" +
                "playerParserObject=" + playerPojo +
                '}';
    }
}
