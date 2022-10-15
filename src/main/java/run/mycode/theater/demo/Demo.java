package run.mycode.theater.demo;

import org.code.media.Color;
import org.code.theater.Scene;
import org.code.theater.Theater;

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

        Theater.playScenes(demoScene);
    }
}
