package io.ylab.ticTacToeGame.parsers.gameParsers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.ylab.ticTacToeGame.model.GameAnswer;
import io.ylab.ticTacToeGame.model.GamePlayModel;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.parsers.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameXmlParser implements Parser<Game> {

    private static final XmlMapper XML_MAPPER = new XmlMapper();

    @Override
    public Game read(String string) throws IOException {
        var gameAnswer = XML_MAPPER.readValue(string, GamePlayModel.class);
        return gameAnswer.getGame();
    }

    @Override
    public Game read(File file) throws IOException {
        var gameAnswer = XML_MAPPER.readValue(file, GamePlayModel.class);
        return gameAnswer.getGame();
    }

    @Override
    public void write(Game game, File file) throws IOException {
        var gameplay = new GamePlayModel(game);
        try (var outputStream = new FileOutputStream(file)) {
            String heading = "<?xml version='1.0' encoding='windows-1251'?>\n";
            String content = XML_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(gameplay);
            outputStream.write(heading.getBytes());
            outputStream.write(content.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
