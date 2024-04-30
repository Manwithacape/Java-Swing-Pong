import java.awt.Color;
import java.util.Random;

public class Ball extends GameObject {
    public int xSpeed;
    public int ySpeed;

    private Random r = new Random();

    public Ball(int x, int y, int width, int height, Color color, String name, int xSpeed, int ySpeed) {
        super(x, y, width, height, color, name);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounce() {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    }

    public void frameUpdate() {


        //if ball hits the top or bottom of the room bounce 
        if (this.y+ySpeed < 0 || this.y+ySpeed > 600 - this.height) {
            this.ySpeed += r.nextInt(3) - 2; // add a random number between -1 and 1 to the ySpeed
            this.ySpeed = -this.ySpeed;
            
        }

        //if the ball hits the back wall bounce
        if (this.x+xSpeed < 0) {
            this.xSpeed = -this.xSpeed;
        }

        // if the ball hits the player paddle bounce
        if (intersect(JavaPongApp.playerPaddle)) {
            this.xSpeed = -this.xSpeed;
            this.ySpeed = -this.ySpeed;
            this.ySpeed += r.nextInt(3) - 2; // add a random number between -1 and 1 to the ySpeed
        }


        //if ball leaves the right side of the room close frame and end program
        if (this.x+xSpeed > 820) {
            System.exit(0);
        }

        this.x += xSpeed;
        this.y += ySpeed;
        
    }
}
