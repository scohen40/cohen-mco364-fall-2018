package cohen.maze.mazeGUI;

import cohen.maze.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnimatedMazeGUI extends JFrame {
    private AnimatedMaze animatedMaze;
    private Maze maze;
    private Man man;
    public AnimatedMazeGUI() {
        setTitle("Animated Maze Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        maze = new Maze(7, 7);
        man = new Man(7, 7);
        animatedMaze = new AnimatedMaze(maze, man);
        panel.add(animatedMaze, BorderLayout.CENTER);

        addKeyListener(new MyKeyAdapter());

        setContentPane(panel);

    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            System.out.println("key detected");
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                //set man direction
                getAnimatedMaze().getMan().setDirection(Direction.LEFT);
                //advance man)
                advanceMan();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                getAnimatedMaze().getMan().setDirection(Direction.RIGHT);
                advanceMan();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                getAnimatedMaze().getMan().setDirection(Direction.UP);
                advanceMan();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                getAnimatedMaze().getMan().setDirection(Direction.DOWN);
                advanceMan();
            }

        }
    }

    public AnimatedMaze getAnimatedMaze() {
        return animatedMaze;
    }

    //have this called when action keystroke is heard by action listener
    //REPAINT WHOLE THING OR JUST THE MAN?? LET'S SEE HOW IT GOES...
    public void advanceMan() {
        if (!animatedMaze.getMan().isFinished()) {
            Direction direction = animatedMaze.getMan().getDirection();
            int row = animatedMaze.getMan().getRow()-1;
            int column = animatedMaze.getMan().getColumn()-1;

            switch (direction) {
                case UP:
                    if (animatedMaze.getMan().getRow() == 0) {
                        break;
                    }
                    if (!maze.getMaze()[row][column].isNorthWall()) {
                        //reset the man's row and column.
                        animatedMaze.getMan().setRow(row - 1);
                        //repaint in cell above (a row less than where the man is now.
                        animatedMaze.repaint();
                    }

                case RIGHT:
                    if (animatedMaze.getMan().getColumn() + 1 > animatedMaze.getWidth() - 1) {
                        break;
                    }
                    if (!maze.getMaze()[row][column].isEastWall()) {
                        //reset the man's row and column.
                        animatedMaze.getMan().setColumn(column + 1);
                        //repaint in cell to the right
                        animatedMaze.repaint();                    }

                case DOWN:
                    if (animatedMaze.getMan().getRow() + 1 > animatedMaze.getHeight() - 1) {
                        break;
                    }
                    if (!maze.getMaze()[row][column].isSouthWall()) {
                        //reset the man's row and column.
                        animatedMaze.getMan().setRow(row + 1);
                        //repaint in cell to the right
                        animatedMaze.repaint();
                    }

                case LEFT:
                    if (animatedMaze.getMan().getColumn() == 0) {
                        break;
                    }
                    if (!maze.getMaze()[row][column].isWestWall()) {
                        //reset the man's row and column.
                        animatedMaze.getMan().setColumn(column - 1);
                        //repaint in cell to the right
                        animatedMaze.repaint();
                    }

            }


        }

    }

    public static void main(String[]args) {
        new AnimatedMazeGUI().setVisible(true);
    }

}
