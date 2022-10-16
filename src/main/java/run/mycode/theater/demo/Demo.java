package run.mycode.theater.demo;

import org.code.media.Color;
import org.code.media.Font;
import org.code.media.FontStyle;
import org.code.media.Image;
import org.code.theater.Scene;
import org.code.theater.Theater;

import java.net.URL;

public class Demo {
    public static void main(String[] args) {
        Scene demoScene = new Scene();

        demoScene.setFillColor("Green");
        demoScene.setStrokeColor("Black");
        demoScene.clear(Color.RED);
        demoScene.pause(1);

        boolean color = true;
        for (int w = 380; w > 10; w -= 20) {
            if (color) {
                demoScene.setFillColor("Green");
            }
            else {
                demoScene.setFillColor("White");
            }
            color = !color;
            demoScene.drawEllipse((400 - w) / 2, (400 - w) / 2, w, w);
        }
        demoScene.pause(1);

        demoScene.clear(Color.BLUE);
        demoScene.pause(1);
        for (int w = 380; w > 10; w -= 20) {
            if (color) {
                demoScene.setFillColor("Red");
            }
            else {
                demoScene.setFillColor("White");
            }
            color = !color;
            demoScene.drawRectangle((400 - w) / 2, (400 - w) / 2, w, w);
        }
        demoScene.pause(1);

        demoScene.clear(Color.WHITE);
        demoScene.setStrokeColor(Color.BROWN);
        for (int i = 0; i < 100; i++) {
            demoScene.drawLine((int)(Math.random() * 400), (int)(Math.random() * 400),
                    (int)(Math.random() * 400), (int)(Math.random() * 400));
        }
        demoScene.pause(1);

        demoScene.clear(Color.YELLOW);
        demoScene.setStrokeColor(Color.BLACK);
        for (int i = 3; i < 9; i++) {
            demoScene.drawRegularPolygon(200, 200, i, 200 - (i * 20));
        }
        demoScene.pause(1);

        int[] starPoints = {0, 85, 75, 75, 100, 10, 125, 75, 200, 85, 150, 125,
                160, 190, 100, 150, 40, 190, 50, 125, 0, 85};

        demoScene.clear(Color.AQUA);
        demoScene.setStrokeColor(Color.BLACK);
        demoScene.setFillColor(Color.BEIGE);
        demoScene.drawShape(starPoints, true);
        demoScene.pause(1);

        demoScene.clear(Color.FUCHSIA);
        demoScene.setTextColor(Color.GOLD);
        demoScene.setTextHeight(24);
        demoScene.setTextStyle(Font.SERIF, FontStyle.BOLD);

        for (int i = 0; i < 360; i += 20) {
            demoScene.drawText("JAVA RULES", 200, 200, 360 - i);
        }
        demoScene.setTextColor(Color.BLACK);
        demoScene.drawText("JAVA RULES", 200, 200, 0);
        demoScene.pause(1);

        URL demoImageURL = Demo.class.getResource("/sampleImageBeach.jpg");
        Image demoImage = new Image(demoImageURL);
        demoScene.drawImage(demoImage, 0, 0, 200);
        demoScene.drawImage(demoImage, 400, 0, 200, 90);
        demoScene.drawImage(demoImage, 400, 400, 200, 200, 180);
        demoScene.drawImage(demoImage, 0, 400, 200, 270);

        Theater.playScenes(demoScene);
    }
}
