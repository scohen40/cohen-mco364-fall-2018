package cohen.paint.Shapes;

import cohen.paint.Dot;

import java.util.ArrayList;

public class Shape {
    private ArrayList<Dot> coords = new ArrayList<Dot>();

    public ArrayList<Dot> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<Dot> coords) {
        this.coords = coords;
    }
}
