package io.ylab.ticTacToeGame.parsers.gameParsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.parsers.Parser;
import io.ylab.ticTacToeGame.model.GameAnswer;

import java.io.File;
import java.io.IOException;

public class GameJsonParser implements Parser<Game> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public Game read(String string) throws IOException {
        var gameAnswer = OBJECT_MAPPER.readValue(string, GameAnswer.class);
        return gameAnswer.getGame();
    }

    @Override
    public Game read(File file) throws IOException {
        var gameAnswer = OBJECT_MAPPER.readValue(file, GameAnswer.class);
        return gameAnswer.getGame();
    }

    @Override
    public void write(Game game, File file) throws IOException {
        var gameAnswer = new GameAnswer(game);
        OBJECT_MAPPER.writeValue(file, gameAnswer);
    }
}
