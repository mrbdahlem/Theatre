package run.mycode.theater.support;

import org.code.media.Image;
import run.mycode.theater.Stage;

import java.awt.*;

public class DrawImageAction implements SceneAction {
    public static final int UNSPECIFIED = -1;
    public DrawImageAction(Image imageCopy, int x, int y, int size, int width, int height, double rotation) {
        // TODO: Draw image
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
