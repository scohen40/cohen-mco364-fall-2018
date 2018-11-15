package cohen.paint;

import java.awt.*;

public class Shape {
    private Color color;
    private ShapeType shapeType;

    public Shape() {
    }

    public Shape(Color color, ShapeType shapeType) {
        this.color = color;
        this.shapeType = shapeType;
    }

    public Color getColor() {
        return color;
    }

    public ShapeType getShapeType() { return shapeType; }
}
