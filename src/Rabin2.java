public final class Rabin2 {

    private Rabin2() {
    }

    public static void main(String[] args) {
        long min = 2;
        long max = 10;

        for (long i = min, j = 1; i <= max; i++) {
            if (isPrime(i, 100)) {
                System.out.println(String.format("%s: %s", j++, i));
            }
        }
    }
    private static boolean isPrime(long candidate, long accuracy) {
        long d, s;

        if (candidate == 2)
            return true;
        if (candidate < 2)
            return false;


        for (d = 0, s = 1; (d & 1) == 0; s++)
            d = (candidate - 1) / fastPow(2, s);

        verification: for (long i = 0; i < accuracy; i++) {

            long base = (long) ((Math.random() * (candidate - 3)) + 2);

            long x = fastPow(base, d, candidate);

            if (x == 1 || x == (candidate - 1))
                continue verification;

            for (long j = 0; j < (s - 1); j++) {
                x = fastPow(x, 2, candidate);
                if (x == 1)
                    return false;
                if (x == (candidate - 1))
                    continue verification;
            }

            return false;
        }

        return true;
    }
    private static long fastPow(long base, long exponent) {
        int shift = 63; // bit position
        long result = base; // (1 * 1) * base = base


        while (((exponent >> shift--) & 1) == 0)
            ;

        while (shift >= 0) {
            result = result * result;
            if (((exponent >> shift--) & 1) == 1)
                result = result * base;
        }

        return result;
    }
    private static long fastPow(long base, long exponent, long modulo) {
        int shift = 63; // bit position
        long result = base; // (1 * 1) * base = base


        while (((exponent >> shift--) & 1) == 0)
            ;

        while (shift >= 0) {
            result = (result * result) % modulo;
            if (((exponent >> shift--) & 1) == 1)
                result = (result * base) % modulo;
        }

        return result;
    }
}
 