package io.ylab.ticTacToeGame.controlers;

import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.parsers.gameParsers.GameParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/simulation/play")
class SimulationController {

    @PostMapping("/file")
    public String processFile(@RequestBody MultipartFile answer) {
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
                    return "Формат файла \""+ format +"\" не поддерживается";
            }
            String file;
            try {
                file = new String(answer.getInputStream().readAllBytes());
            } catch (IOException e) {
                return "Не получилось прочитать файл";
            }
            try {
                var game = parser.read(file);
                game.play();
            } catch (IOException e) {
                return "Содержимое файла не соответствует шаблону";
            }
        }
        else {
            return "Тело не содержит файла";
        }
        return "Игра воспроизвелась";
    }
}
