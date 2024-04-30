import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;



public class GameSurface extends JPanel {
    Timer timer;
    public GameSurface() {
       
        this.setPreferredSize(new Dimension(800, 600));

        int delay = 1000 / 60; // 60 FPS
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JavaPongApp.steps += 1;
                //System.out.println("Step " + JavaPongApp.steps);
                for (GameObject obj: JavaPongApp.gameObjects) {
                    obj.frameUpdate();
                }
                repaint();
            }
        });
        timer.start(); // Start the timer

    }
    @Override
    public void paintComponent(Graphics g) {
        //draw the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        // Draw every GameObject in the game
        for (GameObject obj : JavaPongApp.gameObjects) {
            if (obj.color != null) {
                g.setColor(obj.color);
                g.fillRect(obj.x, obj.y, obj.width, obj.height);
            } else {
                g.drawImage(obj.image, obj.x, obj.y, null);
            }
        }
    }
}
