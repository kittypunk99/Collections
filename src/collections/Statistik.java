package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a Statistik, which is used to perform statistical operations on data.
 */
public class Statistik {
    private final Set<String> fn;
    private final List<String> bd;

    /**
     * Constructor for the Statistik class.
     * It initializes the fn and bd with data from the provided files.
     * @param firstNamesFile The file containing first names.
     * @param birthdaysFile The file containing birthdays.
     */
    public Statistik(Path firstNamesFile, Path birthdaysFile) {
        ArrayList<String> b = new ArrayList<>(readLines(firstNamesFile));
        fn = new HashSet<>();
        b.forEach(s -> fn.add(s.split(" ")[0]));
        bd = readLines(birthdaysFile);
    }

    /**
     * This method reads lines from a file.
     * @param file The file to read lines from.
     * @return A list of lines read from the file.
     * @throws RuntimeException If an IOException occurs.
     */
    public static List<String> readLines(Path file) {
        try (BufferedReader r = Files.newBufferedReader(file)) {
            return r.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method checks if a first name is contained in the fn set.
     * @param firstName The first name to check.
     * @return True if the first name is contained in the fn set, false otherwise.
     */
    public boolean containsFirstName(String firstName) {
        return fn.contains(firstName);
    }

    /**
     * This method counts the number of pupils with double birthdays.
     * @return The number of pupils with double birthdays.
     */
    public int countPupilsWithDoubleBirthdays() {
        HashSet<String> u = new HashSet<>();
        HashSet<String> d = new HashSet<>();
        bd.forEach(s -> {
            if (!u.add(s)) {
                d.add(s);
            }
        });
        return bd.size() - u.size() + d.size();
    }
}