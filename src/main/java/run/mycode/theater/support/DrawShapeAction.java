package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;

public class DrawShapeAction implements SceneAction {
    private final boolean close;
    private final Color strokeColor;
    private final Color fillColor;
    private final float strokeWidth;
    private final int[] xPoints;
    private final int[] yPoints;

    public DrawShapeAction(int[] points, boolean close, Color strokeColor, Color fillColor, double strokeWidth) {
        if (points.length % 2 != 0 || points.length < 4) {
            throw new RuntimeException("INVALID SHAPE");
        }

        int numPoints = points.length / 2;
        xPoints = new int[numPoints];
        yPoints = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xPoints[i] = points[i * 2];
            yPoints[i] = points[(i * 2) + 1];
        }

        this.close = close;
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
        context.setStroke(new BasicStroke(strokeWidth));
        if (close) {
            if (fillColor != null) {
                context.setColor(fillColor);
                context.fillPolygon(xPoints, yPoints, xPoints.length);
            }
            if (strokeColor != null) {
                context.setColor(strokeColor);
                context.drawPolygon(xPoints, yPoints, xPoints.length);
            }
        }
        else {
            if (strokeColor != null) {
                context.setColor(strokeColor);
                context.drawPolyline(xPoints, yPoints, xPoints.length);
            }
        }
    }
}
