package io.ylab.ticTacToeGame.objects.game;

import io.ylab.ticTacToeGame.objects.Menu;
import io.ylab.ticTacToeGame.objects.players.Bot;
import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.Step;
import io.ylab.ticTacToeGame.objects.enums.*;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.repositories.PlayerLocalStorageRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonGame extends AbstractGame{

    private final PlayerLocalStorageRepository storage;

    public PersonGame(TypeGame typeGame) {
        super();
        this.typeGame = typeGame;
        this.scope = new HashMap<>();
        this.players = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.storage = new PlayerLocalStorageRepository();
    }

    //Метод в котором прописана логика игры
    @Override
    public void play() {
        Message.printScreensaver();
        configuration();
        Message.printGameRules(countPattern);
        game();
        end();
    }

    @Override
    public void newRound() {
        this.matrix = new char[3][3];
        this.steps = new ArrayList<>();
    }

    /*
    Конфигурация игры:
    - создание игроков
    - выбор какой игрок будет Х, а какой О
     */
    private void configuration() {
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
        Button button = Menu.playerSetSymbol(player1, player2);
        switch (button) {
            //player1 будет Х
            case ONE:
                fillPlayersAndScope(player1, player2);
                break;
            //player2 будет Х
            case TWO:
                fillPlayersAndScope(player2, player1);
                break;
            //рандомно выберется игрок который будет Х
            case THREE:
                double index = Math.random() - 0.5;
                if (index > 0)
                    fillPlayersAndScope(player1, player2);
                else
                    fillPlayersAndScope(player2, player1);
                break;
        }
    }

    private Player addPlayer(int num) {
        String standardName = "Player " + num;
        Message.printPlayerSetName(standardName);
        String name = Menu.playerSetName();
        return storage.get(name);
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
    Присваивает победителя полю winPlayer.
     */
    private void game() {
        ResultGame resultGame = ResultGame.NEXT_MOVE;

        Message.printStartGame(players);
        Message.printSeparator("-", countPattern);
        int num = 1;
        while (resultGame == ResultGame.NEXT_MOVE) {
            for (Player player : players) {
                if (resultGame == ResultGame.NEXT_MOVE) {
                    Step step = player.move(matrix);
                    step.setNum(num);
                    steps.add(step);
                    int row = step.getRow();
                    int col = step.getCol();
                    char sing = step.getSymbol().getSing();
                    matrix[row][col] = sing;
                    Message.printMatrix(matrix);
                    Message.printSeparator("-", countPattern);
                    resultGame = checkWin(matrix);
                    num++;
                    if (resultGame == ResultGame.WIN) {
                        this.winPlayer = player;
                        break;
                    }
                } else
                    break;
            }
        }
    }

    private void end() {
        if (this.winPlayer != null) {
            this.winPlayer.addPoint();
            String winName = this.winPlayer.getName();
            int point = scope.get(winName);
            scope.put(winName, ++point);
            Message.printWinPlayer(winName);
        }
        else
            Message.printDrawPlayers();
        storage.saveAll(players);
        try {
            saveGame(Directory.HISTORY_GAME, FileFormat.JSON, FileFormat.XML);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Message.printGameScope(scope);
        Message.printSeparator("-", countPattern);
    }
}
