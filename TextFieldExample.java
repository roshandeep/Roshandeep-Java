
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldExample extends ConsoleProgram
{
public void init()
{
nameField = new JTextField(10);
add(new JLabel("Name"), SOUTH);
add(nameField, SOUTH);
nameField.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
if (e.getSource() == nameField)
{
println("Hello, " + nameField.getText());
}
}

private JTextField nameField;
}
