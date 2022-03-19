package io.ylab.ticTacToeGame.objects.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum ResultGame {
    WIN,
    DRAW,
    NEXT_MOVE;

    private Symbol symbol;

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
