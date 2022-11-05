import javax.swing.*;
import java.awt.*;

public class MethodDialog extends JFrame{

    FlowLayout layout = new FlowLayout();

    public void run(){
        JPanel panel = new JPanel(layout);
        setLayout(null);
        this.setTitle("New Method");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,150);

        JComboBox<String> AModDropdown = new JComboBox<>(new String[]{"Access Modifier", "(+) Public", "(-) Private", "(#) Protected"});
        JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"Return Type", "byte", "int", "short", "long"});
        JTextField name = new JTextField(10);
        name.setSize(name.getWidth(),AModDropdown.getHeight());

        AModDropdown.setBounds(20,20,100,10);

        panel.add(AModDropdown);
        panel.add(name);
        panel.add(typeDropdown);

        // making the frame visible
        add(panel);
        setVisible(true);
    }

}