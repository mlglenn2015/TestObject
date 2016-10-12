package prv.mark.test.patterns.bridgepattern;

/**
 * https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }

}
