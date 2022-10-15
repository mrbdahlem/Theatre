package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public class DrawLineAction implements SceneAction {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final Color color;
    private final float strokeWidth;

    public DrawLineAction(int startX, int startY, int endX, int endY, Color color, double strokeWidth) {
        // TODO: Draw line
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
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
        if (color != null) {
            context.setStroke(new BasicStroke(strokeWidth));
            context.setColor(color);
            context.drawLine(startX, startY, endX, endY);
        }
    }
}
