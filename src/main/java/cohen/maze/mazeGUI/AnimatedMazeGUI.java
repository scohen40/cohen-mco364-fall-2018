package cohen.maze.mazeGUI;

import javax.swing.*;
import java.awt.*;

public class AnimatedMazeGUI extends JFrame {
    private AnimatedMaze animatedMaze;

    public AnimatedMazeGUI() {
        setTitle("Animated Maze Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        animatedMaze = new AnimatedMaze();
        panel.add(animatedMaze, BorderLayout.CENTER);

        setContentPane(panel);

    }


    public static void main(String[] args) {
        new AnimatedMazeGUI().setVisible(true);
    }



}
