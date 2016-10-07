package prv.mark.test.dependencyinjection;

import prv.mark.test.domain.Circle;
import prv.mark.test.domain.Square;

/**
 * http://programmers.stackexchange.com/questions/232229/understanding-dependency-injection?rq=1
 * Created by mlglenn on 10/7/2016.
 */
public class NonDIExample {
    private Square square;
    private Circle circle;

    /*
     Drawback: When for a test I want to use a mock object for Square. So we can make this more flexible and allow
     instances to be passed via the constructor (See DIPoorExample)
     */
    public NonDIExample() {
        square = new Square();
        circle = new Circle();
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
