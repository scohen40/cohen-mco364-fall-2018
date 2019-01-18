package cohen.paint;

import cohen.paint.Shapes.Shape;
import cohen.paint.tools.LineTool;
import cohen.paint.tools.ShapeTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;


public class Canvas extends JComponent implements MouseListener, MouseMotionListener {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ShapeTool currentShapeTool = null;
    private Color currentColor = Color.BLACK; //default color


    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.currentShapeTool = new LineTool();
        currentColor = Color.black;

        shapes.add(new Shape(currentColor)); //add null shape as a buffer
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintShapes(g);
    }

    public void paintShapes(Graphics g) {
        for(Shape shape : shapes) {
            shape.paintShape(g);
        }
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setCurrentShapeTool(ShapeTool shapeTool) {
        this.currentShapeTool = shapeTool;
    }

    public void undoLastShape() {
        if(!shapes.isEmpty()) {
            shapes.remove(shapes.size()-1);
            repaint();
        }
    }

    public void saveImagePNG(File file) {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2D = bufferedImage.createGraphics();
        this.paintShapes(g2D); //see if this works, if it doesn't, uncomment the next few lines and get rid of this one.
//        for (Shape shape : shapes) {
//            shape.paintShape(g2D);
//        }
        this.paint(g2D);
        try {
            ImageIO.write(bufferedImage,"png", file);
            JOptionPane.showMessageDialog(null,"Image saved.", "Save Successful", JOptionPane.OK_OPTION);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not saved. Contact system admin.", "Save Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
    }

    public void saveImageProject(File file) throws IOException {
        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Image not saved. Contact system admin.", "Save Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not saved. Contact system admin.", "Save Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(shapes);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not saved. Contact system admin.", "Save Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        objectOutputStream.close();
    }


    public void loadImageProject(File file) throws IOException {
        FileInputStream fileInputStream= null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Project File not found. Contact system admin.", "Project Loading Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Loading was unsuccessful. Contact system admin.", "Project Loading Unsuccessfu",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        try {
            shapes = (ArrayList<Shape>)(objectInputStream.readObject());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Loading was unsuccessful. Contact system admin.", "Save Unsuccessful",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        objectInputStream.close();
        this.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentShapeTool.onMouseDragged(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) { }

    @Override
    public void mousePressed(MouseEvent e) {
        currentShapeTool.onMousePressed(e.getX(), e.getY(), currentColor);
        shapes.add(currentShapeTool.getShape());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentShapeTool.onMouseReleased(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

}
