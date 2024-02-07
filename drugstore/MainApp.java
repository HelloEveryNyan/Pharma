package ru.aberezhnoy.drugstore;

import ru.aberezhnoy.drugstore.components.Penicillin;
import ru.aberezhnoy.drugstore.components.Salt;
import ru.aberezhnoy.drugstore.components.Water;
import ru.aberezhnoy.drugstore.pharmacy.Pharmacy;
import ru.aberezhnoy.drugstore.pharmacy.PharmacyComparator;
import ru.aberezhnoy.drugstore.pharmacy.Sorter;

import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Pharmacy helpirin = new Pharmacy("helpirin");
        Pharmacy safirin = new Pharmacy("safirin");
        Pharmacy curin = new Pharmacy("curin");

        helpirin
                .addComponent(new Penicillin("PenicillinH", 10, 100))
                .addComponent(new Water("WaterH", 20, 15))
                .addComponent(new Salt("SaltH", 50, 50));

        safirin
                .addComponent(new Penicillin("PenicillinS", 5, 80))
                .addComponent(new Water("WaterS", 10, 10))
                .addComponent(new Salt("SaltS", 3, 300));
        curin
                .addComponent(new Penicillin("PenicillinS", 25, 120))
                .addComponent(new Water("WaterS", 30, 25))
                .addComponent(new Salt("SaltS", 7, 70));

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(helpirin);
        pharmacies.add(safirin);
        pharmacies.add(curin);

        // Вывод отсортированных данных
        System.out.println("\nSort by interPower\n");
        sortPharmaciesByInterPower(pharmacies);

        System.out.println("\nSort by totalPower\n");
        sortPharmaciesByTotalPower(pharmacies);

        System.out.println("\nSort by totalWeight\n");
        sortPharmaciesByTotalWeight(pharmacies, new PharmacyComparator());

        // Можно избавиться от статики в клиентском коде, например с помощью интерфейса
        System.out.println("\nSort via interface\n");

        final Sorter sorter = ph -> {
            Collections.sort(ph);
            System.out.println(ph);
        };

        sorter.sort(pharmacies);
    }

    private static void sortPharmaciesByInterPower(List<Pharmacy> pharmacies) {
        Collections.sort(pharmacies);
        System.out.println(pharmacies);
    }

    private static void sortPharmaciesByTotalPower(List<Pharmacy> pharmacies) {
        pharmacies.sort(Comparator.comparingInt(Pharmacy::getTotalPower));
        System.out.println(pharmacies);
    }

    private static void sortPharmaciesByTotalWeight(List<Pharmacy> pharmacies, Comparator<Pharmacy> comparator) {
        pharmacies.sort(comparator);
        System.out.println(pharmacies);
    }
}


