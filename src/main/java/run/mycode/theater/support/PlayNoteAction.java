package run.mycode.theater.support;

import org.code.theater.Instrument;

import java.awt.*;

public class PlayNoteAction implements SceneAction {
    public PlayNoteAction(Instrument instrument, int note, double seconds) {
        //TODO: Play note
    }

    /**
     * Perform the SceneAction
     *
     * @param ignored the graphics context upon which to perform the action
     */
    @Override
    public void go(Graphics2D ignored) {
        throw new UnsupportedOperationException(this.getClass().getName() + " not implemented");
    }
}
