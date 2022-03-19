package io.ylab.ticTacToeGame.parsers.adapters;

import io.ylab.ticTacToeGame.objects.Step;

import java.io.IOException;
import java.util.List;

public interface StepAdapter {

    void addStep(String num, String playerId, String move);

    List<Step> getStepList() throws IOException;

    int getSizeMatrix();
}
