package io.ylab.ticTacToeGame.objects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileFormat {
    XML("xml"),
    JSON("json");

    private final String format;

    @Override
    public String toString() {
        return format;
    }
}
