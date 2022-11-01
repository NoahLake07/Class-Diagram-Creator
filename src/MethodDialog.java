import javax.swing.*;
import java.awt.*;

public class MethodDialog extends JFrame{

    FlowLayout layout = new FlowLayout();

    public void run(){
        JPanel headerPane = new JPanel(layout);
        JPanel inputPane = new JPanel(layout);
        setLayout(layout);
        this.setTitle("New Method");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,150);

        JLabel frameLabel = new JLabel("Create a new method:");

        JComboBox<String> AModDropdown = new JComboBox<>(new String[]{"Access Modifier", "(+) Public", "(-) Private", "(#) Protected"});
        JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"Return Type", "byte", "int", "short", "long"});
        JTextField name = new JTextField(10);
        name.setSize(name.getWidth(),AModDropdown.getHeight());
        //name.setText("Method Name");

        inputPane.add(AModDropdown);
        inputPane.add(name);
        inputPane.add(typeDropdown);

        // making the frame visible
        add(headerPane,BorderLayout.PAGE_START);
        add(inputPane, BorderLayout.CENTER);
        setVisible(true);
    }

}