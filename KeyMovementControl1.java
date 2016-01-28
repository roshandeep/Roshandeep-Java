
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.awt.*;


public class KeyMovementControl1 extends GraphicsProgram
{
final int WAIT = 20;
final int MV_AMT = 5;
int xMove, yMove;


public void init( )
{
xMove = yMove = 0;
addKeyListeners( );
} 

public void keyPressed(KeyEvent e)
{
int key = e.getKeyCode( );
if (key == KeyEvent.VK_UP)
{ yMove = -MV_AMT; }
else if (key == KeyEvent.VK_RIGHT)
{ xMove = MV_AMT; }
else if (key == KeyEvent.VK_DOWN)
{ yMove = MV_AMT; }
else if (key == KeyEvent.VK_LEFT)
{ xMove = -MV_AMT; }
}


public void run( )
{
GOval o = new GOval(40, 40);
o.setColor(Color.RED);
o.setFilled(true);
add(o, 100, 100);
while(true) 
{
pause(WAIT);
o.move(xMove, yMove);
xMove = yMove = 0;
} 
} 
}