package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class DrawTextAction implements SceneAction {
    private final String text;
    private final int x;
    private final int y;
    private final double rotation;
    private final Font font;
    private final java.awt.Color textColor;

    public DrawTextAction(String text, int x, int y, double rotation, Font font, Color textColor) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.font = font;
        this.textColor = textColor;
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        AffineTransform originalTransform = context.getTransform();
        if (rotation != 0) {
            context.rotate(Math.toRadians(rotation), x, y);
        }
        context.setFont(font);
        context.setColor(textColor);
        context.drawString(text, x, y);
        if (rotation != 0) {
            // reset to original transform if we rotated
            context.setTransform(originalTransform);
        }
    }
}
