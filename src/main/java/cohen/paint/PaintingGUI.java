package cohen.paint;



import cohen.paint.tools.ErasorTool;
import cohen.paint.tools.FilledRectangleTool;
import cohen.paint.tools.LineTool;
import cohen.paint.tools.RectangleTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PaintingGUI extends JFrame {
    private Canvas canvas;

    public PaintingGUI() {
        setTitle("Paint Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2, 3));

        JButton colorButton = new JButton("Pick to Change Color");
        buttons.add(colorButton);
        colorButton.addActionListener(this::changeColor);

        JButton pencilButton = new JButton("Pencil Draw");
        buttons.add(pencilButton);
        pencilButton.addActionListener(this::setCurrentPencil);

        JButton rectangleButton = new JButton("Rectangle Draw");
        buttons.add(rectangleButton);
        rectangleButton.addActionListener(this::setCurrentRectangle);

        JButton fillRectangleButton = new JButton("Fill Rectangle Draw");
        buttons.add(fillRectangleButton);
        fillRectangleButton.addActionListener(this::setCurrentFillRectangle);

        JButton eraseButton = new JButton("Erase Draw");
        buttons.add(eraseButton);
        eraseButton.addActionListener(this::setCurrentErase);

        JButton undoButton = new JButton("Undo");
        buttons.add(undoButton);
        undoButton.addActionListener(this::undoLastShape);

        panel.add(buttons, BorderLayout.NORTH);

        canvas = new Canvas();
        panel.add(canvas, BorderLayout.CENTER);

        setContentPane(panel);
    }

    private void changeColor(ActionEvent actionEvent) {
        Color newColor = JColorChooser.showDialog(
                PaintingGUI.this,
                "Choose Painting Color",
                Color.black);
        canvas.setCurrentColor(newColor);
    }

    private void setCurrentPencil(ActionEvent actionEvent) {
        canvas.setCurrentShapeTool(new LineTool());
    }

    private void setCurrentRectangle(ActionEvent actionEvent) {
        canvas.setCurrentShapeTool(new RectangleTool());
    }

    private void setCurrentFillRectangle(ActionEvent actionEvent) {
        canvas.setCurrentShapeTool(new FilledRectangleTool());
    }

    private void setCurrentErase(ActionEvent actionEvent) {
        canvas.setCurrentShapeTool(new ErasorTool());
    }

    private void undoLastShape(ActionEvent actionEvent) {
        canvas.undoLastShape();
    }

    public static void main(String args[]) {
        new PaintingGUI().setVisible(true);
    }

}