import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class CreateBall extends GOval implements Runnable
{
	final int WAIT = 50;
	final int MV_AMT = 5;
	int  yMove=10;
	final int length=80,breadth=300;
	
	public CreateBall(int length,int breadth)
	{
        super(40, 40);
		setFilled(true);
		setColor(Color.RED);
	}
	

	public void run()
	{
		while(true)
		{
		move(0, yMove);
		yMove=MV_AMT;
		pause(WAIT);
		}
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public final int STEP=5;
}