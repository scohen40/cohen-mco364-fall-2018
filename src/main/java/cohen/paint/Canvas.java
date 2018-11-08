package cohen.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private ArrayList<ArrayList<Dot>> dots = new ArrayList<>();
    private int counter = 0;

    public Canvas() {
        dots.add(new ArrayList<>());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < dots.size(); i++) {
            for(int j = 1; j < dots.get(i).size(); j++) {

                g.drawLine(
                        dots.get(i).get(j).getxCoord(),
                        dots.get(i).get(j).getyCoord(),
                        dots.get(i).get(j-1).getxCoord(),
                        dots.get(i).get(j-1).getyCoord());
            }
        }

    }

    public void newPencilLine() {
        dots.add(new ArrayList<Dot>());
        counter++;
    }

    public void draw(int x, int y) {
        //add new coords to the current line
        dots.get(counter).add(new Dot(x, y));
    }

}
