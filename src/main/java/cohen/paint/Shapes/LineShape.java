package cohen.paint.Shapes;

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

    public void setDots(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    @Override
    public void paintShape(Graphics g){
        g.setColor(getColor());

        for(int d = 1; d < dots.size(); d++) {
            g.drawLine(
                    dots.get(d).getX(),
                    dots.get(d).getY(),
                    dots.get(d-1).getX(),
                    dots.get(d-1).getY());
        }
    }

}
