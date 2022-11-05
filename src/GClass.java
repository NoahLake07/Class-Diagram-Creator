import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;

public class GClass extends GraphicsProgram {

    public GClass(){

    }

    GRect outline, classNameShape, methodShape, variableShape;
    double variableSpaceSize;
    JLabel className, variableLabel, methodLabel;

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

}
