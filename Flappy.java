
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Flappy extends GraphicsProgram
{
	private static final int DIAM_BALL = 30;
	private GOval ball;
	final int WAIT = 20;
	final int MV_AMT = 5;
	int xMove, yMove;
	RandomGenerator rgen1 = RandomGenerator.getInstance();
	GRect wall1,wall2,wall3,wall4,wall5,wall6;
	


	public void init( )
	{
	  xMove=3;
	  yMove = 5;
	  addKeyListeners( );
	  addMouseListeners();
	}
	

	public void keyPressed(KeyEvent e)
	{
	int key = e.getKeyCode( );
	if (key == KeyEvent.VK_UP)
	{
	yMove = -10*MV_AMT;
	}
	}
	
	
	public void run( )
	{
		waitForClick();
        GOval ball = new GOval(40, 40);
		ball.setColor(Color.RED);
		ball.setFilled(true);
		add(ball, 40, getHeight()/2); 
		
		
		GRect wall1=new GRect(80,getHeight()/2);
		GRect wall2=new GRect(80,getHeight()/2+40);
		GRect wall3=new GRect(80,getHeight()/2);
		GRect wall4=new GRect(80,getHeight()/2+40);
		GRect wall5=new GRect(80,getHeight()/2);
		GRect wall6=new GRect(80,getHeight()/2+40);
		
		
		wall1.setColor(Color.BLACK);
		wall1.setFilled(true);
		add(wall1,200,0);
		
		wall2.setColor(Color.BLACK);
		wall2.setFilled(true);
		add(wall2,200,getHeight()-200);
		
		wall3.setColor(Color.BLACK);
		wall3.setFilled(true);
		add(wall3,getWidth()/2,0);
		
		wall4.setColor(Color.BLACK);
		wall4.setFilled(true);
		add(wall4,getWidth()/2,getHeight()-200);
		
		wall5.setColor(Color.BLACK);
		wall5.setFilled(true);
		add(wall5,getWidth()/2+400,0);
		
		wall6.setColor(Color.BLACK);
		wall6.setFilled(true);
		add(wall6,getWidth()/2+400,getHeight()-200);
		
	while(true) 
	{
	pause(WAIT);
	ball.move(xMove, yMove);
	yMove=MV_AMT;
	
	if((getElementAt(ball.getX(), ball.getY())) != null)
	{
	   printGameOver();
	   break;
	}
	else
		if (getElementAt( (ball.getX() + 40), ball.getY()) != null )
	{
		printGameOver(); 
	    break;
	}
	else
		if(getElementAt(ball.getX(), (ball.getY() + 40)) != null )
	{
		printGameOver();
	    break;
	}
	else
		if(getElementAt((ball.getX() + 40), (ball.getY() + 40)) != null )
	{
		printGameOver(); 
	    break;
	}
	else
	{
	continue;
	}
	}
	} 


	private void printGameOver()
		{
			GLabel gameOver = new GLabel ("Game Over", getWidth()/2, getHeight()/2);
			gameOver.setColor(Color.RED);
			gameOver.setFont("SanSerif-100");
			removeAll();
			while(true)
			{
				add(gameOver);
				pause(20);
				remove(gameOver);
			}
			}
		
	}

 