package tests;

/**
 * This class contains all the tests for the application.
 * It includes tests for the Statistik and LottoTipp classes.
 */
public class AllTests {
    /**
     * The main method to run all the tests.
     * @param args The command line arguments. This is not used.
     */
    public static void main(String[] args) {
        // Start the tests for the Statistik class.
        new StatistikTests().start();
        // Start the tests for the LottoTipp class.
        new LottoTippTests().start();
    }
}