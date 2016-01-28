import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class SliderProgram extends GraphicsProgram
{
	public void run()
	{
		add(new JButton("Start"),SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String cmd=e.getActionCommand();
		if(cmd.equals("Start"))
		{
			Slider slider=new Slider(size,rgen.nextColor());
			add(slider,0,rgen.nextDouble(0, 300));
			
			Thread t=new Thread(slider);
			t.start();
		}
	}
	RandomGenerator rgen = RandomGenerator.getInstance();
	public final int size=20;
}
