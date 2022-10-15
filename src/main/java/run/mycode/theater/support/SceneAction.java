package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public interface SceneAction {
    /**
     * Perform the SceneAction
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    public void go(Graphics2D context, Stage stage);
}
