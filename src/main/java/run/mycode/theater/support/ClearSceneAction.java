package run.mycode.theater.support;

import org.code.media.Color;
import run.mycode.theater.Stage;

import java.awt.*;

public class ClearSceneAction implements SceneAction {
    private final java.awt.Color color;

    public ClearSceneAction(Color color) {
        if (color == null) {
            this.color = java.awt.Color.BLACK;
        }
        else {
            this.color = Color.convertToAWTColor(color);
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
