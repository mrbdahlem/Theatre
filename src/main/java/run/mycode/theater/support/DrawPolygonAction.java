package run.mycode.theater.support;

import org.code.media.Color;

import java.awt.*;

public class DrawPolygonAction implements SceneAction {
    public DrawPolygonAction(int x, int y, int sides, int radius, Color strokeColor, Color fillColor,
                             double strokeWidth) {
        // TODO: Draw polygon
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
