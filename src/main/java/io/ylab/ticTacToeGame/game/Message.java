package io.ylab.ticTacToeGame.game;

import io.ylab.ticTacToeGame.objects.Move;
import io.ylab.ticTacToeGame.objects.Player;

import java.util.List;
import java.util.Map;

public class Message {

    private final static String dash = "-> ";

    public static void printScreensaver() {
        System.out.println("Крестики нолики");
    }

    public static void printPlayWithBot() {
        System.out.println("Играть с другом или ботом?:\n" +
                "1 - играть с другом\n" +
                "2 - играть с ботом");
        System.out.print(dash);
    }

    public static void printErrorAnswer() {
        System.out.println("Я не предоставлял такой вариант");
        System.out.print(dash);
    }

    public static void printPlayerSetName(String name) {
        System.out.println("Введите ник " + name);
        System.out.print(dash);
    }

    public static void printErrorSetName() {
        System.out.println("Некорректное имя");
    }

    public static void printPlayerSetSymbol(Player p1, Player p2) {
        System.out.println("Кто выберет X:\n" +
                "1 - " + p1.getName() + " X\n" +
                "2 - " + p2.getName() + " X\n" +
                "3 - Рандомно распределить");
        System.out.print(dash);
    }

    public static void printStartGame(List<Player> playerList) {
        Player p1 = playerList.get(0);
        Player p2 = playerList.get(1);
        System.out.println(p1.getName() + " - " + p1.getSymbol());
        System.out.println(p2.getName() + " - " + p2.getSymbol());
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                char simbol = aChar;
                if (simbol == 0)
                    simbol = '-';
                System.out.print("| " + simbol + ' ');
            }
            System.out.println('|');
        }
    }

    public static void printGameRules(int count) {
        count /= 2;
        printSeparator("/\\", count);
        System.out.println("Правило ввода.\n" +
                "На ввод принимается 2 числа:\n" +
                "- первое число ряда,\n" +
                "- второе число столбца\n" +
                "Отсчет ряда и столбца начинается с 1");
        printSeparator("/\\", count);
        System.out.println();
    }

    public static void printPersonMove(String name) {
        System.out.print(name + dash);
    }

    public static void printBotMove(String name, Move move) {
        System.out.println(name + dash + (move.getRow() + 1) + (move.getCol() + 1));
    }

    public static void printErrorMove() {
        System.out.println("Неверный ход");
    }

    public static void printWinPlayer(String name) {
        System.out.println("Выиграл игрок " + name);
    }

    public static void printDrawPlayers() {
        System.out.println("Ничья");
    }

    public static void printGameScope(Map<String, Integer> scope) {
        for (var map : scope.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }

    public static void printContinuePlay() {
        System.out.println("Повторим?\n" +
                "1. Да, повторим\n" +
                "2. Выйти из игры");
        System.out.print(dash);
    }

    public static void printSeparator(String pattern, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }
}
