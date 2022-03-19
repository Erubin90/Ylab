package io.ylab.ticTacToeGame.objects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Symbol {
    X('X'),
    O('O');

    private final char sing;

    public static Symbol getOpponentSymbol(Symbol mySymbol) {
        return mySymbol == Symbol.X ? Symbol.O : Symbol.X;
    }

    public static Symbol getSymbol(String sing) {
        return sing.equals("X") ? Symbol.X : Symbol.O;
    }
}
