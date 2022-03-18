package io.ylab.ticTacToeGame.parsers.gameParsers.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Simulation;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"_id", "_name", "_symbol"})
public class PlayerPojo implements ParserObject {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_name")
    private String name;

    @JsonProperty("_symbol")
    private String symbol;

    @JsonIgnore
    public PlayerPojo(Player player) {
        this.id = String.valueOf(player.getId());
        this.name = player.getName();
        this.symbol = String.valueOf(player.getSymbol().getSing());
    }

    @JsonIgnore
    public Player getPlayer() {
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
