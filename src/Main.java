import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {

    GRect outline, classNameShape, methodShape, variableShape;
    double variableSpaceSize;
    JLabel className, variableLabel, methodLabel;

    final String VAR_ADD = "buttonImages/variable/Add.png";
    final String VAR_REMOVE = "buttonImages/variable/Remove.png";
    final String VAR_ADD_HOVER = "buttonImages/variable/Add-Hover.png";
    final String VAR_REMOVE_HOVER = "buttonImages/variable/Remove-Hover.png";
    final String METHOD_ADD = "buttonImages/method/Add.png";
    final String METHOD_REMOVE = "buttonImages/method/Remove.png";
    final String METHOD_ADD_HOVER = "buttonImages/method/Add-Hover.png";
    final String METHOD_REMOVE_HOVER = "buttonImages/method/Remove-Hover.png";

    public void init(){
        setupWindow();
        createTable();
        createLabels();
        createButtons();
    }

    private void createButtons(){
        // instantiate
        GImage addMethod = new GImage(METHOD_ADD);
        GImage removeMethod = new GImage(METHOD_REMOVE);
        GImage addVariable = new GImage(VAR_ADD);
        GImage removeVariable = new GImage(VAR_REMOVE);

        double scaleFactor = 0.02;
        addMethod.scale(scaleFactor);
        addVariable.scale(scaleFactor);
        removeMethod.scale(scaleFactor);
        removeVariable.scale(scaleFactor);


        // add to screen
        add(addMethod, methodShape.getX() + methodShape.getWidth()/30,
                    methodShape.getY() + methodShape.getHeight() - removeMethod.getHeight() - methodShape.getHeight()/30);
        add(removeMethod, addMethod.getX() + methodShape.getWidth()/12,
                methodShape.getY() + methodShape.getHeight() - removeMethod.getHeight() - methodShape.getHeight()/30);
        add(addVariable, variableShape.getX() + variableShape.getWidth()/30,
                variableShape.getY() + variableShape.getHeight() - addVariable.getHeight() - variableShape.getHeight()/30);
        add(removeVariable, addMethod.getX() + variableShape.getWidth()/12,
                variableShape.getY() + variableShape.getHeight() - removeMethod.getHeight() - variableShape.getHeight()/30);

        // creating MouseAdapters for each button
        MouseAdapter addVar = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                addVariable.setImage(VAR_ADD_HOVER);
                addVariable.scale(scaleFactor);
            }

            public void mouseExited(MouseEvent evt) {
                addVariable.setImage(VAR_ADD);
                addVariable.scale(scaleFactor);
            }

            public void mousePressed(MouseEvent e){
                createVariable();
            }
        };
        MouseAdapter removeVar = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                removeVariable.setImage(VAR_REMOVE_HOVER);
                removeVariable.scale(scaleFactor);
            }

            public void mouseExited(MouseEvent evt) {
                removeVariable.setImage(VAR_REMOVE);
                removeVariable.scale(scaleFactor);
            }

            public void mousePressed(MouseEvent e){
                removeVariable();
            }
        };
        MouseAdapter addMet = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                addMethod.setImage(METHOD_ADD_HOVER);
                addMethod.scale(scaleFactor);
            }

            public void mouseExited(MouseEvent evt) {
                addMethod.setImage(METHOD_ADD);
                addMethod.scale(scaleFactor);
            }

            public void mousePressed(MouseEvent e){
                createMethod();
            }
        };
        MouseAdapter removeMet = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                removeMethod.setImage(METHOD_REMOVE_HOVER);
                removeMethod.scale(scaleFactor);
            }

            public void mouseExited(MouseEvent evt) {
                removeMethod.setImage(METHOD_REMOVE);
                removeMethod.scale(scaleFactor);
            }

            public void mousePressed(MouseEvent e){
                removeMethod();
            }
        };

        // adding the MouseAdapters to the buttons
        addMethod.addMouseListener(addMet);
        removeMethod.addMouseListener(removeMet);
        addVariable.addMouseListener(addVar);
        removeVariable.addMouseListener(removeVar);

    }


    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {

            default: System.out.println("Object click detected");
            }
        }


    private void createMethod(){
        System.out.println("Method Create");
        ClassDialog.createMethod();
    }

    private void createVariable(){
        System.out.println("Variable fCreate");
    }

    private void removeMethod(){
        System.out.println("Method Remove");
    }

    private void removeVariable(){
        System.out.println("Variable Remove");
    }

    private void setupWindow(){
        this.setSize(460,600);
        this.getMenuBar().setVisible(false);
        this.setTitle("Class Diagram Creator");
        this.setBackground(new Color(180, 144, 118));

    }

    private void createLabels(){
        className = new JLabel("CLASS NAME");
        variableLabel = new JLabel("Variables");
        methodLabel = new JLabel("Methods");

        className.setHorizontalAlignment(SwingConstants.CENTER);
        className.setVerticalAlignment(SwingConstants.CENTER);

        variableLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        variableLabel.setVerticalAlignment(SwingConstants.CENTER);

        methodLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        methodLabel.setVerticalAlignment(SwingConstants.CENTER);

        add(className,0,0);
        className.setLocation((int) ((int) classNameShape.getX() + classNameShape.getWidth()/2) - className.getWidth()/2,
                (int) ((int) classNameShape.getY() + classNameShape.getHeight()/2 - className.getHeight()/2));

        add(variableLabel,0,0);
        variableLabel.setLocation((int) (variableShape.getX() + variableShape.getWidth() - variableLabel.getWidth() - variableShape.getWidth()/50),
                (int) ((int) variableShape.getY() + variableShape.getHeight()/40));

        add(methodLabel,0,0);
        methodLabel.setLocation((int) (methodShape.getX() + methodShape.getWidth() - methodLabel.getWidth() - methodShape.getWidth()/50),
                (int) ((int) methodShape.getY() + methodShape.getHeight()/40));

        Color labelColor = new Color(128, 128, 128);
        variableLabel.setForeground(labelColor);
        methodLabel.setForeground(labelColor);

    }

    private void createTable(){
        // basic table outline
        outline = new GRect(getWidth()-getWidth()/20,getHeight() - getHeight()/7);
        add(outline, getWidth()/2 - outline.getWidth()/2, getHeight()/40);

        // class name shape
        classNameShape = new GRect(outline.getWidth(), outline.getHeight()/20);
        add(classNameShape, outline.getX(), outline.getY());
        classNameShape.setFilled(true);
        classNameShape.setFillColor(new Color(182, 182, 182, 255));
        classNameShape.setColor(Color.BLACK);

        // variable shape
        variableSpaceSize = (outline.getHeight() * 0.45);
        variableShape = new GRect(outline.getWidth(), variableSpaceSize);
        add(variableShape, outline.getX(), classNameShape.getY() + classNameShape.getHeight());
        variableShape.setFilled(true);
        variableShape.setFillColor(Color.WHITE);
        variableShape.setColor(Color.BLACK);

        // method shape
        methodShape = new GRect(outline.getWidth(), outline.getHeight() - variableSpaceSize - classNameShape.getHeight());
        add(methodShape, outline.getX() ,outline.getY() + outline.getHeight() - methodShape.getHeight());
        methodShape.setFilled(true);
        methodShape.setFillColor(Color.WHITE);
        methodShape.setColor(Color.WHITE);

        // layer shapes
        classNameShape.sendToBack();
        variableShape.sendToBack();
        methodShape.sendToBack();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}