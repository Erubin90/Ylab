package io.ylab.lesson2.ticTacToeGame.objects;

import io.ylab.lesson2.ticTacToeGame.game.Message;

import java.util.Scanner;

public class Person extends Player {

    public Person() {
        super();
    }

    public Person(String name) {
        super(name);
    }

    public Person(String name, int point) {
        super(name, point);
    }

    @Override
    public Move move(Scanner scanner, char[][] matrix) {
        int row;
        int col;
        while (true) {
            Message.printPersonMove(name);
            String stringMove = scanner.nextLine();
            if (stringMove.matches("[123]{2}")) {
                String[] nums = stringMove.split("");
                row = Integer.parseInt(nums[0]) - 1;
                col = Integer.parseInt(nums[1]) - 1;
                char c = matrix[row][col];
                if (c == 0)
                    return new Move(row, col, symbol);
                else
                    Message.printErrorMove();
            }
            else
                Message.printErrorMove();
        }
    }
}
