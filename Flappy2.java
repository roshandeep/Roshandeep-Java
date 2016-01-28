
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Flappy2 extends GraphicsProgram 
{
	private static final int DIAM_BALL = 30;
	private GOval ball;
	final int WAIT = 5;
	final int MV_AMT = 5;
	int yMove;
	final int length=80,breadth=600;
	RandomGenerator rgen = RandomGenerator.getInstance();
	int random;
	

	
	public void run()
	{
		addKeyListeners();
		
		CreateBall ball=new CreateBall(40,40);
		add(ball, 80, getHeight()/2); 
		Thread t3=new Thread(ball);
		t3.start();
			while(true) 
			{
				pause(2000);
				
				random=rgen.nextInt(250, 500);
		
				CreateWalls wall1=new CreateWalls(length,random);
				add(wall1,getWidth(),0);
				CreateWalls wall2=new CreateWalls(length,breadth);
				add(wall2,getWidth(),random+70);

				Thread t1=new Thread(wall1);
				Thread t2=new Thread(wall2);
				
		
				t1.start();
				t2.start();
			
				
			
				/*if((getElementAt(ball.getX(), ball.getY())) != null)
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
				}*/
		}
}


	public void keyPressed(KeyEvent e)
	{
		System.out.println("Key Pressed");
		int key = e.getKeyCode( );
		if (key == KeyEvent.VK_UP)
		{
			System.out.println("Key Pressed");
			ball.move(0,-10*MV_AMT);
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


 

