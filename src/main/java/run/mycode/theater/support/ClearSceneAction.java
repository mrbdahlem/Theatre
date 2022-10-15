package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public class ClearSceneAction implements SceneAction {
    private final Color color;

    public ClearSceneAction(Color color) {
        if (color == null) {
            this.color = Color.BLACK;
        }
        else {
            this.color = color;
        }
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        Rectangle bounds = context.getDeviceConfiguration().getBounds();

        context.setBackground(color);
        context.clearRect(0, 0, bounds.width, bounds.height);
    }
}
