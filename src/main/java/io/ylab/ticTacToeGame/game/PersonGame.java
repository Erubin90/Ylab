package io.ylab.ticTacToeGame.game;

import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.Bot;
import io.ylab.ticTacToeGame.objects.enums.ContinueGame;
import io.ylab.ticTacToeGame.objects.enums.ResultGame;
import io.ylab.ticTacToeGame.objects.enums.Symbol;
import io.ylab.ticTacToeGame.objects.enums.TypeGame;
import io.ylab.ticTacToeGame.repositories.PlayerLocalStorageRepository;

import java.util.*;

public class PersonGame extends Game {

    private final PlayerLocalStorageRepository storage;

    public PersonGame(Scanner scan, TypeGame typeGame) {
        super();
        this.scan = scan;
        this.typeGame = typeGame;
        this.scope = new HashMap<>();
        this.players = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.storage = new PlayerLocalStorageRepository();
    }

    //Метод в котором прописана логика игры
    @Override
    public ContinueGame play() {
        ContinueGame playGame = ContinueGame.CONTINUE;
        Message.printScreensaver();
        configuration();
        Message.printGameRules(countPattern);
        while (playGame == ContinueGame.CONTINUE) {
            Player winPlayer = game();
            playGame = end(winPlayer);
        }
        return playGame;
    }

    /*
    Конфигурация игры:
    - создание игроков
    - выбор какой игрок будет Х, а какой О
     */
    private void configuration() {
        boolean flag = true;
        Player player1;
        Player player2;
        
        //Создание игроков
        //человек против человека
        if (typeGame == TypeGame.PLAYER_PLAYER) {
            player1 = addPlayer(1);
            player2 = addPlayer(2);
        }
        //человек против бота
        else {
            player1 = addPlayer(1);
            player2 = addBot();
        }
        Message.printSeparator("-", countPattern);

        //Выбор какой игрок будет Х, а какой О
        Message.printPlayerSetSymbol(player1, player2);
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
            int num = 1;
            for (Player player : players) {
                if (resultGame == ResultGame.NEXT_MOVE) {
                    Step step = player.move(scan, matrix);
                    step.setNum(num);
                    step.setPlayer(player);
                    int row = step.getRow();
                    int col = step.getCol();
                    char sing = step.getSymbol().getSing();
                    matrix[row][col] = sing;
                    Message.printMatrix(matrix);
                    Message.printSeparator("-", countPattern);
                    resultGame = checkWin(matrix);
                    num++;
                    if (resultGame == ResultGame.WIN) {
                        winPlayer = player;
                        break;
                    }
                } else
                    break;
            }
        }
        return winPlayer;
    }

    private ContinueGame end(Player winPlayer) {
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
        Message.printContinuePersonGame();
        return this.isContinueGame(scan);
    }
}
