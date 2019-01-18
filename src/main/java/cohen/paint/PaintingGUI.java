package cohen.paint;


import cohen.paint.tools.ErasorTool;
import cohen.paint.tools.FilledRectangleTool;
import cohen.paint.tools.LineTool;
import cohen.paint.tools.RectangleTool;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class PaintingGUI extends JFrame {
    private Canvas canvas;
    private File file;
    private JFileChooser fileChooser;
    private FileNameExtensionFilter pngFilter;
    private FileNameExtensionFilter projectFilter;

    public PaintingGUI() {
        setTitle("Paint Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        file = new File("");
        fileChooser = new JFileChooser();
        pngFilter = new FileNameExtensionFilter("png", "png");
        projectFilter = new FileNameExtensionFilter("paint project", "src");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3));

        JButton colorButton = new JButton("Change Color");
        buttons.add(colorButton);
        colorButton.addActionListener(this::changeColor);

        JButton pencilButton = new JButton("Pencil");
        buttons.add(pencilButton);
        pencilButton.addActionListener(this::setCurrentPencil);

        JButton rectangleButton = new JButton("Rectangle");
        buttons.add(rectangleButton);
        rectangleButton.addActionListener(this::setCurrentRectangle);

        JButton fillRectangleButton = new JButton("Fill Rectangle");
        buttons.add(fillRectangleButton);
        fillRectangleButton.addActionListener(this::setCurrentFillRectangle);

        JButton eraseButton = new JButton("Erase");
        buttons.add(eraseButton);
        eraseButton.addActionListener(this::setCurrentErase);

        JButton undoButton = new JButton("Undo");
        buttons.add(undoButton);
        undoButton.addActionListener(this::undoLastShape);

        JButton savePNGButton = new JButton("Save As PNG");
        buttons.add(savePNGButton);
        savePNGButton.addActionListener(this::saveAsPNG);

        JButton saveButton = new JButton("Save Project");
        buttons.add(saveButton);
        saveButton.addActionListener(this::saveAsProject);

        JButton loadButton = new JButton("Open Project");
        buttons.add(loadButton);
        loadButton.addActionListener(this::loadImage);

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

    private void saveAsPNG(ActionEvent actionEvent) {
        fileChooser.setFileFilter(pngFilter);
        try {
            int returnVal = fileChooser.showSaveDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".png");
                canvas.saveImagePNG(file);
            } else if(returnVal == JFileChooser.ERROR || returnVal == JFileChooser.ERROR_OPTION) {
                JOptionPane.showMessageDialog(null, "Error saving file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        clearFileChooser();
    }

    private void saveAsProject(ActionEvent actionEvent) {
        fileChooser.setFileFilter(projectFilter);
        try {
            int returnVal = fileChooser.showSaveDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".src");
                canvas.saveImageProject(file);
            } else if(returnVal == JFileChooser.ERROR || returnVal == JFileChooser.ERROR_OPTION) {
                JOptionPane.showMessageDialog(null, "Error saving file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        clearFileChooser();
    }

    private void loadImage(ActionEvent actionEvent) {
        try {
            int returnVal = fileChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                canvas.loadImageProject(file);
            } else if(returnVal == JFileChooser.ERROR || returnVal == JFileChooser.ERROR_OPTION) {
                JOptionPane.showMessageDialog(null, "Error opening file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error opening file. Contact system admin.", "Error",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        clearFileChooser();
    }

    private void clearFileChooser() {
        fileChooser.setSelectedFile(new File(" "));
    }

    public static void main (String args[]){
        new PaintingGUI().setVisible(true);
    }

}
