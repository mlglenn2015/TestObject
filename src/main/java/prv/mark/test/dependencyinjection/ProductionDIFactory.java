package prv.mark.test.dependencyinjection;

import prv.mark.test.domain.Circle;
import prv.mark.test.domain.Square;

/**
 * http://programmers.stackexchange.com/questions/232229/understanding-dependency-injection?rq=1
 * Created by mlglenn on 10/7/2016.
 */
public class ProductionDIFactory implements MyDIFactoryInterface {

    public DIPoorExample makeDIPoorExample() {
        return new DIPoorExample(new Square(), new Circle());
    }

}
