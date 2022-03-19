package io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser;

import io.ylab.ticTacToeGame.model.*;
import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.tools.Checker;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLToGameParser {

    private static final XMLInputFactory INPUT_FACTORY = XMLInputFactory.newInstance();

    public XMLToGameParser() {
    }

    public Game read(File file) throws IOException {
        Checker.checkFile(file);
        GamePlayModel gamePlay = new GamePlayModel();
        var players = new ArrayList<PlayerModel>();
        var steps = new ArrayList<StepModel>();
        PlayerModel winPlayer = null;
        PlayerModel player;
        StepModel step;
        try {
            /*
            инициализируем reader и скармливаем ему xml файл
            проходим по всем элементам xml файла
            */
            XMLEventReader reader = INPUT_FACTORY.createXMLEventReader(new FileInputStream(file.getAbsolutePath()), "windows-1251");
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String localPart = startElement.getName().getLocalPart();
                    // получаем Player
                    if (localPart.equals("Player")) {
                        player = getPlayer(startElement);
                        players.add(player);
                    }
                    // получаем Step
                    else if (localPart.equals("Step")) {
                        String playerId = startElement
                                .getAttributeByName(new QName("playerId"))
                                .getValue();
                        String num = startElement
                                .getAttributeByName(new QName("num"))
                                .getValue();
                        xmlEvent = reader.nextEvent();
                        String move = xmlEvent.asCharacters().getData();
                        step = new StepModel(playerId, num, move);
                        steps.add(step);
                    }
                    //Добавляем игрока победителя в конец списка игроков
                    else if (localPart.equals("GameResult")) {
                        xmlEvent = reader.nextEvent();
                        xmlEvent = reader.nextEvent();
                        if (xmlEvent.isStartElement()) {
                            startElement = xmlEvent.asStartElement();
                            winPlayer = getPlayer(startElement);
                        }
                        break;
                    }
                }
            }
            reader.close();
        }
        catch (XMLStreamException exc) {
            exc.printStackTrace();
        }
        gamePlay.setPlayerList(players);
        gamePlay.setGameModel(new GameModel(steps));
        gamePlay.setGameResult(new GameResultModel(winPlayer));
        return gamePlay.getGame();
    }

    private PlayerModel getPlayer(StartElement startElement) {
        String id = startElement
                .getAttributeByName(new QName("id"))
                .getValue();
        String name = startElement
                .getAttributeByName(new QName("name"))
                .getValue();
        String symbol = startElement
                .getAttributeByName(new QName("symbol"))
                .getValue();
        return new PlayerModel(id, name, symbol);
    }
}