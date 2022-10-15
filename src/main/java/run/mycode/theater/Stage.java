package run.mycode.theater;

import run.mycode.theater.support.SceneAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Stage {
    private final JFrame frame;
    private JToolBar buttonBar;
    private JPanel stage;
    private JButton playButton;
    private JPanel contentPane;
    private Prompter prompter;

    public Stage() {
        frame = new JFrame("Theater");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public Graphics2D getGraphicsContext() {
        return (Graphics2D) stage.getGraphics();
    }

    public void show(List<SceneAction> allActions) {
        frame.setVisible(true);

        prompter = new Prompter(allActions, this);
    }
}
