
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
public class RandomCircles extends GraphicsProgram {
private static final int NCIRCLES = 10;
private static final double MIN_RADIUS = 5;
private static final double MAX_RADIUS = 50;
public void run() {
for (int i = 0; i < NCIRCLES; i++) {
double r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
double x = rgen.nextDouble(0, getWidth() - 2 * r);
double y = rgen.nextDouble(0, getHeight() - 2 * r);
GOval circle = new GOval(x, y, 2 * r, 2 * r);
circle.setFilled(true);
circle.setColor(rgen.nextColor());
add(circle);
}
}
private RandomGenerator rgen = RandomGenerator.getInstance();
}