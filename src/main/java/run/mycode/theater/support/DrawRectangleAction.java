package run.mycode.theater.support;

import org.code.media.Color;

import java.awt.*;

public class DrawRectangleAction implements SceneAction {
    public DrawRectangleAction(int x, int y, int width, int height, Color strokeColor, Color fillColor,
                               double strokeWidth) {
        // TODO: Draw Rectangle
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
