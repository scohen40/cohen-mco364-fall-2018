package cohen.paint;

import java.awt.*;
import java.util.ArrayList;

public class LineShape extends Shape {
    private ArrayList<Dot> dots;

    public LineShape(Color color, ShapeType shapeType) {
        super(color, shapeType);
        dots = new ArrayList<>();
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }
}