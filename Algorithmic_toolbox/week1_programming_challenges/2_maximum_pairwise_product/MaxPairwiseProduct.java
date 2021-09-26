import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        // given all numbers are positive
        int max_value = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > max_value) {
                max_value = numbers[i];
                index = i;
            }
        }
        int second_max_value = -1;
        // find second max value by skipping the index of the max value
        for (int i = 0; i < n; i++) {
            if ((numbers[i] > second_max_value) && (i != index)) {
                second_max_value = numbers[i];
            }
        }
        BigInteger a = BigInteger.valueOf(max_value), b = BigInteger.valueOf(second_max_value);
        return a.multiply(b);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
