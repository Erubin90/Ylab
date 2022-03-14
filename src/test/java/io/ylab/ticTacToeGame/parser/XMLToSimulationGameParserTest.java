package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.game.SimulationGame;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLToSimulationGameParserTest {

    XMLToSimulationGameParser parser = new XMLToSimulationGameParser();

    XMLToSimulationGameParserTest(){
    }

    @Test
    void read() throws FileNotFoundException {
        String expected = "SimulationGame{" +
                "players=[" +
                "Simulation{id=1, name='Igor', symbol=X, point=0}, " +
                "Simulation{id=2, name='Anna', symbol=O, point=0}, " +
                "Simulation{id=1, name='Igor', symbol=X, point=0}], " +
                "steps=[" +
                "Step{num=1, row=1, col=1}, " +
                "Step{num=2, row=0, col=2}, " +
                "Step{num=3, row=2, col=0}, " +
                "Step{num=4, row=0, col=0}, " +
                "Step{num=5, row=0, col=1}, " +
                "Step{num=6, row=2, col=2}, " +
                "Step{num=7, row=1, col=2}, " +
                "Step{num=8, row=1, col=0}, " +
                "Step{num=9, row=2, col=1}" +
                "]}";
        String error;

        SimulationGame simulationGame;

        //Файлы testSimulation1 - testSimulation4 имеют корректные данные
        try {
            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation1.xml"));
            simulationGame = parser.read();
            assertEquals(expected, simulationGame.getInfoForTest());

            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation2.xml"));
            simulationGame = parser.read();
            assertEquals(expected, simulationGame.getInfoForTest());

            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation3.xml"));
            simulationGame = parser.read();
            assertEquals(expected, simulationGame.getInfoForTest());

            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation4.xml"));
            simulationGame = parser.read();
            assertEquals(expected, simulationGame.getInfoForTest());
        }
        catch (IOException e) {

        }

        //Файлы testSimulation5 - testSimulation6 имеют не корректные данные
        try {
            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation5.xml"));
            simulationGame = parser.read();
        }
        catch (IOException ex) {
            error = "The current move value should not be greater than MaxValue. maxValue - 25, move - 31";
            assertEquals(error, ex.getMessage());
        }

        try {
            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation6.xml"));
            simulationGame = parser.read();
        }
        catch (IOException ex) {
            error = "The current move value should not be greater than MaxValue. maxValue - 25, move - 31";
            assertEquals(error, ex.getMessage());
        }

        expected = "SimulationGame{" +
                "players=[" +
                "Simulation{id=1, name='Igor', symbol=X, point=0}, " +
                "Simulation{id=2, name='Anna', symbol=O, point=0}, " +
                "Simulation{id=1, name='Igor', symbol=X, point=0}], " +
                "steps=[" +
                "Step{num=1, row=0, col=0}, " +
                "Step{num=2, row=0, col=1}, " +
                "Step{num=3, row=0, col=2}, " +
                "Step{num=4, row=0, col=3}, " +
                "Step{num=5, row=0, col=4}, " +
                "Step{num=6, row=1, col=0}, " +
                "Step{num=7, row=1, col=1}, " +
                "Step{num=8, row=1, col=2}, " +
                "Step{num=9, row=1, col=3}, " +
                "Step{num=10, row=1, col=4}, " +
                "Step{num=11, row=2, col=0}, " +
                "Step{num=12, row=2, col=1}, " +
                "Step{num=13, row=2, col=2}, " +
                "Step{num=14, row=2, col=3}, " +
                "Step{num=15, row=2, col=4}, " +
                "Step{num=16, row=3, col=0}, " +
                "Step{num=17, row=3, col=1}, " +
                "Step{num=18, row=3, col=2}, " +
                "Step{num=19, row=3, col=3}, " +
                "Step{num=20, row=3, col=4}, " +
                "Step{num=21, row=4, col=0}, " +
                "Step{num=22, row=4, col=1}, " +
                "Step{num=23, row=4, col=2}, " +
                "Step{num=24, row=4, col=3}, " +
                "Step{num=25, row=4, col=4}]}";

        try {
            parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation7.xml"));
            simulationGame = parser.read();
            assertEquals(expected, simulationGame.getInfoForTest());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}