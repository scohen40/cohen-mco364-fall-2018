package cohen.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private ArrayList<Integer> xArr = new ArrayList<>();
    private ArrayList<Integer> yArr = new ArrayList<>();


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);

        for(int i = 0; i < xArr.size(); i++) {
            g.drawOval(xArr.get(i), yArr.get(i), 5, 5);
        }

    }

    public void draw(int x, int y) {
        xArr.add(x);
        yArr.add(y);
    }

}
