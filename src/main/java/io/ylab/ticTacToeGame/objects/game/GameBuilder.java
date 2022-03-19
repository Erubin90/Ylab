package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.enums.Directory;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.parsers.gameParsers.XMLParser.XMLToGameParser;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class GameBuilder {
    private static final XMLToGameParser parserReader = new XMLToGameParser();

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
                        return parserReader.read(file);
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
        boolean flag = true;
        FileFormat format = null;
        Message.printChooseFormatFile();
        while (flag) {
            String num = scan.nextLine();
            switch (num) {
                case "1":
                    format = FileFormat.XML;
                    flag = false;
                    break;
                case "2":
                    format = FileFormat.JSON;
                    flag = false;
                    break;
                default:
                    Message.printErrorAnswer();
            }
        }

        String reg = ".+\\." + format;
        Message.printSelectFileForSimulation();
        FileFilter filter = (pathname) -> pathname.getName().matches(reg);
        File directory = new File(Directory.HISTORY_GAME.getPath());
        File[] files = directory.listFiles(filter);
        List<File> XMLFiles = null;
        if (files != null && files.length > 0) {
            XMLFiles = Arrays.asList(files);
            Message.printFileList(XMLFiles);
        }
        Message.printDash();
        File file = null;
        flag = true;

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
            else if (name.matches(".+/.+\\." + format)) {
                file = new File(name);
                flag = false;
            }
            else
                Message.printErrorAnswer();
        }
        return file;
    }
}
