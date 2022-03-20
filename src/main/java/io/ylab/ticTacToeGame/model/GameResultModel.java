package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResultModel implements Model {

    @JsonProperty("player")
    @JacksonXmlProperty(localName = "Player")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PlayerModel player;

    @Override
    public String toString() {
        return "GameResult{" +
                "playerParserObject=" + player +
                '}';
    }
}
