package base;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle() {
        this(new Vector2D(), 5, 5);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(0,0), 10, 10);
        Rectangle rect2 = new Rectangle(new Vector2D(5,5), 10, 10);
        Rectangle rect3 = new Rectangle(new Vector2D(5,-15), 10, 10);

        rect1.intersects(rect2); // = true
        rect1.intersects(rect3); // = false
        rect2.intersects(rect3); // = false

        //test result
        System.out.println(rect1.intersects(rect2));
        System.out.println(rect1.intersects(rect3));
        System.out.println(rect2.intersects(rect3));

    }

    public boolean intersects(Rectangle other) {
        int x1 = (int)this.position.x;
        int y1 = (int)this.position.y;
        int w1 = this.width;
        int h1 = this.height;

        int x2 = (int)other.position.x;
        int y2 = (int)other.position.y;
        int w2 = other.width;
        int h2 = other.height;

        if((((x1 <= x2) && (x2 <= x1+w1)) || ((x2 <= x1) && (x1 <= x2+w2)))
            && (((y1 <= y2) && (y2 <= y1+h1)) || ((y2 <= y1) && (y1 <= y2+h2)))) {
            return true;
        } else {
            return false;
        }

    }
}
