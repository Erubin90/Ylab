package io.ylab.ticTacToeGame.parsers.gameParsers;

import io.ylab.ticTacToeGame.game.Game;
import io.ylab.ticTacToeGame.parsers.Parser;
import io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser.GameToXMLParser;
import io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser.XMLToGameParser;

import java.io.File;
import java.io.IOException;

public class GameXmlParser implements Parser<Game> {

    private static final XMLToGameParser reader = new XMLToGameParser();

    private static final GameToXMLParser writer = new GameToXMLParser();

    @Override
    public Game read(File file) throws IOException {
        return reader.read(file);
    }

    @Override
    public void write(Game game, File file) throws IOException {
        writer.write(game, file);
    }
}
