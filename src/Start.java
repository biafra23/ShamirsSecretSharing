import java.math.BigInteger;

public class Start {

    public final static void main(String[] args) {

        Shamir shamirSplitter = new Shamir(2, 3);
        Shamir.SecretShare[] shares = shamirSplitter.split(new BigInteger("1234"));

        Shamir shamirCombinator = new Shamir(2, 3);
        System.out.println("Result: " + shamirCombinator.combine(new Shamir.SecretShare[]{shares[0], shares[1]}, shamirSplitter.getPrime()));
        System.out.println("Result: " + shamirCombinator.combine(new Shamir.SecretShare[]{shares[1], shares[2]}, shamirSplitter.getPrime()));
        System.out.println("Result: " + shamirCombinator.combine(new Shamir.SecretShare[]{shares[0], shares[2]}, shamirSplitter.getPrime()));
//        System.out.println("Result: " + shamirCombinator.combine(new Shamir.SecretShare[]{shares[1], shares[3]}, shamirSplitter.getPrime()));
//        System.out.println("Result: " + shamirCombinator.combine(new Shamir.SecretShare[]{shares[3], shares[4]}, shamirSplitter.getPrime()));
    }
}
