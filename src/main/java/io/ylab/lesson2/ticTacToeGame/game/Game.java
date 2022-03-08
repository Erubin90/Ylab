package io.ylab.lesson2.ticTacToeGame.game;

import io.ylab.lesson2.ticTacToeGame.objects.Move;
import io.ylab.lesson2.ticTacToeGame.objects.Player;
import io.ylab.lesson2.ticTacToeGame.objects.Bot;
import io.ylab.lesson2.ticTacToeGame.repositories.PlayerLocalStorageRepository;

import java.util.*;

public class Game {

    private final List<Player> players;

    private final Map<String, Integer> scope;

    private char[][] matrix;

    private final Scanner scan;

    private final PlayerLocalStorageRepository storage;

    private final int countPattern = 30;

    public Game() {
        this.players = new ArrayList<>(2);
        this.scope = new HashMap<>();
        this.matrix = new char[3][3];
        this.scan = new Scanner(System.in);
        this.storage = new PlayerLocalStorageRepository();
    }

    //Метод в котором прописана логика игры
    public void play() {
        boolean playGame = true;
        Message.printScreensaver();
        start();
        Message.printGameRules(countPattern);
        while (playGame) {
            Player winPlayer = game();
            playGame = end(winPlayer);
        }
    }

    /*
    Конфигурация игры:
    - создание игроков
    - выбор какой игрок будет Х, а какой О
    
     */
    private void start() {
        boolean flag = true;
        Player player1 = null;
        Player player2 = null;
        
        //Создание игроков
        Message.printPlayWithBot();
        while (flag) {
            String answer = scan.nextLine();
            switch (answer) {
                //человек против человека
                case "1":
                    player1 = addPlayer(1);
                    player2 = addPlayer(2);
                    flag = false;
                    break;
                //человек против бота
                case "2":
                    player1 = addPlayer(1);
                    player2 = addBot();
                    flag = false;
                    break;
                default:
                    Message.printErrorAnswer();
            }
        }
        Message.printSeparator("-", countPattern);
        //Выбор какой игрок будет Х, а какой О
        Message.printPlayerSetSymbol(player1, player2);
        flag = true;
        while (flag) {
            String answer = scan.nextLine();
            switch (answer) {
                //player1 будет Х
                case "1":
                    fillPlayersAndScope(player1, player2);
                    flag = false;
                    break;
                //player2 будет Х
                case "2":
                    fillPlayersAndScope(player2, player1);
                    flag = false;
                    break;
                //рандомно выберется игрок который будет Х
                case "3":
                    double index = Math.random() - 0.5;
                    if (index > 0)
                        fillPlayersAndScope(player1, player2);
                    else
                        fillPlayersAndScope(player2, player1);
                    flag = false;
                    break;
                default:
                    Message.printErrorAnswer();
            }
        }
    }

    private Player addPlayer(int num) {
        String standardName = "Player " + num;
        Message.printPlayerSetName(standardName);
        Player player;
        while (true) {
            String name = scan.nextLine().replace("\t", "");
            if (name.isEmpty() || name.equals("Bot")) {
                Message.printErrorSetName();
            }
            else {
                player = storage.get(name);
                break;
            }
        }
        return player;
    }

    private Bot addBot() {
        Player player = storage.get("Bot");
        return new Bot(player);
    }

    private void fillPlayersAndScope(Player x, Player o) {
        x.setSymbol(Symbol.X);
        o.setSymbol(Symbol.O);
        players.add(x);
        players.add(o);

        scope.put(x.getName(), 0);
        scope.put(o.getName(), 0);
    }
    
    /*
    Возвращает победителя.
    Если ничья возвращает null
     */
    private Player game() {
        ResultGame resultGame = ResultGame.NEXT_MOVE;
        Player winPlayer = null;

        Message.printStartGame(players);
        Message.printSeparator("-", countPattern);

        while (resultGame == ResultGame.NEXT_MOVE) {
            for (Player player : players) {
                if (resultGame == ResultGame.NEXT_MOVE) {
                    Move move = player.move(scan, matrix);
                    int row = move.getRow();
                    int col = move.getCol();
                    char sing = move.getSymbol().getSing();
                    matrix[row][col] = sing;
                    Message.printMatrix(matrix);
                    Message.printSeparator("-", countPattern);
                    resultGame = checkWin(matrix);
                    if (resultGame == ResultGame.WIN) {
                        winPlayer = player;
                        break;
                    }
                }
                else
                    break;
            }
        }
        return winPlayer;
    }

    public static ResultGame checkWin(char[][] matrix) {
        ResultGame resultGame = ResultGame.NEXT_MOVE;
        int numberEmptyCells = 0;

        //Проверка по столбцам и по столбцам и строкам на победу Х или О
        for (int i = 0; i < matrix.length; i++) {

            //проверка по строке
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                if (matrix[i][0] != 0) {
                    resultGame = ResultGame.WIN;
                    Symbol symbol = Symbol.getSymbol(matrix[i][0]);
                    resultGame.setSymbol(symbol);
                    return resultGame;
                }
            }

            //проверка по столбцу
            if ((matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i])) {
                if (matrix[0][i] != 0) {
                    resultGame = ResultGame.WIN;
                    Symbol symbol = Symbol.getSymbol(matrix[0][i]);
                    resultGame.setSymbol(symbol);
                    return resultGame;
                }
            }

            //подсчет пустых ячеек
            for (char c : matrix[i]) {
                if (c == 0)
                    numberEmptyCells++;
            }
        }

        //Проверка по диагоналям на победу Х или О
        if ((matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) ||
                (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]))
            if (matrix[1][1] != 0) {
                resultGame = ResultGame.WIN;
                Symbol symbol = Symbol.getSymbol(matrix[1][1]);
                resultGame.setSymbol(symbol);
                return resultGame;
            }

        //Проверка на ничью
        if (numberEmptyCells == 0)
            resultGame = ResultGame.DRAW;

        return resultGame;
    }

    private boolean end(Player winPlayer) {
        boolean correctInput = false;
        boolean continueGame = false;
        if (winPlayer != null) {
            winPlayer.addPoint();
            String winName = winPlayer.getName();
            int point = scope.get(winName);
            scope.put(winName, ++point);
            Message.printWinPlayer(winName);
        }
        else
            Message.printDrawPlayers();
        storage.saveAll(players);
        Message.printGameScope(scope);
        Message.printSeparator("-", countPattern);
        Message.printContinuePlay();
        while (!correctInput) {
            String answer = scan.nextLine();
            switch (answer) {
                //с сыграть по новой
                case "1":
                    continueGame = true;
                    correctInput = true;
                    matrix = new char[3][3];
                    break;
                //закончить игру
                case "2":
                    correctInput = true;
                    scan.close();
                    break;
                default:
                    Message.printErrorAnswer();
            }
        }
        return continueGame;
    }
}
