package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.objects.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.objects.players.Simulation;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Directory;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser.XMLToGameParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlToGameParserTest {

    private XMLToGameParser parser;

    XmlToGameParserTest(){
        parser = new XMLToGameParser();
    }

    @Test
    void read() {
        var players = new ArrayList<Player>();
        var player1 = new Simulation(1, "Igor", Symbol.X);
        var player2 = new Simulation(2, "Anna", Symbol.O);
        players.add(player1);
        players.add(player2);

        var steps = new ArrayList<Step>();
        steps.add(new Step(1, 1, 1, player1));
        steps.add(new Step(2, 0, 2, player2));
        steps.add(new Step(3, 2, 0, player1));
        steps.add(new Step(4, 0, 0, player2));
        steps.add(new Step(5, 0, 1, player1));
        steps.add(new Step(6, 2, 2, player2));
        steps.add(new Step(7, 1, 2, player1));
        steps.add(new Step(8, 1, 0, player2));
        steps.add(new Step(9, 2, 1, player1));

        Game game = new SimulationGame(players, steps);
        game.setWinPlayer(player1);
        String error;

        Game simulationGame;

        //Файлы testSimulation1 - testSimulation4 имеют корректные данные
        try {
            simulationGame = parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation1." + FileFormat.XML.getFormat()));
            assertEquals(game.getInfoForTest(), simulationGame.getInfoForTest());

            simulationGame = parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation2." + FileFormat.XML.getFormat()));
            assertEquals(game.getInfoForTest(), simulationGame.getInfoForTest());

            simulationGame = parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation3." + FileFormat.XML.getFormat()));
            assertEquals(game.getInfoForTest(), simulationGame.getInfoForTest());

            simulationGame = parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation4." + FileFormat.XML.getFormat()));
            assertEquals(game.getInfoForTest(), simulationGame.getInfoForTest());
        }
        catch (IOException e) {

        }

        //Файлы testSimulation5 - testSimulation6 имеют не корректные данные
        try {
            parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation5." + FileFormat.XML.getFormat()));
        }
        catch (IOException ex) {
            error = "The current move value should not be greater than MaxValue. maxValue - 25, move - 31";
            assertEquals(error, ex.getMessage());
        }

        try {
            parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation6." + FileFormat.XML.getFormat()));
        }
        catch (IOException ex) {
            error = "The current move value should not be greater than MaxValue. maxValue - 25, move - 31";
            assertEquals(error, ex.getMessage());
        }

        int sizeMatrix = 5;
        steps = new ArrayList<Step>();
        int i = 1;
        for (int row = 0; row < sizeMatrix; row++) {
            for (int col = 0; col < sizeMatrix; col++) {
                var p = i % 2 == 1 ? player1 : player2;
                steps.add(new Step(i, row, col, p));
                i++;
            }
        }

        game = new SimulationGame(players, steps, sizeMatrix);
        game.setWinPlayer(player1);
        try {
            simulationGame = parser.read(new File(Directory.HISTORY_GAME.getPath() + "testSimulation7." + FileFormat.XML.getFormat()));
            assertEquals(game.getInfoForTest(), simulationGame.getInfoForTest());
        }
        catch (IOException e) {
        }

    }
}