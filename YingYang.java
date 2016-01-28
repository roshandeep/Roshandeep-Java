import acm.program.*;
import acm.graphics.*;
import java.awt.*;
public class YingYang extends GraphicsProgram
{
	public void run() 
	{
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		double r = FIGURE_SIZE / 2;
		GArc bigBlack = new GArc(x - r, y - r, 2 * r, 2 * r, -90, 180);
		bigBlack.setFilled(true);
		add(bigBlack);
		GArc smallWhite = new GArc(x - r / 2, y - r, r, r, -90, 180);
		smallWhite.setFilled(true);
		smallWhite.setColor(Color.WHITE);
		add(smallWhite);
		GArc smallBlack = new GArc(x - r / 2, y, r, r, 90, 180);
		smallBlack.setFilled(true);
		add(smallBlack);
		GArc outerCircle = new GArc(x - r, y - r, 2 * r, 2 * r, 0, 360);
		add(outerCircle);
		GOval oval1 = new GOval(x-r/2,y-r/2,r/4,r/4);
		oval1.setFilled(true);
		add(oval1);
		GOval oval2 = new GOval(x+r/4,y+r/4,r/4,r/4);
		oval2.setColor(Color.WHITE);
		oval2.setFilled(true);
		add(oval2);
		}
			private static final double FIGURE_SIZE = 150;
		}

