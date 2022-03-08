package io.ylab.lesson2.ticTacToeGame.game;

public enum Symbol {
    X('X'),
    O('O');

    private final char sing;

    Symbol(char sing) {
        this.sing = sing;
    }

    public char getSing() {
        return sing;
    }

    public static Symbol getOpponentSymbol(Symbol mySymbol) {
        return mySymbol == Symbol.X ? Symbol.O : Symbol.X;
    }

    public static Symbol getSymbol(char sing) {
        return sing == 'X' ? Symbol.X : Symbol.O;
    }
}
