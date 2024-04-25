package tests;

import collections.Statistik;

import java.nio.file.Path;

/**
 * This class is used to test the functionality of the Statistik class.
 * It extends the Thread class and overrides the run method to perform the tests.
 */
public class StatistikTests extends Thread {
    /**
     * The run method is called when the thread is started.
     * It creates a new Statistik with data from the provided files,
     * prints the number of pupils with double birthdays,
     * and checks if the name "Isabella" is contained in the first names.
     */
    @Override
    public void run() {
        // Create a new Statistik with data from the provided files.
        Statistik s = new Statistik(Path.of("ressources/vornamen.txt"), Path.of("ressources/geburtstage.txt"));

        // Print the number of pupils with double birthdays.
        System.out.println("s.countPupilsWithDoubleBirthdays() = " + s.countPupilsWithDoubleBirthdays());

        // Check if the name "Isabella" is contained in the first names.
        System.out.println("s.containsFirstName(\"Isabella\") = " + s.containsFirstName("Isabella"));
    }
}