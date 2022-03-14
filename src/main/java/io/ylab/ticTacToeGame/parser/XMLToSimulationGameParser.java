package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Simulation;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.parser.adapters.NumberStepAdapter;
import io.ylab.ticTacToeGame.parser.adapters.StepAdapter;
import io.ylab.ticTacToeGame.tools.Checker;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLToSimulationGameParser{

    private static final XMLInputFactory INPUT_FACTORY = XMLInputFactory.newInstance();

    private File file;

    private StepAdapter stepAdapter;

    public XMLToSimulationGameParser() {
    }

    public XMLToSimulationGameParser(File file) {
        Checker.checkFile(file);
        this.file = file;
    }

    public void setFile(File file) {
        Checker.checkFile(file);
        this.file = file;
        this.stepAdapter = null;
    }

    public SimulationGame read() throws IOException {
        Player player;
        List<Player> players = new ArrayList<>();
        List<Step> steps = new ArrayList<>();
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
                    switch (startElement.getName().getLocalPart()) {
                        // получаем Player
                        case "Player":
                            player = getPlayer(startElement);
                            players.add(player);
                            break;
                        // получаем Step
                        case "Step":
                            String numAtt = startElement
                                    .getAttributeByName(new QName("num"))
                                    .getValue();
                            String playerIdAtt = startElement
                                    .getAttributeByName(new QName("playerId"))
                                    .getValue();
                            xmlEvent = reader.nextEvent();
                            String move = xmlEvent.asCharacters().toString();

                            if (stepAdapter == null) {
                                if (move.matches("\\d+") || move.matches("\\d\\D+\\d"))
                                    stepAdapter = new NumberStepAdapter(players);
                            }
                            stepAdapter.addStep(numAtt, playerIdAtt, move);

                            break;
                        //Добавляем игрока победителя в конец списка игроков
                        case "GameResult":
                            xmlEvent = reader.nextEvent();
                            if (xmlEvent.isStartElement()) {
                                startElement = xmlEvent.asStartElement();
                                player = getPlayer(startElement);
                                if (player.getName() != null)
                                    players.add(player);
                            }
                            break;
                    }
                }
                else if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()) {
                        case "Game":
                            steps = stepAdapter.getStepList();
                            break;
                    }
                }
            }
            reader.close();
        }
        catch (XMLStreamException exc) {
            exc.printStackTrace();
        }

        return new SimulationGame(players, steps, stepAdapter.getSizeMatrix());
    }

    private Player getPlayer(StartElement startElement) {
        Player player = new Simulation();
        Attribute idAtt = startElement.getAttributeByName(new QName("id"));
        Attribute nameAtt = startElement.getAttributeByName(new QName("name"));
        Attribute symbolAtt = startElement.getAttributeByName(new QName("symbol"));
        if (idAtt != null) {
            player.setId(Integer.parseInt(idAtt.getValue()));
        }
        if (nameAtt != null)
            player.setName(nameAtt.getValue());
        if (symbolAtt != null) {
            if (symbolAtt.getValue().matches("[XxХх]"))
                player.setSymbol(Symbol.X);
            else if (symbolAtt.getValue().matches("[OoОо0]"))
                player.setSymbol(Symbol.O);
        }
        return player;
    }
}