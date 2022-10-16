package run.mycode.theater.support;

import run.mycode.theater.Stage;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PlaySoundAction implements SceneAction {
    private Clip clip;

    public PlaySoundAction(URL url) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            clip = null;
            throw new RuntimeException(e);
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
        if (clip == null) {
            return;
        }
        clip.start();
    }
}
