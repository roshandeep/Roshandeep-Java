
import acm.graphics.*;
import acm.program.*;

import acm.util.*;


public class Sound extends GraphicsProgram
{
	public void run( )
	{
		SoundClip x = new SoundClip("[Songs.PK] Mere Mehboob Qayamat Hogi - Kishore Kumar");
		x.setVolume(.8);
		x.play( );
		pause(1000);
		x.stop( );
		waitForClick( );
		x.rewind( );
		x.loop( );
		pause(10000);
		x.stop( );
		pause(3000);
		x.rewind( );
		x.loop( );
	}
}
