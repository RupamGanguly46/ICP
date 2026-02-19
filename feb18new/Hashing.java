package feb18new;

public class Hashing {
    // a = 1, p = 16, l = 12, e = 5
    // hashValue = (1 * 31^0) + (16 * 31^1) + (16 * 31^2) + (12 * 31^3) + (5 * 31^4)
    // O(n)

    // What if we want to find hashcode of substrings?
    // We need to calculate again and again
    // to avoid this, Rabin Karp algorithm (doesn't guarantee right answer)
    // KMP algorithm is smaller.
    public static void main(String[] args) {
        String s = "apple";
        long hashValue = 0;
        long multiplier = 1;
        long primeNumber = 31;
        long mod = 1000_000_007;
        for(int i = 0; i < s.length(); i++){
            hashValue = (hashValue + (s.charAt(i) - 'a' + 1) % mod) % mod;
            multiplier = (multiplier * primeNumber) % mod;
        }

        System.out.println(hashValue);
    }
    
}
