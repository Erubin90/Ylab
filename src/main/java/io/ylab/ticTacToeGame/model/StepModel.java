package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import io.ylab.ticTacToeGame.objects.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "Step")
@JsonPropertyOrder({"playerId, num, text"})
public class StepModel implements Model {

    @JsonProperty("playerId")
    @JacksonXmlProperty(isAttribute = true, localName = "playerId")
    private String playerId;

    @JsonProperty("num")
    @JacksonXmlProperty(isAttribute = true, localName = "num")
    private String num;

    @JsonProperty("text")
    @JacksonXmlText()
    private String text;

    @JsonIgnore
    public StepModel(Step step) {
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
