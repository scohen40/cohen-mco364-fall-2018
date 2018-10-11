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
                Cell current = maze.getMaze()[x][y];
                if(current.isWestWall()) {
                    g.setColor(Color.black);
                    g.drawLine(x*seventhHeight, y*seventhHeight, x*seventhHeight, y*seventhHeight + seventhHeight);
                }
//                else{
//                    g.setColor(Color.WHITE);
//                    g.drawLine(x*seventhHeight, y*seventhHeight, x*seventhHeight, y*seventhHeight + seventhHeight);
//                }
                if(current.isNorthWall()){
                    g.drawLine(x*seventhHeight, y*seventhHeight,x*seventhHeight + seventhHeight, y*seventhHeight);
                }
//                else{
//                    g.setColor(Color.WHITE);
//                    g.drawLine(x*seventhHeight, y*seventhHeight,x*seventhHeight + seventhHeight, y*seventhHeight);
//                }
                if(current.isEastWall()) {
                    g.drawLine(x*seventhHeight + seventhHeight, y*seventhHeight, x*seventhHeight + seventhHeight, y*seventhHeight + seventhHeight);
                }
//                else{
//                    g.setColor(Color.WHITE);
//                    g.drawLine(x*seventhHeight + seventhHeight, y*seventhHeight, x*seventhHeight + seventhHeight, y*seventhHeight + seventhHeight);
//                }
                if(current.isSouthWall()) {
                    g.drawLine(x*seventhHeight, y*seventhHeight + seventhHeight, x*seventhHeight + seventhHeight, y*seventhHeight +seventhHeight);
                }
//                else{
//                    g.setColor(Color.WHITE);
//                    g.drawLine(x*seventhHeight, y*seventhHeight + seventhHeight, x*seventhHeight + seventhHeight, y*seventhHeight +seventhHeight);
//                }
            }
        }
    }

}
