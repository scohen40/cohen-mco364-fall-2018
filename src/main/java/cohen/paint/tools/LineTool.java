package cohen.paint.tools;

import cohen.paint.Shapes.Dot;
import cohen.paint.Shapes.LineShape;
import cohen.paint.Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class LineTool implements ShapeTool{

    private LineShape line;

    public LineTool() {
    }

    @Override
    public void onMouseDragged(int x, int y) {
        line.getDots().add(new Dot(x, y));
    }

    @Override
    public void onMousePressed(int x, int y, Color color) {
        line = new LineShape(color);
        ArrayList<Dot> dots = new ArrayList<>();
        dots.add(new Dot(x, y));
        line.setDots(dots);
        line.setColor(color);
    }

    @Override
    public void onMouseReleased(int x, int y) {

    }

    @Override
    public Shape getShape() {
        return line;
    }
}
