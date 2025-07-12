import java.awt.Image;
import java.awt.event.KeyEvent;

public class Tube {

    private static final int START_X = 500;
    private static final int SPEED = 2;

    public int x;
    public int y;
    public boolean currentEnnemy;
    public int spawnedOneTube;

    private Image image;
    
    public Tube () {
        x = START_X;
        y = 0;
        spawnedOneTube=0;
    }

    public void update () {
        x -= SPEED;
    }

    public Image getImage () {

        if (image == null) {
            image = Util.loadImage("lib/tube.png");     
        }
        
        return image;
    }
}
