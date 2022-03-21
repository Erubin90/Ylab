package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResultModel implements Model {

    @JsonProperty("player")
    @JacksonXmlProperty(localName = "Player")
    private PlayerModel player;

    @Override
    public String toString() {
        return "GameResult{" +
                "playerParserObject=" + player +
                '}';
    }
}
