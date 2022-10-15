package run.mycode.theater.support;

import org.code.media.Color;
import run.mycode.theater.Stage;

import java.awt.*;

public class DrawShapeAction implements SceneAction {
    public DrawShapeAction(int[] points, boolean close, Color strokeColor, Color fillColor, double strokeWidth) {
        // TODO: Draw shape
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        throw new UnsupportedOperationException(this.getClass().getName() + " not implemented");
    }
}
