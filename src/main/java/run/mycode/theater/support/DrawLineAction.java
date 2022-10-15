package run.mycode.theater.support;

import org.code.media.Color;

import java.awt.*;

public class DrawLineAction implements SceneAction {
    public DrawLineAction(int startX, int startY, int endX, int endY, Color color, double strokeWidth) {
        // TODO: Draw line
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     */
    @Override
    public void go(Graphics2D context) {
        throw new UnsupportedOperationException(this.getClass().getName() + " not implemented");
    }
}
