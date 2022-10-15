package run.mycode.theater.support;

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
     */
    @Override
    public void go(Graphics2D context) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
