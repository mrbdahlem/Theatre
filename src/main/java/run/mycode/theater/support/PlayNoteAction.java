package run.mycode.theater.support;

import org.code.theater.Instrument;
import run.mycode.theater.Stage;

import java.awt.*;

public class PlayNoteAction implements SceneAction {
    public PlayNoteAction(Instrument instrument, int note, double seconds) {
        //TODO: Play note
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
