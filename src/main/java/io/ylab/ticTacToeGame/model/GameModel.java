package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameModel implements Model {

    @JsonProperty("step")
    @JacksonXmlProperty(localName = "Step")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<StepModel> steps;

    @Override
    public String toString() {
        return "GameModel{" +
                "steps=" + steps +
                '}';
    }
}
