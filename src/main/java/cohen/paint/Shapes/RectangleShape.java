package cohen.paint.Shapes;

import java.awt.*;

public class RectangleShape extends Shape {
    private Dot startLocation;
    private Dot endLocation;
    private int tempX;
    private int tempY;
    private int height;
    private int width;


    public RectangleShape(Color color) {
        super(color);

    }

    public void setDimentions() {
        width = Math.abs(startLocation.getX() - endLocation.getX());
        height = Math.abs(startLocation.getY() - endLocation.getY());
    }

    public void setStartLocation(Dot startLocation) {
        this.startLocation = startLocation;
    }

    public Dot getStartLocation() {
        return startLocation;
    }

    public void setEndLocation(Dot endLocation) {
        this.endLocation = endLocation;
    }

    public Dot getEndLocation() {
        return endLocation;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void paintShape(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(
                startLocation.getX(),
                startLocation.getY(),
                width,
                height);
    }
}
