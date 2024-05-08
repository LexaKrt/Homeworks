package ru.itis.inf304.lab2_7_test;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {
    @Test
    public void testExp(){
        double r = MathUtil.exp(0.d);
        double eps = 0.0000001;
        Assert.assertEquals(1,r,eps);
//        Assert.assertEquals(22026.465794806718,MathUtil.exp(10.d),eps);
    }
}
