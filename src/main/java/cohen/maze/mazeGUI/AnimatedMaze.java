package cohen.maze.mazeGUI;

import cohen.maze.Cell;
import cohen.maze.Maze;

import javax.swing.*;
import java.awt.*;

public class AnimatedMaze extends JComponent {
    private Maze maze;
    private int componentHeight;
    private int componentWidth;
    private int seventhHeight;
    private int seventhWidth;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        componentHeight = this.getHeight();
        componentWidth = this.getWidth();
        seventhHeight = componentHeight/7;
        seventhWidth = componentWidth/7;

//        g.translate(0, this.getHeight());
        maze = new Maze(7, 7);
        g.setColor(Color.black);

        paintMaze(g);

    }

    /**
     * The paintMaze() method runs through the generated maze and paints the existing walls.
     * @param g
     */
    void paintMaze(Graphics g) {
        for (int x = 0; x < maze.getHeight(); x++) {
            System.out.println("|");
            for (int y = 0; y < maze.getWidth(); y++) {
                Cell currenst = maze.getMaze()[x][y];
                if(current.isWestWall()) {
                    g.setColor(Color.black);
                    g.drawLine((y+1)*seventhHeight, x*seventhHeight, (y+1)*seventhHeight, x*seventhHeight + seventhHeight);
                }

                if(current.isNorthWall()){
                    g.drawLine((y+1)*seventhHeight, x*seventhHeight,(y+1)*seventhHeight + seventhHeight, x*seventhHeight);
                }

                if(current.isEastWall()) {
                    g.drawLine((y+1)*seventhHeight + seventhHeight, x*seventhHeight, (y+1)*seventhHeight + seventhHeight, x*seventhHeight + seventhHeight);
                }

                if(current.isSouthWall()) {
                    g.drawLine((y+1)*seventhHeight, x*seventhHeight + seventhHeight, (y+1)*seventhHeight + seventhHeight, x*seventhHeight +seventhHeight);
                }

            }
        }
    }

}
