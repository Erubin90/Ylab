package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Simulation;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.tools.Checker;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLToSimulationGameParser {

    protected static final XMLInputFactory INPUT_FACTORY = XMLInputFactory.newInstance();

    protected File file;

    public XMLToSimulationGameParser() {
    }

    public XMLToSimulationGameParser(File file) {
        Checker.checkFile(file);
        this.file = file;
    }

    public void setFile(File file) {
        Checker.checkFile(file);
        this.file = file;
    }

    public SimulationGame read() throws FileNotFoundException{
        Player player;
        Step step;
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
                            step = new Step();
                            String numAtt = startElement
                                    .getAttributeByName(new QName("num"))
                                    .getValue();
                            String playerIdAtt = startElement
                                    .getAttributeByName(new QName("playerId"))
                                    .getValue();
                            xmlEvent = reader.nextEvent();
                            var move = xmlEvent.asCharacters().toString();
                            if (numAtt != null)
                                step.setNum(Integer.parseInt(numAtt));
                            if (playerIdAtt != null) {
                                int playerId = Integer.parseInt(playerIdAtt);
                                player = getPlayerById(players, playerId);
                                step.setPlayer(player);
                            }
                            if (move != null) {
                                if (move.matches("\\d")) {
                                    int intMove = Integer.parseInt(move);
                                    intMove--;
                                    int row = intMove / 3;
                                    int col = intMove - row * 3;
                                    step.setRow(row);
                                    step.setCol(col);
                                } else if (move.matches("\\d{2}")) {
                                    String[] rowCol = move.split("");
                                    int row = Integer.parseInt(rowCol[0]);
                                    int col = Integer.parseInt(rowCol[1]);
                                    step.setRow(row);
                                    step.setCol(col);
                                } else if (move.matches("\\d[|\\\\/;:,.\t ]+\\d")) {
                                    String[] rowCol = move.split("[|\\\\/;:,.\t ]");
                                    int row = Integer.parseInt(rowCol[0]);
                                    int col = Integer.parseInt(rowCol[1]);
                                    step.setRow(row);
                                    step.setCol(col);
                                }
                            }
                            steps.add(step);
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
            }
            reader.close();
        }
        catch (XMLStreamException exc) {
            exc.printStackTrace();
        }

        return new SimulationGame(players, steps);
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

    private Player getPlayerById(List<Player> players, int id) {
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        return p1.getId() == id ? p1 : p2;
    }
}