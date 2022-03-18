package io.ylab.ticTacToeGame.objects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Directory {
    HISTORY_GAME("src/main/java/io/ylab/ticTacToeGame/historyGames/");

    private final String path;
}
