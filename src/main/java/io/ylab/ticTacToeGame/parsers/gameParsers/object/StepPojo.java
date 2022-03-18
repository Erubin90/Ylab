package io.ylab.ticTacToeGame.parsers.gameParsers.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.ylab.ticTacToeGame.objects.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder()
public class StepPojo implements ParserObject {

    @JsonProperty("_playerId")
    private String playerId;

    @JsonProperty("_num")
    private String num;

    @JsonProperty("__text")
    private String text;

    @JsonIgnore
    public StepPojo(Step step) {
        this.playerId = String.valueOf(step.getPlayer().getId());
        this.num = String.valueOf(step.getNum());
        this.text = step.getRow() + " " + step.getCol();
    }

    @Override
    public String toString() {
        return "Step{" +
                "playerId='" + playerId + '\'' +
                ", num='" + num + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
