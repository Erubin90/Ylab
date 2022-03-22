package io.ylab.ticTacToeGame.objects.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Button {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),

    UNKNOWN(Strings.EMPTY);

    private final String name;

    private static final Map<String, Button> MAP_BUTTON = Arrays.stream(Button.values())
            .collect(Collectors.toMap(Button::getName, Function.identity()));

    public static Button getButton(String string) {
        return Optional.ofNullable(MAP_BUTTON.get(string)).orElse(UNKNOWN);
    }
}