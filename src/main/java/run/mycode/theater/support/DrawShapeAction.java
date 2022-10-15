package run.mycode.theater.support;

import org.code.media.Color;

import java.awt.*;

public class DrawShapeAction implements SceneAction {
    public DrawShapeAction(int[] points, boolean close, Color strokeColor, Color fillColor, double strokeWidth) {
        // TODO: Draw shape
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
