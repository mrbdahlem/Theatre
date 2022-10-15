package run.mycode.theater;

import org.code.theater.support.Constants;
import run.mycode.theater.support.SceneAction;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Stage extends JFrame {
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    private final List<SceneAction> script;
    private JPanel stage;
    private JButton playButton;
    private JPanel contentPane;
    private Prompter prompter;

    private final Image displayImage;
    private final BufferedImage workingImage;

    public Stage(List<SceneAction> allActions) {
        super("Theatre");

        script = allActions;

        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);

        playButton.addActionListener(event -> perform());

        displayImage = new BufferedImage(Constants.THEATER_WIDTH, Constants.THEATER_HEIGHT, BufferedImage.TYPE_INT_RGB);
        workingImage = new BufferedImage(Constants.THEATER_WIDTH, Constants.THEATER_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    public Graphics2D getGraphicsContext() {
        return (Graphics2D) workingImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (displayImage != null) {
            Graphics display = stage.getGraphics();
            display.drawImage(displayImage, 0, 0, Color.WHITE, null);
            display.dispose();
        }
    }

    public void perform() {
        playButton.setEnabled(false);
        if (prompter == null) {
            prompter = new Prompter(script, this);
            prompter.runShow();
            playButton.setEnabled(true);
        }
    }

    public void updateStage() {
        Graphics ctx = displayImage.getGraphics();
        ctx.drawImage(workingImage, 0, 0, null);
        ctx.dispose();

        Graphics display = stage.getGraphics();
        display.drawImage(displayImage, 0, 0, TRANSPARENT, null);
        display.dispose();
    }

    public void showFinished() {
        updateStage();
        prompter = null;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
