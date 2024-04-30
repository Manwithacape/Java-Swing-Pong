import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class GameObject {
    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;
    public String name;
    public Image image;

    /**
     * Constructor for GameObjects with solid color
     * @param x The x-coordinate of the GameObject
     * @param y The y-coordinate of the GameObject
     * @param width The width of the GameObject
     * @param height The height of the GameObject
     * @param name The name of the GameObject
     * @param color The color of the GameObject
     * @return A new GameObject with the specified parameters
     */
    public GameObject(int x, int y, int width, int height, Color color, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.color = color;
        this.image = null;
    }

    /**
     * Constructor for Image GameObjects
     * @param x The x-coordinate of the GameObject
     * @param y The y-coordinate of the GameObject
     * @param image The Image to display for the GameObject
     * @param name The name of the GameObject
     * @return A new GameObject with the specified parameters
     */
    public GameObject(int x, int y, Image image, String name) {
        this.x = x;
        this.y = y;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.name = name;
        this.color = null;
        this.image = image;
    }

    /**
     * Checks if this GameObject intersects with another GameObject
     * @param other The GameObject to check for intersection with
     * @return True if the GameObjects intersect, false otherwise
     */
    public boolean intersect(GameObject other) {
        if (this.x < other.x + other.width && this.x + this.width > other.x &&
            this.y < other.y + other.height && this.y + this.height > other.y) {
            return true;
        }
        return false;
    }


    /**
     * Draws the GameObject on the screen
     * @param g The Graphics object to draw with
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }


    public void frameUpdate() {
        // Override this method in subclasses to update the GameObject
    }
}