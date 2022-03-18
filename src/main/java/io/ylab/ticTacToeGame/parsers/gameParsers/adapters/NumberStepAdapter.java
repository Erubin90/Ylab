package io.ylab.ticTacToeGame.parsers.gameParsers.adapters;

import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.objects.Player;
import io.ylab.ticTacToeGame.objects.Step;

import java.util.ArrayList;
import java.util.List;

/*
 * Распознает 2 типа записей:
 * 1. Индекс - тип записи шага в которой шаг представляется в виде индекса массива или списка
 * 2. Координаты - тип записи шага в которой шаг представляется в виде двух чисел и первое число это строка, второе число колонка
 */
public class NumberStepAdapter implements StepAdapter {
    private final List<List<String>> listStringStep;

    private final List<Player> players;

    private boolean isCoordinateTable;

    private int sizeMatrix;

    private boolean isBeginsWithZero;

    public NumberStepAdapter(List<Player> players) {
        this.listStringStep = new ArrayList<>();
        this.players = players;
    }

    @Override
    public void addStep(String num, String playerId, String move) {
        this.isCoordinateTable = move.matches("\\d+\\D+\\d+");

        if (this.isCoordinateTable) {
            String[] rowCol = move.split("\\D+");
            int row = Integer.parseInt(rowCol[0]);
            int col = Integer.parseInt(rowCol[rowCol.length - 1]);
            this.sizeMatrix = Math.max(Math.max(row, col), this.sizeMatrix);
        }
        else {
            int intMove = Integer.parseInt(move);
            this.sizeMatrix = Math.max((int) Math.sqrt(intMove), sizeMatrix);
        }

        //Определяет начинается отчет с 0
        if(move.matches("0.*"))
            this.isBeginsWithZero = true;

        this.listStringStep.add(List.of(num, playerId, move));
    }

    @Override
    public List<Step> getStepList() throws StepNoCorrectValueException {
        List<Step> steps = new ArrayList<>();
        int row;
        int col;

        if (this.isBeginsWithZero)
            this.sizeMatrix++;

        int maxValue = sizeMatrix * sizeMatrix;

        for (var stringStep : this.listStringStep) {
            Step step = new Step();

            int num = Integer.parseInt(stringStep.get(0));
            step.setNum(num);

            String playerId = stringStep.get(1);
            Player player = getPlayerById(playerId);
            step.setPlayer(player);

            String move = stringStep.get(2);

            if (this.isCoordinateTable) {
                String[] rowCol = move.split("\\D+");
                row = Integer.parseInt(rowCol[0]);
                col = Integer.parseInt(rowCol[rowCol.length - 1]);
                if (!this.isBeginsWithZero) {
                    row--;
                    col--;
                }
            }
            else {
                int index = Integer.parseInt(move);
                if (index <= maxValue) {
                    if (!this.isBeginsWithZero)
                        index--;
                    row = index / sizeMatrix;
                    col = index - row * sizeMatrix;
                }
                else {
                    throw new StepNoCorrectValueException("The current move value should not be greater than MaxValue. maxValue - "
                            + maxValue + ", move - " + index);
                }
            }
            step.setRow(row);
            step.setCol(col);
            steps.add(step);
        }
        return steps;
    }

    @Override
    public int getSizeMatrix() {
        return  this.sizeMatrix;
    }

    private Player getPlayerById(String playerId) {
        int id = Integer.parseInt(playerId);
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        return p1.getId() == id ? p1 : p2;
    }
}
