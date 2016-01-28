

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class CreateWalls extends GRect implements Runnable
{
	public CreateWalls(int length,int breadth)
	{
		super(length,breadth);
		setFilled(true);
		setColor(Color.GREEN);
	}
	

	public void run()
	{
		while(true)
		{
			pause(40);
			move(-STEP,0);
		}
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public final int STEP=5;
}