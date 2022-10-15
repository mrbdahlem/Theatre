package run.mycode.theater.support;

import java.awt.*;

public interface SceneAction {
    /**
     * Perform the SceneAction
     * @param context the graphics context upon which to perform the action
     */
    public void go(Graphics2D context);
}
