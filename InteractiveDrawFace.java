import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InteractiveDrawFace extends GraphicsProgram
{
public void init() 
{
add(new JButton("Clear"), SOUTH);
checkbox = new JCheckBox("Front");
checkbox.setSelected(true);
add(checkbox, SOUTH);
initRadioButtons();
initColorChooser();
addMouseListeners();
addActionListeners();
}


private void initRadioButtons()
{
ButtonGroup sizeBG = new ButtonGroup();
smallRB = new JRadioButton("Small");
medRB = new JRadioButton("Medium");
largeRB = new JRadioButton("Large");
sizeBG.add(smallRB);
sizeBG.add(medRB);
sizeBG.add(largeRB);
medRB.setSelected(true);
add(smallRB, SOUTH);
add(medRB, SOUTH);
add(largeRB, SOUTH);
}


private void initColorChooser()
{
pickColor = new JComboBox();
pickColor.addItem("Black");
pickColor.addItem("Blue");
pickColor.addItem("Green");
pickColor.addItem("Red");
pickColor.setEditable(false);
pickColor.setSelectedItem("Black");
add(new JLabel(" Color:"), SOUTH);
add(pickColor, SOUTH);
}


private double getDiamSize()
{
double size = 0;
if (smallRB.isSelected())
{
size = SMALL_DIAM;
} else if (medRB.isSelected())
{
size = MED_DIAM;
} else if (largeRB.isSelected()) {
size = LARGE_DIAM;
}
return size;
}


private Color getCurrentColor()
{
String name = (String) pickColor.getSelectedItem();
if (name.equals("Blue")) {
return Color.BLUE;
} else if (name.equals("Green")) {
return Color.GREEN;
} else if (name.equals("Red")) {
return Color.RED;
} else return Color.BLACK;
}


public void mouseClicked(MouseEvent e)
{
GObject obj;
double diam = getDiamSize();
if (checkbox.isSelected()) {
obj = new GFace(diam, diam);
} else {
obj = new GOval(diam, diam);
}
obj.setColor(getCurrentColor());
add(obj, e.getX(), e.getY());
}


public void actionPerformed(ActionEvent e)
{
if (e.getActionCommand().equals("Clear"))
{
removeAll();
}
}

private static final double SMALL_DIAM = 20;
private static final double MED_DIAM = 40;
private static final double LARGE_DIAM = 60;
private JCheckBox checkbox;
private JRadioButton smallRB;
private JRadioButton medRB;
private JRadioButton largeRB;
private JComboBox pickColor;
}