package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Statistik {
    private final Set<String> fn;
    private final List<String> bd;

    public Statistik(Path firstNamesFile, Path birthdaysFile) {
        ArrayList<String> b = new ArrayList<>(readLines(firstNamesFile));
        fn = new HashSet<>();
        b.forEach(s -> fn.add(s.split(" ")[0]));
        bd = new ArrayList<>(readLines(birthdaysFile));
    }

    public static List<String> readLines(Path file) {
        try (BufferedReader r = Files.newBufferedReader(file)) {
            return r.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean containsFirstName(String firstName){
        return fn.contains(firstName);
    }

    public int countPupilsWithDoubleBirthdays(){
       HashSet<String> u = new HashSet<>();
       HashSet<String> d = new HashSet<>();
       bd.forEach(s -> {
           if (!u.add(s)){
               d.add(s);
           }
       });
       return bd.size()-u.size()+d.size();
    }
}