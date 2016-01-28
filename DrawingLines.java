
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
public class DrawingLines extends GraphicsProgram {
public void run() {
addMouseListeners();
}
public void mousePressed(MouseEvent e) {
double x = e.getX();
double y = e.getY();
line = new GLine(x, y, x, y);
add(line);
}
public void mouseDragged(MouseEvent e) {
double x = e.getX();
double y = e.getY();
line.setEndPoint(x, y);
}
private GLine line;
}
