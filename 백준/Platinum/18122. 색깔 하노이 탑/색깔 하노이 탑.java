import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger result = BigInteger.valueOf(2).pow(n + 2).subtract(BigInteger.valueOf(5)).mod(BigInteger.valueOf(1000000007));

       System.out.println(result);
    }
}
