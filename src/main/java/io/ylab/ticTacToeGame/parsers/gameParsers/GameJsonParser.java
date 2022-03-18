package io.ylab.ticTacToeGame.parsers.gameParsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.ylab.ticTacToeGame.game.Game;
import io.ylab.ticTacToeGame.parsers.Parser;
import io.ylab.ticTacToeGame.parsers.gameParsers.object.GameAnswer;

import java.io.File;
import java.io.IOException;

public class GameJsonParser implements Parser<Game> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public Game read(File file) throws IOException {
        var gameAnswer = OBJECT_MAPPER.readValue(file, GameAnswer.class);
        return gameAnswer.getGame();
    }

    @Override
    public void write(Game game, File file) throws IOException {
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        var gameAnswer = new GameAnswer(game);
        OBJECT_MAPPER.writeValue(file, gameAnswer);
    }
}
