package ru.sandbox;

//import org.testng.Assert;
//import org.testng.annotations.Test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Naum.Ginzburg on 09.05.2017.
 */
public class SquareTests {
    @Test
    public void TestArea() {
        Square s = new Square(5);
        Assert.assertEquals(25, s.area(), 0.001);
    }

}
