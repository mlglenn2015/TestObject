package prv.mark.test.dependencyinjection;

import prv.mark.test.domain.Circle;
import prv.mark.test.domain.Square;

/**
 * http://programmers.stackexchange.com/questions/232229/understanding-dependency-injection?rq=1
 * Created by mlglenn on 10/7/2016.
 */
public class DIPoorExample {

    private Square square;
    private Circle circle;

    /*
     This already is the most simple form of dependency injection. But this still is not a good
     example because everything has to be done manually (also, because the caller can hold a
     reference to our internal objects and thus invalidate our state) (See DIFactoryTests as a remedy)
     */
    public DIPoorExample(Square square, Circle circle) {
        this.square = square;
        this.circle = circle;
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
