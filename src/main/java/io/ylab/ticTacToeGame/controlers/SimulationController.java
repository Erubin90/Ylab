package io.ylab.ticTacToeGame.controlers;

import io.ylab.ticTacToeGame.exceptions.InvalidDataException;
import io.ylab.ticTacToeGame.model.Response;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.parsers.gameParsers.GameParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/simulation/play")
class SimulationController {

    @PostMapping(value = "/file")
    public Response processFile(@RequestBody MultipartFile answer) throws Exception {
        var fileName = answer.getOriginalFilename();
        if (fileName != null) {
            int index = fileName.lastIndexOf(".");
            var format = fileName.substring(++index);
            var fileFormat = FileFormat.getFileFormat(format);
            GameParser parser;
            switch (fileFormat) {
                case JSON:
                case XML:
                    parser = new GameParser(fileFormat);
                    break;
                default:
                    throw new InvalidDataException("Формат файла '" + format + "' не поддерживается");
            }
            String file;
            try {
                file = new String(answer.getInputStream().readAllBytes());
            } catch (IOException e) {
                throw new InvalidDataException("Не получилось прочитать файл");
            }
            try {
                var game = parser.read(file);
                game.play();
            } catch (IOException e) {
                throw new InvalidDataException("Содержимое файла не соответствует шаблону");
            }
        }
        else {
            throw new InvalidDataException("Тело не содержит файла");
        }
        return new Response("Игра воспроизвелась");
    }
}
