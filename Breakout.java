
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
 
public class Breakout extends GraphicsProgram
{
 
/** Width and height of application window in pixels */
public static final int APPLICATION_WIDTH = 400;
public static final int APPLICATION_HEIGHT = 600;
 
/** Dimensions of game board (usually the same) */
private static final int WIDTH = APPLICATION_WIDTH;
private static final int HEIGHT = APPLICATION_HEIGHT;
 
/** Dimensions of the paddle */
private static final int PADDLE_WIDTH = 60;
private static final int PADDLE_HEIGHT = 10;
 
/** Offset of the paddle up from the bottom */
private static final int PADDLE_Y_OFFSET = 30;
 
/** Number of bricks per row */
private static final int NBRICKS_PER_ROW = 10;
 
/** Number of rows of bricks */
private static final int NBRICK_ROWS = 10;
 
/** Separation between bricks */
private static final int BRICK_SEP = 4;
 
/** Width of a brick */
private static final int BRICK_WIDTH =(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
;
 
/** Height of a brick */
private static final int BRICK_HEIGHT = 8;
 
/** Radius of the ball in pixels */
private static final int BALL_RADIUS = 10;
 
/** Offset of the top brick row from the top */
private static final int BRICK_Y_OFFSET = 70;
 
/** Number of turns */
private static final int NTURNS = 3;
/**Ball velocity*/
private double vx, vy;
/**Random number generator for vx*/
private RandomGenerator rgen = RandomGenerator.getInstance();
/** Animation delay or paust time between ball moves */
private static final int DELAY = 10;
private static final GObject NULL = null;

private GRect brick;
private GRect paddle;
private GOval ball;
RandomGenerator rgen1 = RandomGenerator.getInstance();
GObject collider;
GImage image;

public void run()
{ 
    
	setup();
	playgame();
}


private void playgame() 
{
	waitForClick();
	moveball();	
}


public void setup()
{
	image =new  GImage("break.jpg");
    add(image,0,0);
	createbricks();
	createpaddle();
	createball();
}


public void createbricks()
{
	for(int i=0;i<NBRICK_ROWS;i++)
	{
		for(int j=0;j< NBRICKS_PER_ROW ;j++)
		{
		     brick=new GRect((BRICK_WIDTH+BRICK_SEP)*j,BRICK_Y_OFFSET+(BRICK_HEIGHT+BRICK_SEP)*i,BRICK_WIDTH,BRICK_HEIGHT);
			 brick.setFilled(true);
		     add(brick);
		
      switch(i)
      {
      case 0:brick.setColor(Color.RED);break;
      case 1:brick.setColor(Color.RED);break;
      case 2:brick.setColor(Color.ORANGE);break;
      case 3:brick.setColor(Color.ORANGE);break;
      case 4:brick.setColor(Color.YELLOW);break;
      case 5:brick.setColor(Color.YELLOW);break;
      case 6:brick.setColor(Color.GREEN);break;
      case 7:brick.setColor(Color.GREEN);break;
      case 8:brick.setColor(Color.CYAN);break;
      case 9:brick.setColor(Color.CYAN);break;
      default:break;
      }
     add(brick);
		}
	}
}


public void createpaddle()
{
    paddle=new GRect(WIDTH/2- PADDLE_WIDTH/2,HEIGHT-PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
    paddle.setFilled(true);
    paddle.setFillColor(Color.BLACK);
    add(paddle);
    addMouseListeners();
}

public void mouseMoved(MouseEvent e)
{
	if (e.getX()<WIDTH-PADDLE_WIDTH  && e.getX()>=0 )
	{
		paddle.setLocation(e.getX(),HEIGHT-PADDLE_Y_OFFSET);
	}
	else
		if(e.getX()>WIDTH-PADDLE_WIDTH )
		{
			paddle.setLocation(WIDTH-PADDLE_WIDTH,HEIGHT-PADDLE_Y_OFFSET);
		}
}
		
		
public void createball()
{
	ball=new GOval(WIDTH/2-BALL_RADIUS,HEIGHT-PADDLE_Y_OFFSET-BALL_RADIUS-PADDLE_HEIGHT,2*BALL_RADIUS,2*BALL_RADIUS);
	ball.setFilled(true);
	ball.setColor(Color.GRAY);
	add(ball);
}

public void moveball()
{
	vx=rgen1.nextDouble(1.0,3.0);
	if(rgen1.nextBoolean(.5)) vx=-vx;
	vy=-3.0;
	while(true)
	{
		ball.move(vx, vy);
		pause(DELAY);
		checkWall();
	    collider=getCollidingObject();
	    
	    GObject collider = getCollidingObject();
	    if (collider == paddle) 
	    {
	    	if (vx > 0 && ball.getX() < (paddle.getX() + (PADDLE_WIDTH * 0.2)))
	    	{
	    	    vx = 1.5 + vx;
	    	    vx = -vx;
	    	    vy = -vy;
	    	   }
	    	else
	    	if (vx < 0 && ball.getX() < (paddle.getX() + (PADDLE_WIDTH * 0.2)))
	    		{
	    	    vx = 2 * vx;
	    	    vy = -vy;
	    	    }
	    		else
	    		if (vx < 0 && ball.getX() > (paddle.getX() + (PADDLE_WIDTH * 0.8)))
	    		{
	    	    vx = 1.5 + vx;
	    	    vx = -vx;
	    	    vy = -vy;
	    	    }
	    	    else
	    	    if (vx > 0 && ball.getX() > (paddle.getX() + (PADDLE_WIDTH * 0.8)))
	    	    {
	    	    vx = 2 * vx;
	    	    vy = -vy;
	    	    }
	    	    else
	    	    vy = -vy;
	    }
	    else 
	    if (collider != null) {
	    remove(collider);
	    vy = -vy;
	    }
	    if (ball.getY() >= getHeight())
	    break;
	}
	printGameOver();
}

public void checkWall()
{
	if(ball.getX()<=0)
	{
		vx=-vx;
	}
	else if(ball.getX()>=WIDTH)
		{
			vx=-vx;
		}
		else if(ball.getY()<=0)
		{
			vy=-vy;
		}
}

private GObject getCollidingObject()
{
if((getElementAt(ball.getX(), ball.getY())) != null)
{
return getElementAt(ball.getX(), ball.getY());
}
else if (getElementAt( (ball.getX() + BALL_RADIUS*2), ball.getY()) != null )
{
return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY());
}
else if(getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS*2)) != null )
{
return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS*2);
}
else if(getElementAt((ball.getX() + BALL_RADIUS*2), (ball.getY() + BALL_RADIUS*2)) != null )
{
return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY() + BALL_RADIUS*2);
}
else
{
return null;
}
}

public void printGameOver() 
{
GLabel gameOver = new GLabel ("Game Over", getWidth()/2, getHeight()/2);
gameOver.move(-gameOver.getWidth()/2, -gameOver.getHeight());
gameOver.setColor(Color.RED);
gameOver.setFont("SanSerif-100");
while(true)
{
	add(gameOver);
	pause(100);
	remove(gameOver);
}
}
}


