package ru.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Dborisov on 06.05.2016.
 */
public class PrimeTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeSq() {
        Assert.assertFalse(Primes.isPrimeFast(25));
    }

    @Test(enabled = false)
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testNoPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
