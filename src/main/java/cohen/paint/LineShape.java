package cohen.paint;

import java.awt.*;
import java.util.ArrayList;

public class LineShape extends Shape {
    private ArrayList<Dot> dots;


    public LineShape(Color color) {
        super(color);
        dots = new ArrayList<>();
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.getColor());
        for (int dot = 1; dot < dots.size(); dot++) {
            g.drawLine(
                    dots.get(dot).getX(),
                    dots.get(dot).getY(),
                    dots.get(dot - 1).getX(),
                    dots.get(dot - 1).getY());
        }
    }
}