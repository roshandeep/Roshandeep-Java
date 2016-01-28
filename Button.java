
import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import java.awt.event.*;
public class Button extends ConsoleProgram
{
public void run()
{
	button=new JButton("HI");
	add(button,SOUTH);
	addActionListeners();
}
public void actionPerformed(ActionEvent e)
{
	String cmd=e.getActionCommand();
	if(cmd.equals("HI"));
	println("Hello Roshan");
}
public static JButton button;
}

