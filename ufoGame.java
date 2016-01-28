
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
public class ufoGame<Glabel> extends GraphicsProgram
{
	
	private static final int UFO_WIDTH = 40;
	private static final int UFO_HEIGHT = UFO_WIDTH / 2;
	private static final int UFO_SPEED = 5;
		private static final int BULLET_SPEED = 10;
	private static final int BULLET_DIAM = 5;
		private static final int DELAY = 10;
	public void run() 
	{
		setup();
		while (!gameOver())
		{ 
			moveUFO();
			moveBullet();
			checkForCollisions();
			pause(DELAY);
			}
		}
	
	private void setup()
	{
		ufo = new GRect(UFO_WIDTH, UFO_HEIGHT);
		ufo.setFilled(true); 
		add(ufo, getWidth(), 0);
				ufoToLeft = true;
		addMouseListeners(); 
		}
	
	private boolean gameOver()
	{
		return (ufo == null) || (ufo.getY() >= getHeight() - UFO_HEIGHT);
		}
	

public void mouseClicked(MouseEvent e)
{
	if (bullet == null)
	{
		bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
		bullet.setFilled(true);
		bullet.setColor(Color.RED);
		add(bullet, (getWidth() - BULLET_DIAM) / 2, getHeight() - BULLET_DIAM);
		}
	}
 
private void moveUFO()
{
	if (ufoToLeft)
	{
		ufo.move(-UFO_SPEED, 0);
		if (ufo.getX() <= 0)
		{
			ufoToLeft = false;
			ufo.move(0, UFO_HEIGHT);
			}
		}
	else
	{
		ufo.move(UFO_SPEED, 0);
		if (ufo.getX() >= getWidth() - UFO_WIDTH)
		{
			ufoToLeft = true;
			ufo.move(0, UFO_HEIGHT);
			}
		}
	}

private void moveBullet()
{
	if (bullet != null) 
	{
		bullet.move(0, -BULLET_SPEED);
		}
	}
 
private void checkForCollisions()
{
	collideWithUFO();
	moveOffScreen();
	}

 
private void collideWithUFO()
{
	if (bullet != null)
	{
		GObject collObj = getElementAt(bullet.getX(), bullet.getY());
		if (collObj == ufo) 
		{
			remove(ufo);
			remove(bullet);
			ufo = null;
			bullet = null;
			label=new GLabel("GAME OVER",100,75);
			label.setFont("SanSerif-100");
			while(true)
			{
				add(label);
				//pause(10);
				remove(label);
			}
		}
		}
	}

private void moveOffScreen()
{
	if (bullet != null)
	{
		if (bullet.getY() <= BULLET_DIAM)
		{
			remove(bullet);
			bullet = null;
			}
		}
	}
private GRect ufo;
private GOval bullet;
private boolean ufoToLeft;
private GLabel label;
}
