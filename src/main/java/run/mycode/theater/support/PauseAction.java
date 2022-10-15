package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public class PauseAction implements SceneAction {
    private final double seconds;

    public PauseAction(double seconds) {
        this.seconds = seconds;
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        stage.updateStage();
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
