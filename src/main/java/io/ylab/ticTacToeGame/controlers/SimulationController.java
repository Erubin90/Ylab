package io.ylab.ticTacToeGame.controlers;

import io.ylab.ticTacToeGame.exceptions.StepNoCorrectValueException;
import io.ylab.ticTacToeGame.model.GameAnswer;
import io.ylab.ticTacToeGame.model.GamePlayModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulation/play")
class SimulationController {

    @PostMapping("/json")
    public void processJson(@RequestBody GameAnswer answer) {
        try {
            answer.getGame().play();
        } catch (StepNoCorrectValueException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/xml")
    public void processXml(@RequestBody GamePlayModel answer) {
        try {
            answer.getGame().play();
        } catch (StepNoCorrectValueException e) {
            e.printStackTrace();
        }
    }
}
