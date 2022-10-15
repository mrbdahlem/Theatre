package run.mycode.theater;

import run.mycode.theater.support.SceneAction;

import java.awt.*;
import java.util.List;

public class Prompter {

    private final List<SceneAction> script;
    private final Stage stage;

    private boolean stop = false;
    private boolean hold = false;

    public Prompter(List<SceneAction> script, Stage stage) {
        this.script = script;
        this.stage = stage;
    }

    public void runShow() {
        final Graphics2D context = stage.getGraphicsContext();
        final Thread t = new Thread(()-> {
            for (SceneAction action : script) {
                // Handle a pause
                while (hold) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        context.dispose();
                        return;
                    }
                }

                // Handle a stop
                if (stop) {
                    break;
                }
                action.go(context, stage);
            }
            stage.showFinished();
            context.dispose();
        });

        t.start();
    }
}
