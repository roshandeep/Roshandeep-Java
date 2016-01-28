import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends Program 
{

public void init() 
{
setLayout(new TableLayout(2, 3));
fahrenheitField = new IntField(32);
fahrenheitField.setActionCommand("F -> C");
fahrenheitField.addActionListener(this);
celsiusField = new IntField(0);
celsiusField.setActionCommand("C -> F");
celsiusField.addActionListener(this);
add(new JLabel("Degrees Fahrenheit"));
add(fahrenheitField);
add(new JButton("F -> C"));
add(new JLabel("Degrees Celsius"));
add(celsiusField);
add(new JButton("C -> F"));
addActionListeners();
}

public void actionPerformed(ActionEvent e)
{
String cmd = e.getActionCommand();
if (cmd.equals("F -> C")) {
int f = fahrenheitField.getValue();
int c = (int) Math.round((5.0 / 9.0) * (f - 32));
celsiusField.setValue(c);
} else if (cmd.equals("C -> F")) {
int c = celsiusField.getValue();
int f = (int) Math.round((9.0 / 5.0) * c + 32);
fahrenheitField.setValue(f);
}
}

private IntField fahrenheitField;
private IntField celsiusField;
}

