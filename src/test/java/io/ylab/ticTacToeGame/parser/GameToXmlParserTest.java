package io.ylab.ticTacToeGame.parser;

import io.ylab.ticTacToeGame.objects.game.Game;
import io.ylab.ticTacToeGame.objects.game.SimulationGame;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.objects.players.Simulation;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser.GameToXMLParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameToXmlParserTest {

    GameToXMLParser parser = new GameToXMLParser();

    @Test
    void write() {
        List<Player> players = new ArrayList<>();
        Player egor = new Simulation("EGOR");
        egor.setSymbol(Symbol.X);
        Player ruslan = new Simulation("RUSLAN");
        ruslan.setSymbol(Symbol.O);
        players.add(egor);
        players.add(ruslan);

        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = i * 3 + j + 1;
                Player player = num % 2 == 0 ? egor : ruslan;
                Step step = new Step(i, j, player);
                step.setNum(num);
                steps.add(step);
            }
        }
        Game game = new SimulationGame(players, steps);
        game.setWinPlayer(ruslan);
        parser.write(game);
    }
}