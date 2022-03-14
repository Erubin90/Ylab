package io.ylab.ticTacToeGame.game;

import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.parser.XMLToSimulationGameParser;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameBuilder {

    private static final File DIRECTORY = new File("src/main/java/io/ylab/ticTacToeGame/simulationGame/");

    private static XMLToSimulationGameParser parser;

    public static Game createGame(Scanner scan) {
        TypeGame typeGame = null;
        boolean flag = true;
        Message.printPlayWithBot();
        while (flag) {
            String answer = scan.nextLine();
            switch (answer) {
                //человек против человека
                case "1":
                    Message.printSeparator("-", 30);
                    typeGame = TypeGame.PLAYER_PLAYER;
                    flag = false;
                    break;
                //человек против бота
                case "2":
                    Message.printSeparator("-", 30);
                    typeGame = TypeGame.BOT_PLAYER;
                    flag = false;
                    break;
                //симуляция
                case "3":
                    Message.printSeparator("-", 30);
                    typeGame = TypeGame.SIMULATION;
                    flag = false;
                    break;
                default:
                    Message.printErrorAnswer();
            }
        }

        switch (typeGame) {
            case PLAYER_PLAYER:
            case BOT_PLAYER:
                return new PersonGame(scan, typeGame);
            case SIMULATION:
                while (true) {
                    try {
                        File file = selectFileForSimulation(scan);
                        parser = new XMLToSimulationGameParser(file);
                        return parser.read();
                    }
                    catch (IOException e) {
                        Message.printErrorFile();
                    }
                }
            default:
                throw new IllegalArgumentException("Не правильный тип игры:" + typeGame);
        }
    }

    private static File selectFileForSimulation(Scanner scan) {
        Message.printSelectFileForSimulation();
        FileFilter filter = (pathname) -> pathname.getName().matches(".*\\.xml");
        File[] files = DIRECTORY.listFiles(filter);
        List<File> XMLFiles = null;
        if (files != null && files.length > 0) {
            XMLFiles = Arrays.asList(files);
            Message.printFileList(XMLFiles);
        }
        Message.printDash();
        File file = null;
        boolean flag = true;

        //Выбор пользователем файла для симуляции
        while (flag) {
            String name = scan.nextLine();
            if (name.matches("\\d+")) {
                int index = Integer.parseInt(name);
                if (XMLFiles != null && index <= XMLFiles.size() && index > 0) {
                    file = XMLFiles.get(index - 1);
                    flag = false;
                }
                else
                    Message.printErrorAnswer();
            }
            else if (name.matches(".+/.+\\.xml")) {
                file = new File(name);
                flag = false;
            }
            else {
                Message.printErrorAnswer();
            }
        }
        return file;
    }
}
