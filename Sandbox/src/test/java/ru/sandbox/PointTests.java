package ru.sandbox;
/**
 * Created by Naum.Ginzburg on 10.05.2017.
 */
//import org.testng.Assert;
//import org.testng.annotations.Test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by DBorisov on 17.04.2016.
 */
public class PointTests {

    Point p1 = new Point(-4, -3);
    Point p2 = new Point(4, 3);

    @Test
    public void testPoint1() {
        Assert.assertEquals(10, p1.distance(p2), 0.001);
    }

    @Test
    public void testPoint2() {
        Assert.assertEquals(10, p2.distance(p1), 0.001);
    }

    @Test
    public void testPoint3() {
        Assert.assertEquals(p1.distance(p2), p2.distance(p1), 0.001);
    }
}