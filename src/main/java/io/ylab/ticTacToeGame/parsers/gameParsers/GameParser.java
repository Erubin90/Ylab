package io.ylab.ticTacToeGame.parsers.gameParsers;

import io.ylab.ticTacToeGame.game.Game;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.parsers.Parser;

import java.io.File;
import java.io.IOException;

public class GameParser implements Parser<Game> {

    private Parser<Game> gameStorage;

    public GameParser(FileFormat fileFormat) {
        switch (fileFormat) {
            case XML:
                this.gameStorage = new GameXmlParser();
                break;
            case JSON:
                this.gameStorage = new GameJsonParser();
                break;
        }
    }

    @Override
    public Game read(File file) throws IOException {
        return gameStorage.read(file);
    }

    @Override
    public void write(Game game, File file) throws IOException {
        gameStorage.write(game, file);
    }
}
