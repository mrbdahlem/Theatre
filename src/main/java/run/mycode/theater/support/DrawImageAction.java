package run.mycode.theater.support;

import run.mycode.theater.Stage;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class DrawImageAction implements SceneAction {
    public static final int UNSPECIFIED = -1;
    private final BufferedImage image;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final double rotation;

    public DrawImageAction(BufferedImage imageCopy, int x, int y, int size, int width, int height, double rotation) {
        this.image = imageCopy;
        this.x = x;
        this.y = y;
        this.rotation = Math.toRadians(rotation);

        if (size != UNSPECIFIED) {
            // If the "size" value was provided, we need to scale the height proportionally.
            width = size;
            final int imageHeight = imageCopy.getHeight();
            final int imageWidth = imageCopy.getWidth();
            height = (int) ((double) imageHeight * ((double) width / (double) imageWidth));
        }

        this.width = width;
        this.height = height;
    }

    /**
     * Perform the SceneAction
     *
     * @param context the graphics context upon which to perform the action
     * @param stage the stage where the scene is taking place
     */
    @Override
    public void go(Graphics2D context, Stage stage) {
        if (rotation != 0) {
            AffineTransform transform = new AffineTransform();
            double widthScale = (double) width / image.getWidth();
            double heightScale = (double) height / image.getHeight();
            // create a transform that moves the location of the image to (x,y), rotates around
            // the top left corner of the image and scales the image to width and height
            // Note: order of transforms is important, do not reorder these calls
            transform.translate(x, y);
            transform.rotate(rotation, 0, 0);
            transform.scale(widthScale, heightScale);
            context.drawImage(image, transform, null);
        } else {
            context.drawImage(image, x, y, width, height, null);
        }
    }
}
