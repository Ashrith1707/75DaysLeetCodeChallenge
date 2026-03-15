import java.util.ArrayList;
import java.util.List;

class Fancy {
    private static final long MOD = 1_000_000_007;
    private List<Long> nums;
    private long multiplier;
    private long increment;

    public Fancy() {
        nums = new ArrayList<>();
        multiplier = 1;
        increment = 0;
    }

    public void append(int val) {
        // We want: (x * multiplier + increment) % MOD = val
        // So: x = (val - increment) * inv(multiplier) % MOD
        long inverse = modInverse(multiplier, MOD);
        long normalized = ((val - increment + MOD) % MOD * inverse) % MOD;
        nums.add(normalized);
    }

    public void addAll(int inc) {
        increment = (increment + inc) % MOD;
    }

    public void multAll(int m) {
        multiplier = (multiplier * m) % MOD;
        increment = (increment * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) return -1;
        // Result = (normalized_x * current_multiplier + current_increment) % MOD
        long result = (nums.get(idx) * multiplier) % MOD;
        result = (result + increment) % MOD;
        return (int) result;
    }

    // Fermat's Little Theorem for Modular Inverse: a^(MOD-2) % MOD
    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long x, long y, long mod) {
        long res = 1;
        x %= mod;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}