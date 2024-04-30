import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class JavaPongApp {

    // Core Data structure for the game
    public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    public static int steps = 0;
    public static GameObject playerPaddle;

    private static volatile boolean wPressed = false;
    public static boolean isWPressed() {
        synchronized (JavaPongApp.class) {
            return wPressed;
        }
    }

    private static volatile boolean sPressed = false;
    public static boolean isSPressed() {
        synchronized (JavaPongApp.class) {
            return sPressed;
        }
    }

    public static void main(String[] args) throws Exception {

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (JavaPongApp.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = true;
                        }

                        if (ke.getKeyCode() == KeyEvent.VK_S) {
                            sPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = false;
                        }


                        if (ke.getKeyCode() == KeyEvent.VK_S) {
                            sPressed = false;
                        }
                        break;
                    }
                    return false;
                }
            }
        });

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGame();
            }
        });

        
    }

    public static void createAndShowGame() {
        // Create a new JFrame
        JFrame gameFrame = new JFrame("Java Pong");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);


        // Add a new Ball to the game
        gameObjects.add(new Ball(400, 300, 20, 20, Color.WHITE, "Ball", -10, -1));

        playerPaddle = new Paddle(750, 250, 20, 100, Color.WHITE, "Paddle 1", 0, 0);
        gameObjects.add(playerPaddle);

        // Add a new GameSurface to the JFrame
        gameFrame.add(new GameSurface());
        gameFrame.setVisible(true);
    }

    
}
