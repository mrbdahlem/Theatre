package run.mycode.theater;

import run.mycode.theater.support.SceneAction;

import java.awt.*;
import java.util.List;

public class Prompter {

    private final List<SceneAction> script;
    private final Stage stage;

    private boolean stop = false;
    private boolean hold = false;

    /**
     * Create a prompter to run a show
     * @param script the list of actions to perform for the show
     * @param stage the stage on which the show will be performed
     */
    public Prompter(List<SceneAction> script, Stage stage) {
        this.script = script;
        this.stage = stage;
    }

    /**
     * Begin playing the show
     */
    public void runShow() {
        final Graphics2D context = stage.getGraphicsContext();
        final Thread t = new Thread(()-> {
            for (SceneAction action : script) {
                // Handle a pause
                while (hold) {
                    Thread.yield();
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

    /**
     * Stop running the show
     */
    public void stop() {
        this.stop = true;
    }

    /**
     * Toggle pausing the show
     * @return true if the show is now paused
     */
    public boolean togglePause() {
        this.hold = !this.hold;
        return this.hold;
    }
}
