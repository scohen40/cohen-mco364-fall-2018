package cohen.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private ArrayList<ArrayList<Integer>> xArr = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> yArr = new ArrayList<>();
    private int counter = 0;

    public Canvas() {
        xArr.add(new ArrayList<>());
        yArr.add(new ArrayList<>());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);

        for(int i = 0; i < xArr.size(); i++) {
            for(int j = 1; j < xArr.get(i).size(); j++) {

                g.setColor(Color.RED);

                g.drawLine(xArr.get(i).get(j), yArr.get(i).get(j),
                        xArr.get(i).get(j-1), yArr.get(i).get(j-1));
            }
        }

    }

    public void newPencilLine() {
        xArr.add(new ArrayList<Integer>());
        yArr.add(new ArrayList<Integer>());
        counter++;
    }

    public void draw(int x, int y) {
        //add new coords to the current line
        xArr.get(counter).add(x);
        yArr.get(counter).add(y);
    }

}
