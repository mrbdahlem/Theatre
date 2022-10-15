package run.mycode.theater;

import run.mycode.theater.support.SceneAction;

import java.awt.*;
import java.util.List;

public class Prompter {

    private List<SceneAction> script;
    private Stage stage;

    public Prompter(List<SceneAction> script, Stage stage) {
        this.script = script;
        this.stage = stage;
    }

    public void runShow() {
        Graphics2D context = stage.getGraphicsContext();
        for (SceneAction action : script) {
            action.go(context);
        }
        context.dispose();
    }
}
