package io.ylab.ticTacToeGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.objects.players.AbstractPlayer;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.objects.players.Simulation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "name", "symbol"})
public class PlayerModel implements Model {

    @JsonProperty("id")
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;

    @JsonProperty("name")
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JsonProperty("symbol")
    @JacksonXmlProperty(isAttribute = true, localName = "symbol")
    private String symbol;

    @JsonIgnore
    public PlayerModel(Player player) {
        this.id = String.valueOf(player.getId());
        this.name = player.getName();
        this.symbol = String.valueOf(player.getSymbol().getSing());
    }

    @JsonIgnore
    public AbstractPlayer getPlayer() {
        if (id == null || name == null || symbol == null) {
            return null;
        }
        int id = Integer.parseInt(this.id);
        Symbol symbol = Symbol.getSymbol(this.symbol);
        return new Simulation(id, name, symbol);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
