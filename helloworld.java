import acm.graphics.*;
import java.awt.Color;
import acm.program.*;
public class helloworld extends GraphicsProgram {
	public void run() {
		GLabel Label=new GLabel("Hello World",100,75);
		Label.setFont("SanSerif-36");
		Label.setColor(Color.RED);
		add(Label );
		
	}

}
