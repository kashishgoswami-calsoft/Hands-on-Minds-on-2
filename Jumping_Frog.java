import java.util.HashMap;
import java.util.Map;

public class Jumping_Frog {
    private static final long MOD = 1_000_000_000L;
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        long L = (long) Math.pow(10, 14);
        System.out.println(computeS(L, MOD));
    }

    private static long computeS(long L, long mod) {
        long sum = 0;
        for (long n = 1; n <= L; n++) {
            long fN = computeF(n);
            sum = (sum + (fN * fN % mod) * fN % mod) % mod;
        }
        return sum;
    }

    private static long computeF(long n) {
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        
        long[] dp = new long[(int) (n + 1)];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 1) {
                    dp[i] += dp[i - j];
                }
            }
        }
        memo.put(n, dp[(int) n]);
        return dp[(int) n];
    }
}
