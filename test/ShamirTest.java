import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ShamirTest {

    @Test
    public void test2of3ZeroAndOne() {
        Shamir shamir = new Shamir(2, 3);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);
        Shamir resultChecker = new Shamir(2, 3);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[0], secretShares[1]}, shamir.getPrime());
        assertEquals(secret, combine);
    }

    @Test
    public void test2of3OneAndTwo() {
        Shamir shamir = new Shamir(2, 3);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);
        Shamir resultChecker = new Shamir(2, 3);
        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[1], secretShares[2]}, shamir.getPrime());

        assertEquals(secret, combine);
    }

    @Test
    public void test2of3ZeroAndTwo() {
        Shamir shamir = new Shamir(2, 3);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(2, 3);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[0], secretShares[2]}, shamir.getPrime());

        assertEquals(secret, combine);
    }


    @Test
    public void test2of4ZeroAndTwo() {
        Shamir shamir = new Shamir(2, 4);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(2, 4);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[0], secretShares[2]}, shamir.getPrime());

        assertEquals(secret, combine);
    }

    @Test
    public void test2of4ZeroAndOne() {
        Shamir shamir = new Shamir(2, 4);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(2, 4);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[0], secretShares[1]}, shamir.getPrime());

        assertEquals(secret, combine);
    }

    @Test
    public void test2of4OneAndZero() {
        Shamir shamir = new Shamir(2, 4);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(2, 4);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[1], secretShares[2]}, shamir.getPrime());

        assertEquals(secret, combine);
    }

    @Test
    public void test3of4ZeroOneTwo() {
        Shamir shamir = new Shamir(3, 4);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(3, 4);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{secretShares[0], secretShares[1], secretShares[2]}, shamir.getPrime());

        assertEquals(secret, combine);
    }

    @Test
    public void test4of5ZeroOneTwoThree() {
        Shamir shamir = new Shamir(4, 5);
        BigInteger secret = new BigInteger("1234");
        Shamir.SecretShare[] secretShares = shamir.split(secret);

        Shamir resultChecker = new Shamir(4, 5);

        BigInteger combine = resultChecker.combine(new Shamir.SecretShare[]{
                secretShares[0], secretShares[1], secretShares[2], secretShares[3]
        }, shamir.getPrime());

        assertEquals(secret, combine);
    }
}


