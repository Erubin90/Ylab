package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.game.SimulationGame;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLToSimulationGameParserTest {

    XMLToSimulationGameParser parser = new XMLToSimulationGameParser();

    XMLToSimulationGameParserTest(){
    }

    @Test
    void parsePlayers() throws FileNotFoundException {
        parser.setFile(new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/testSimulation.xml"));
        SimulationGame simulationList = parser.read();
        System.out.println(simulationList);

    }
}