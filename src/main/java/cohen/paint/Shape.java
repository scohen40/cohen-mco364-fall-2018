package cohen.paint;

public class Shape {
//    private ArrayList<Dot> coords = new ArrayList<Dot>();
//
//    public ArrayList<Dot> getCoords() {
//        return coords;
//    }
//
//    public void setCoords(ArrayList<Dot> coords) {
//        this.coords = coords;
//    }
    private ShapeType shapeType;

    public Shape() {

    }

    public void setShapeType(ShapeType shapeType) { this.shapeType = shapeType; }

    public ShapeType getShapeType() { return shapeType; }
}
