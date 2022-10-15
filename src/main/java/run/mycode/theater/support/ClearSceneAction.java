package run.mycode.theater.support;

import org.code.media.Color;

import java.awt.*;

public class ClearSceneAction implements SceneAction {
    private final java.awt.Color color;

    public ClearSceneAction(Color color) {
        this.color = Color.convertToAWTColor(color);
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     */
    @Override
    public void go(Graphics2D context) {
        Rectangle bounds = context.getDeviceConfiguration().getBounds();

        context.setColor(color);
        context.fillRect(0, 0, bounds.width, bounds.height);
    }
}
