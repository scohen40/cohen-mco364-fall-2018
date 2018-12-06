package cohen.paint.Shapes;

import java.awt.*;

public class Shape {

    private Color color;

    public Shape() {

    }

    public Shape(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void paintShape(Graphics g) {
        g.setColor(color);
    }

}

