package cohen.paint;

import java.awt.*;
import java.util.ArrayList;

public class LineShape extends Shape {
    private ArrayList<Dot> dots;

    private Color color;

    public LineShape() {
        super();
        dots = new ArrayList<>();
    }

    public LineShape(Color color) {
        this.color = color;
        dots = new ArrayList<>();
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    public void setDots(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}