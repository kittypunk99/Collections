package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * This class represents a Lotto Tipp, which is a set of 6 unique random numbers between 1 and 45.
 */
public class LottoTipp {
    private final HashSet<Integer> tipp = new HashSet<>();
    private int hashcode = -1;

    /**
     * Constructor for the LottoTipp class.
     * It generates 6 unique random numbers between 1 and 45.
     */
    public LottoTipp() {
        while (tipp.size() < 6) {
            tipp.add((int) (Math.random() * 45 + 1));
        }
    }

    /**
     * This method creates a set of unique LottoTipps.
     * @param n The number of LottoTipps to generate.
     * @return A set of unique LottoTipps.
     * @throws IllegalArgumentException If n is greater than 8145060.
     */
    public static Set<LottoTipp> createLottoTipps(int n) {
        if (n > 8145060) throw new IllegalArgumentException("more LottoTipps than possible");
        HashSet<LottoTipp> lottoTipps = new HashSet<>();
        while (lottoTipps.size() < n) {
            lottoTipps.add(new LottoTipp());
        }
        return lottoTipps;
    }

    /**
     * This method calculates the winnings for a given number of seconds.
     * @param seconds The number of seconds to calculate winnings for.
     * @return An array of winnings.
     */
    public static int[] calcGewinne(int seconds) {
        int[] a = new int[7];
        long startTime = System.nanoTime();
        long elapsedTime;
        LottoTipp l = new LottoTipp();
        do {
            LottoTipp c = new LottoTipp();
            a[l.countEqualsDigits(c)]++;
            elapsedTime = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
        } while (elapsedTime < seconds);
        return a;
    }

    /**
     * This method prints the calculated winnings for a given number of seconds.
     * @param seconds The number of seconds to calculate winnings for.
     */
    public static void printCalcGewinn(int seconds) {
        int[] a = calcGewinne(seconds);
        int sum = 0;
        StringBuilder sb = new StringBuilder("Ein 0-er, 1-er, etc. kam insgesamt vor:\n");
        for (int i = 0; i < a.length; i++) {
            sb.append(String.format("%der: %d\n", i, a[i]));
            sum += a[i];
        }
        sb.append("D.h. insgesamt ist 1 Tipp von .. Tipps notwendig, um einen 1-er, 2-er, ... zu erreichen\n");
        for (int i = 0; i < a.length; i++) {
            sb.append(String.format("%der: 1:%d\n", i, sum / a[i]));
        }
        System.out.println(sb);
    }

    /**
     * This method returns a string representation of the LottoTipp.
     * @return A string representation of the LottoTipp.
     */
    @Override
    public String toString() {
        int[] a = tipp.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        return Arrays.toString(a).substring(1, Arrays.toString(a).length() - 1);
    }

    /**
     * This method counts the number of equal digits between this LottoTipp and another.
     * @param other The other LottoTipp to compare with.
     * @return The number of equal digits.
     */
    public int countEqualsDigits(LottoTipp other) {
        HashSet<Integer> h = new HashSet<>(tipp);
        h.retainAll(other.tipp);
        return h.size();
    }

    /**
     * This method checks if this LottoTipp is equal to another object.
     * @param o The object to compare with.
     * @return True if the object is a LottoTipp and has the same digits, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTipp lottoTipp = (LottoTipp) o;
        return this.countEqualsDigits(lottoTipp) == 6;
    }

    /**
     * This method returns a hash code value for the object.
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (hashcode != -1) return hashcode;
        int[] a = tipp.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        int[] h1 = Arrays.copyOf(a, 3);
        int[] h2 = Arrays.copyOfRange(a, 4, 7);
        int r = 0;
        for (int i = 0; i < 3; i++) {
            r = (r << 6) | ((h1[i] ^ h2[i]) & 0x3f);
        }
        hashcode = r;
        return r;
    }
}