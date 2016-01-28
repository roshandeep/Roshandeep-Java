
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
public class abc extends GraphicsProgram
{
	public void run() 
	{
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		double r = FIGURE_SIZE / 2;
		GArc bigBlack = new GArc( 2 * r, 2 * r, -90, 180);
		bigBlack.setFilled(true);
		add(bigBlack);
	}
	private static final double FIGURE_SIZE = 150;
}
