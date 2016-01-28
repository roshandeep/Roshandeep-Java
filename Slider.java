import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Slider extends GRect implements Runnable
{
	public Slider(int size,Color color)
	{
		super(size,size);
		setFilled(true);
		setColor(color);
	}

	public void run()
	{
        while(true)
        {
        	pause(40);
        	move(STEPS,0);
        }
		
	}
  public final int STEPS=10;
}
