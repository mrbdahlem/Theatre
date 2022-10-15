package org.code.theater;
import run.mycode.theater.Stage;
import run.mycode.theater.support.SceneAction;

import java.util.List;
import java.util.ArrayList;
public final class Theater {
    public static void playScenes(Scene scene) {
        playInternal(scene);
    }

    public static void playScenes(Scene... scenes) {
        playInternal(scenes);
    }

    public static void play(Scene[] scenes) {
        playInternal(scenes);
    }

    private static void playInternal(Scene... scenes) {
        final List<SceneAction> allActions = new ArrayList<>();
        for (Scene scene : scenes) {
            allActions.addAll(scene.getActions());
        }

        Stage stage = new Stage(allActions);
        stage.perform();
    }
}
