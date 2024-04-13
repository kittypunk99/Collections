package tests;

import collections.Statistik;

import java.nio.file.Path;

public class StatistikTests extends Thread {
    @Override
    public void run() {
        Statistik s = new Statistik(Path.of("ressources/vornamen.txt"), Path.of("ressources/geburtstage.txt"));
        System.out.println("s.countPupilsWithDoubleBirthdays() = " + s.countPupilsWithDoubleBirthdays());
        System.out.println("s.containsFirstName(\"Isabella\") = " + s.containsFirstName("Isabella"));
    }
}
