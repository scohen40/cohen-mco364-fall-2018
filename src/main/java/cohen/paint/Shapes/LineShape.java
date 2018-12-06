package cohen.paint.Shapes;

import java.awt.*;
import java.util.ArrayList;

public class LineShape extends Shape {
    private ArrayList<Dot> dots;

    public LineShape() {
        super();
    }

    public LineShape(Color color) {
        super(color);
    }

    public void setDots(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    public void paintShape(Graphics g){
        g.setColor(this.getColor());

        for(int d = 1; d < dots.size(); d++) {
        g.drawLine(
                dots.get(d).getX(),
                dots.get(d).getY(),
                dots.get(d-1).getX(),
                dots.get(d-1).getY());
        }
    }

}
