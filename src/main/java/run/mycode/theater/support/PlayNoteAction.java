package run.mycode.theater.support;

import run.mycode.theater.Stage;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PlayNoteAction implements SceneAction {
    private Clip clip;

    public PlayNoteAction(URL note, double seconds) {
        try {
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(note);
            AudioFormat audioFormat = fileFormat.getFormat();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(note);
            long framesOfAudioToCopy = (long)(seconds * audioFormat.getFrameRate());

            if (framesOfAudioToCopy > fileFormat.getFrameLength()) {
                throw new UnsupportedOperationException("Note duration too long");
            }
            AudioInputStream shortenedStream = new AudioInputStream(inputStream, audioFormat, framesOfAudioToCopy);
            clip = AudioSystem.getClip();
            clip.open(shortenedStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            clip = null;
            throw new RuntimeException(e); // Convert exceptions for simpler student code
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
