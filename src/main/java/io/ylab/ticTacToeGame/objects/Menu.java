package io.ylab.ticTacToeGame.objects;

import io.ylab.ticTacToeGame.objects.enums.*;
import io.ylab.ticTacToeGame.objects.players.Player;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.List;

public class Menu implements AutoCloseable {

    private static Scanner SCANNER = new Scanner(System.in);

    private static Button getButton() {
        String string = SCANNER.nextLine();
        return Button.getButton(string);
    }

    /*
    Спрашивает у игрока дальнейшие действия после окончания раунда:
     */
    public static ContinueGame isContinueGame() {
        while (true) {
            switch (getButton()) {
                //Сыграть еще один раунд
                case ONE:
                    return ContinueGame.CONTINUE;
                //Создать новую игру
                case TWO:
                    return ContinueGame.NEW_GAME;
                //Закончить игру
                case THREE:
                    return ContinueGame.EXIT;
                default:
                    Message.printErrorAnswer();
            }
        }
    }

    public static TypeGame playWithBot() {
        Message.printPlayWithBot();
        while (true) {
            switch (getButton()) {
                //человек против человека
                case ONE:
                    Message.printSeparator("-", 30);
                    return TypeGame.PLAYER_PLAYER;
                //человек против бота
                case TWO:
                    Message.printSeparator("-", 30);
                    return TypeGame.BOT_PLAYER;
                //симуляция
                case THREE:
                    Message.printSeparator("-", 30);
                    return TypeGame.SIMULATION;
                default:
                    Message.printErrorAnswer();
            }
        }
    }

    public static FileFormat chooseFormatFile() {
        Message.printChooseFormatFile();
        while (true) {
            switch (getButton()) {
                case ONE:
                    return FileFormat.XML;
                case TWO:
                    return FileFormat.JSON;
                default:
                    Message.printErrorAnswer();
            }
        }
    }

    public static File selectFileForSimulation(File directory, FileFormat format) {
        String reg = ".+\\." + format;
        FileFilter filter = (pathname) -> pathname.getName().matches(reg);
        File[] files = directory.listFiles(filter);
        List<File> fileList = null;

        Message.printSelectFileForSimulation();

        if (files != null && files.length > 0) {
            fileList = Arrays.asList(files);
            Message.printFileList(fileList);
        }
        Message.printDash();

        //Выбор пользователем файла для симуляции
        while (true) {
            String name = SCANNER.nextLine();
            if (name.matches("\\d+")) {
                int index = Integer.parseInt(name);
                if (fileList != null && index <= fileList.size() && index > 0) {
                    return fileList.get(index - 1);
                }
                else
                    Message.printErrorAnswer();
            }
            else if (name.matches(".+/.+\\." + format)) {
                return new File(name);
            }
            else
                Message.printErrorAnswer();
        }
    }

    public static Button playerSetSymbol(Player player1, Player player2) {
        Message.printPlayerSetSymbol(player1, player2);
        while (true) {
            Button button = getButton();
            switch (button) {
                case ONE:
                case TWO:
                case THREE:
                    return button;
                default:
                    Message.printErrorAnswer();
            }
        }
    }

    public static String playerSetName() {
        while (true) {
            String name = SCANNER.nextLine();
            if (name != null && !(name.equals("Bot") || name.isEmpty())) {
                return name;
            }
        }
    }

    public static String scanningString() {
        return SCANNER.nextLine();
    }

    @Override
    public void close() throws Exception {
        SCANNER.close();
    }
}
