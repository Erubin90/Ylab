package io.ylab.ticTacToeGame.objects.players;

import io.ylab.ticTacToeGame.objects.Menu;
import io.ylab.ticTacToeGame.objects.Message;
import io.ylab.ticTacToeGame.objects.Step;

public class Person extends AbstractPlayer {

    public Person(String name) {
        super(name);
    }

    public Person(String name, int point) {
        super(name, point);
    }

    @Override
    public Step move(char[][] matrix) {
        int row;
        int col;
        while (true) {
            Message.printPersonMove(name);
            String stringMove = Menu.scanningString();
            if (stringMove.matches("[123]{2}")) {
                String[] nums = stringMove.split("");
                row = Integer.parseInt(nums[0]) - 1;
                col = Integer.parseInt(nums[1]) - 1;
                char c = matrix[row][col];
                if (c == 0)
                    return new Step(row, col, this);
                else
                    Message.printErrorMove();
            }
            else
                Message.printErrorMove();
        }
    }
}
