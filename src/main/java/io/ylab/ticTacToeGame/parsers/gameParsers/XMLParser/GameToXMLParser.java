package io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser;

import io.ylab.ticTacToeGame.objects.enums.Directory;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.model.GamePlayModel;
import io.ylab.ticTacToeGame.model.PlayerModel;
import io.ylab.ticTacToeGame.model.StepModel;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.tools.Creator;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

public class GameToXMLParser {

    private static final XMLOutputFactory OUTPUT_FACTORY = XMLOutputFactory.newInstance();

    private static final String END = "\n";

    private static final String TAB = "\t";

    public GameToXMLParser() {
    }

    public void write(Game game) {
        try {
            File file = Creator.createFile(game.getPlayers(), FileFormat.XML, Directory.HISTORY_GAME);
            write(game, file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(Game game, File file) throws IOException {
        var gamePlay = new GamePlayModel(game);
        var players = gamePlay.getPlayerList();
        var steps = gamePlay.getGameModel().getSteps();
        var winPlayer = gamePlay.getGameResult().getPlayer();
        XMLStreamWriter writer;
        try {
            writer = OUTPUT_FACTORY.createXMLStreamWriter(new FileOutputStream(file), "windows-1251");
            //Заголовок документа
            writer.writeStartDocument("windows-1251", "1.0");
            writer.writeDTD(END);

            //Открываем заголовок GamePlay
            writer.writeStartElement("GamePlay");
            writer.writeCharacters(END);

            //Добавляем пустые теги Player
            for (var player : players) {
                addPlayer(writer, player);
            }

            //Открываем заголовок Game
            writer.writeCharacters(TAB);
            writer.writeStartElement("Game");
            writer.writeCharacters(END);

            //Добавляем элементы Step
            for (var step : steps) {
                writer.writeCharacters(TAB);
                addStep(writer, step);
            }

            //Закрываем заголовок Game
            writer.writeCharacters(TAB);
            writer.writeEndElement();
            writer.writeCharacters(END);

            //Открываем заголовок GameResult
            writer.writeCharacters(TAB);
            writer.writeStartElement("GameResult");
            if (winPlayer != null) {
                writer.writeCharacters(END);
                //Добавляем пустой тег выигравшего Player
                writer.writeCharacters(TAB);
                addPlayer(writer, winPlayer);
                writer.writeCharacters(TAB);
            }

            //Закрываем заголовок GameResult
            writer.writeEndElement();
            writer.writeCharacters(END);

            //Закрываем заголовок GamePlay
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void addPlayer(XMLStreamWriter writer, PlayerModel player) throws XMLStreamException {
        if (player != null) {
            String id = player.getId();
            String name = player.getName();
            String symbol = player.getSymbol();
            writer.writeCharacters(TAB);
            writer.writeEmptyElement("Player");
            writer.writeAttribute("id", id);
            writer.writeAttribute("name", name);
            writer.writeAttribute("symbol", symbol);
            writer.writeCharacters(END);
        }
    }

    private void addStep(XMLStreamWriter writer, StepModel step) throws XMLStreamException {
        writer.writeCharacters(TAB);
        writer.writeStartElement("Step");
        String num = step.getNum();
        String playerId = step.getPlayerId();
        String move = step.getText();
        writer.writeAttribute("num", num);
        writer.writeAttribute("playerId", playerId);
        writer.writeCharacters(move);
        writer.writeEndElement();
        writer.writeCharacters(END);
    }
}
