package run.mycode.theater.support;

import org.code.media.Color;
import run.mycode.theater.Stage;

import java.awt.*;

public class DrawPolygonAction implements SceneAction {

    private final java.awt.Color strokeColor;
    private final java.awt.Color fillColor;
    private final float strokeWidth;

    private final Polygon polygon;

    public DrawPolygonAction(int x, int y, int sides, int radius, Color strokeColor, Color fillColor,
                             double strokeWidth) {
        this.strokeColor = Color.convertToAWTColor(strokeColor);
        this.fillColor = Color.convertToAWTColor(fillColor);
        this.strokeWidth = (float)strokeWidth;

        polygon = new Polygon();
        for (int side = 0; side < sides; side++) {
            double angle = (Math.PI/2) + ((2*Math.PI * side) / sides);
            int xp = x + (int)(radius * Math.sin(angle));
            int yp = y + (int)(radius * Math.cos(angle));
            polygon.addPoint(xp, yp);
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
        context.setColor(fillColor);
        context.fillPolygon(polygon);

        context.setStroke(new BasicStroke(strokeWidth));
        context.setColor(strokeColor);
        context.drawPolygon(polygon);
    }
}
