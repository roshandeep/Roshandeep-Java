import acm.graphics.*;
import acm.program.*;
import java.awt.event.*; 


public class ReadKeys extends GraphicsProgram
{

	GLabel keyLabel;

public void init( )
{
keyLabel = new GLabel("none");
keyLabel.setFont("*-BOLD-50");
add(keyLabel, 310, 215);
addKeyListeners( );
}



public void keyPressed(KeyEvent k)
{ 
	int key = k.getKeyCode( );
if (key == KeyEvent.VK_UP)
{ 
	keyLabel.setLabel("UP"); }
else
	if (key == KeyEvent.VK_RIGHT)
{
		keyLabel.setLabel("RIGHT"); }
else 
	if (key == KeyEvent.VK_DOWN)
{ 
		keyLabel.setLabel("DOWN"); }
else 
	if (key == KeyEvent.VK_LEFT)
{ 
		keyLabel.setLabel("LEFT"); }
else 
	if (key == KeyEvent.VK_SPACE)
{ 
		keyLabel.setLabel("SPACE"); }
else
	if (key == KeyEvent.VK_A)
{ 
	keyLabel.setLabel("A"); }
else
	if (KeyEvent.VK_B <= key && key <= KeyEvent.VK_Z)
{
		keyLabel.setLabel("B -> Z"); }
else 
	if (KeyEvent.VK_0 <= key && key <= KeyEvent.VK_9)
{ 
		keyLabel.setLabel("0 -> 9"); }
} 


public void run( )
{  }
} 
