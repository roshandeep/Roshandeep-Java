import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class DragObjects2 extends GraphicsProgram
{
	
		GObject gobj;
		GPoint lastClick;
		GRect rect;
		GOval oval;
		int whichClick;
	public void init( )
	{
		rect = new GRect(100, 100, 150, 100);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		oval = new GOval(300, 115, 100, 70);
		oval.setFilled(true);
		oval.setColor(Color.GREEN);
		add(oval);
		addMouseListeners();
	} 
	
	
	public void mousePressed(MouseEvent e)
	{
		lastClick = new GPoint(e.getPoint());
		gobj = getElementAt(lastClick);
		if (e.getButton( ) == MouseEvent.BUTTON1) 
		{ whichClick = 1; }
		else 
		{ whichClick = 3; }
	}
	
	
	public void mouseDragged(MouseEvent e)
	{
	if ((gobj == rect && whichClick == 1) || (gobj == oval && whichClick == 3))
	{
	gobj.move(e.getX() - lastClick.getX(), e.getY() - lastClick.getY());
	lastClick = new GPoint(e.getPoint());
	}
	} 
}
