package io.ylab.ticTacToeGame.parsers.gameParsers;

import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.parsers.Parser;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@NoArgsConstructor
public class GameParser implements Parser<Game> {

    private Parser<Game> gameStorage;

    public GameParser(FileFormat fileFormat) {
        setFileFormat(fileFormat);
    }

    @Override
    public Game read(String string) throws IOException {
        return gameStorage.read(string);
    }

    @Override
    public Game read(File file) throws IOException {
        return gameStorage.read(file);
    }

    @Override
    public void write(Game game, File file) throws IOException {
        gameStorage.write(game, file);
    }

    public void setFileFormat(FileFormat format) {
        switch (format) {
            case XML:
                this.gameStorage = new GameXmlParser();
                break;
            case JSON:
                this.gameStorage = new GameJsonParser();
                break;
        }
    }
}
