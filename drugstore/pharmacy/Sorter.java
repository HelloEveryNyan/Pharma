package ru.aberezhnoy.drugstore.pharmacy;

import java.util.Comparator;
import java.util.List;

@FunctionalInterface
public interface Sorter {

    void sort(List<Pharmacy> pharmacies);

    default void sortByTotalPower(List<Pharmacy> pharmacies) {
        pharmacies.sort(Comparator.comparingInt(Pharmacy::getTotalPower));
        System.out.println(pharmacies);
    }

    default void sortByTotalWeight(List<Pharmacy> pharmacies) {
        pharmacies.sort(new PharmacyComparator());
        System.out.println(pharmacies);
    }
}

