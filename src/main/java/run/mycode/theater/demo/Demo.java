package run.mycode.theater.demo;

import org.code.media.Color;
import org.code.theater.Scene;
import org.code.theater.Theater;

public class Demo {
    public static void main(String[] args) {
        Scene demoScene = new Scene();

        demoScene.clear(Color.BLUE);

        System.out.println("Performance starting");
        Theater theatre = new Theater();
        theatre.playScenes(demoScene);
        System.out.println("Performance complete");
    }
}
