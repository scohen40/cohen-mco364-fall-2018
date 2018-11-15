package cohen.paint;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintingGUI extends JFrame implements MouseMotionListener, MouseListener {
    private Canvas painting;
    private ShapeType currentShapeType = ShapeType.Line;    //default shape

    public PaintingGUI() {
        setTitle("Paint Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //buttons panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout());

        //buttons
        //button 1
        JButton colorButton = new JButton("Pick to Change Background");
        buttons.add(colorButton);
        colorButton.addActionListener(this::changeColor);
        //button 2
        JButton pencilButton = new JButton("Pencil Draw");
        buttons.add(pencilButton);
        pencilButton.addActionListener(this::setCurrentPencil);
        //button 3
        JButton rectangleButton = new JButton("RectangleShape Draw");
        buttons.add(rectangleButton);
        rectangleButton.addActionListener(this::setCurrentRectangle);
        //add buttons panel to main panel
        panel.add(buttons, BorderLayout.NORTH);

        //add canvas to main panel
        painting = new Canvas();
        panel.add(painting, BorderLayout.CENTER);
        painting.addMouseListener(this);
        painting.addMouseMotionListener(this);


        setContentPane(panel);
    }

    private void changeColor(ActionEvent actionEvent) {
        Color newColor = JColorChooser.showDialog(
                PaintingGUI.this,
                "Choose Background Color",
                Color.black);
        painting.setCurrentColor(newColor);
    }

    private void setCurrentPencil(ActionEvent actionEvent) {
        currentShapeType = ShapeType.Line;
    }

    private void setCurrentRectangle(ActionEvent actionEvent) {
        currentShapeType = ShapeType.Rectangle;
    }


    public static void main(String args[]) {
        new PaintingGUI().setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentShapeType == ShapeType.Line) {
//            painting.addShape(ShapeType.Line);
            LineShape currentShape = (LineShape) painting.getCurrentShape();
            currentShape.getDots().add(new Dot(e.getX(), e.getY()));
        }
        else if(currentShapeType == ShapeType.Rectangle) {
            RectangleShape currentShape = (RectangleShape)painting.getCurrentShape();
            currentShape.setEndLocation(new Dot(e.getX(), e.getY()));
            currentShape.setDimentions();
        }
        painting.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(currentShapeType == ShapeType.Line){
            painting.addShape(ShapeType.Line);
        }
        else if(currentShapeType == ShapeType.Rectangle) {
            painting.addShape(ShapeType.Rectangle);
            RectangleShape currentShape = (RectangleShape)painting.getCurrentShape();
            currentShape.setStartLocation(new Dot(e.getX(), e.getY()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentShapeType == ShapeType.Line){
            //nothing happens
        }
        else if(currentShapeType == ShapeType.Rectangle) {
            RectangleShape currentShape = (RectangleShape)painting.getCurrentShape();
            currentShape.setEndLocation(new Dot(e.getX(), e.getY()));
            currentShape.setDimentions();
        }
        painting.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}