package prv.mark.test.patterns.bridgepattern;

/**
 * https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
