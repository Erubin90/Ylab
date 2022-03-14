package io.ylab.ticTacToeGame.exceptions;

import java.io.IOException;

public class StepNoCorrectValueException extends IOException {

    public StepNoCorrectValueException() {
    }

    public StepNoCorrectValueException(String message) {
        super(message);
    }

    public StepNoCorrectValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public StepNoCorrectValueException(Throwable cause) {
        super(cause);
    }
}
