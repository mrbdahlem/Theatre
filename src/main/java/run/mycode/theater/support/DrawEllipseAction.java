package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public class DrawEllipseAction implements SceneAction {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color strokeColor;
    private final Color fillColor;
    private final float strokeWidth;

    public DrawEllipseAction(int x, int y, int width, int height, Color strokeColor, Color fillColor,
                             double strokeWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.strokeWidth = (float)strokeWidth;
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        if (fillColor != null) {
            context.setColor(fillColor);
            context.fillOval(x, y, width, height);
        }

        if (strokeColor != null) {
            context.setStroke(new BasicStroke(strokeWidth));
            context.setColor(strokeColor);
            context.drawOval(x, y, width, height);
        }
    }
}
