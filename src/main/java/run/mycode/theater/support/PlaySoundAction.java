package run.mycode.theater.support;

import org.code.media.util.AudioUtils;
import run.mycode.theater.Stage;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
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

    public PlaySoundAction(double[] sound) {
        try {
            byte[] data = AudioUtils.convertDoubleArrayToByteArray(sound);
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bais);

            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
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
