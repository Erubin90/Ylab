package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Menu;
import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.enums.Directory;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.parsers.Parser;
import io.ylab.ticTacToeGame.parsers.gameParsers.GameParser;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class GameBuilder {
    private static Parser<Game> PARSER;

    private static final File DIRECTORY = new File(Directory.HISTORY_GAME.getPath());

    public static Game createGame() {
        TypeGame typeGame = Menu.playWithBot();
        switch (typeGame) {
            case PLAYER_PLAYER:
            case BOT_PLAYER:
                return new PersonGame(typeGame);
            case SIMULATION:
                while (true) {
                    try {
                        File file = selectFileForSimulation();
                        return PARSER.read(file);
                    }
                    catch (IOException e) {
                        Message.printErrorFile();
                        e.printStackTrace();
                    }
                }
            default:
                throw new IllegalArgumentException("Не правильный тип игры:" + typeGame);
        }
    }

    private static File selectFileForSimulation() {
        FileFormat format = Menu.chooseFormatFile();
        PARSER = new GameParser(format);
        return Menu.selectFileForSimulation(DIRECTORY, format);
    }
}
