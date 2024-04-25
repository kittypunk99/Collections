package tests;

import collections.LottoTipp;

import static collections.LottoTipp.createLottoTipps;
import static collections.LottoTipp.printCalcGewinn;

/**
 * This class is used to test the functionality of the LottoTipp class.
 * It extends the Thread class and overrides the run method to perform the tests.
 */
public class LottoTippTests extends Thread {
    /**
     * The run method is called when the thread is started.
     * It creates a new LottoTipp, prints it, creates a set of 5 LottoTipps and prints them,
     * and finally prints the calculated winnings for 10 seconds.
     */
    @Override
    public void run() {
        // Create a new LottoTipp and print it.
        LottoTipp lottoTipp = new LottoTipp();
        System.out.println("lottoTipp = " + lottoTipp);

        // Create a set of 5 LottoTipps and print them.
        System.out.println("createLottoTipps(5) = " + createLottoTipps(5));

        // Print the calculated winnings for 10 seconds.
        printCalcGewinn(10);
    }
}