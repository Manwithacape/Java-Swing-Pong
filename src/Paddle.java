import java.awt.Color;

public class Paddle extends GameObject{
    public int xSpeed;
    public int ySpeed;

    public Paddle(int x, int y, int width, int height, Color color, String name, int xSpeed, int ySpeed) {
        super(x, y, width, height, color, name);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }


    public void frameUpdate() {
        int moveDirection = (JavaPongApp.isSPressed() ? 1 : 0) - (JavaPongApp.isWPressed() ? 1 : 0);
        ySpeed = moveDirection * 15;

        //Limit the paddle to the screen
        if (((y)+ySpeed)+15 < 0) {
            ySpeed = 0;
        }

        if (((y + height)+ySpeed)-15 > 600) {
            ySpeed = 0;
        }

        y += ySpeed;
        
    }


    public int getYSpeed() {
        return ySpeed;
    }


}

