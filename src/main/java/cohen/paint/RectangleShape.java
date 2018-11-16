package cohen.paint;

import java.awt.*;

public class RectangleShape extends Shape {
    private Dot startLocation;
    private Dot endLocation;
    private int height;
    private int width;

    public RectangleShape(Color color) {
        super(color);
    }

    //To Do - Fix
    public void setDimentions() {
        //set width
        if(startLocation.getX() > endLocation.getX()) {
            int tempX = startLocation.getX();
            startLocation.setX(endLocation.getX());
            endLocation.setX(tempX);
            width = Math.abs(startLocation.getX() - endLocation.getX());
        }
        else {
            width = Math.abs(startLocation.getX() - endLocation.getX());
        }

        //set height
        if(startLocation.getY() > endLocation.getY()) {
            int tempY = startLocation.getY();
            startLocation.setY(endLocation.getY());
            endLocation.setX(tempY);
            height = Math.abs(startLocation.getY() - endLocation.getY());
        }
        else {
            height = Math.abs(startLocation.getY() - endLocation.getY());
        }
    }

    public Dot getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Dot startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(Dot endLocation) {
        this.endLocation = endLocation;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(startLocation.getX(), startLocation.getY(), width, height);
    }

}
