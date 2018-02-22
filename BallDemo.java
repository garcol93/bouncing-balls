import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        // crate and show the balls
        Random random = new Random();       
        // crate and show the balls
        for(int i=0; i<numBolas; i++){  
            int x = random.nextInt(50)+10;
            int y =random.nextInt(60)+10;
            int diametro= random.nextInt(25)+5;             
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            
            BouncingBall ball = new BouncingBall(x, 50, diametro, color, ground, myCanvas);
            ball.draw();
            bolas.add(ball);            
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < numBolas; i++ ){
                bolas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if(bolas.get(i).getXPosition() >= 550){
                    finished = true;
                }
            }

        }
    }
}
