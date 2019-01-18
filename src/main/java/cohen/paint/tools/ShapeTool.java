package cohen.paint.tools;

import cohen.paint.Shapes.Shape;

import java.awt.*;

public interface ShapeTool {

    public void onMouseDragged(int x, int y);

    public void onMousePressed(int x, int y, Color color);

    public void onMouseReleased(int x, int y);

    public Shape getShape();

}
