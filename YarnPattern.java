
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.util.*;
 
public class YarnPattern extends GraphicsProgram {
 
   public void run() {
      ArrayList pegs = createPegList();
      int thisPeg = 0;
      int nextPeg = -1;
      while (thisPeg != 0 || nextPeg == -1) {
         nextPeg = (thisPeg + DELTA) % pegs.size();
         GPoint p0 = (GPoint) pegs.get(thisPeg);
         GPoint p1 = (GPoint) pegs.get(nextPeg);
         GLine line = new GLine(p0.getX(), p0.getY(),
                                p1.getX(), p1.getY());
         line.setColor(Color.MAGENTA);
         add(line);
         thisPeg = nextPeg;
      }
   }
 
   private ArrayList createPegList() {
      ArrayList pegs = new ArrayList();
      for (int i = 0; i < N_ACROSS; i++) {
         pegs.add(new GPoint(i * PEG_SEP, 0));
      }
      for (int i = 0; i < N_DOWN; i++) {
         pegs.add(new GPoint(N_ACROSS * PEG_SEP, i * PEG_SEP));
      }
      for (int i = N_ACROSS; i > 0; i--) {
         pegs.add(new GPoint(i * PEG_SEP, N_DOWN * PEG_SEP));
      }
      for (int i = N_DOWN; i > 0; i--) {
         pegs.add(new GPoint(0, i * PEG_SEP));
      }
      return pegs;
   }
 
   private static final int N_ACROSS = 50;
   private static final int N_DOWN = 30;
   private static final int PEG_SEP = 10;
   private static final int DELTA = 67;
 
} 
