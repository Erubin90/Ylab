package io.ylab.ticTacToeGame.handlers;

import io.ylab.ticTacToeGame.exceptions.InvalidDataException;
import io.ylab.ticTacToeGame.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<Response> handleException(InvalidDataException exception) {
        Response date = new Response(exception.getMessage());
        return new ResponseEntity<>(date, HttpStatus.BAD_REQUEST);
    }
}
