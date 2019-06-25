package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public Profile createProfile(Profile pr, String city, String street, int home, int apartment) {
        Profile profile = new Profile(pr.new Address(city, street, home, apartment));
        return profile;
    }

    public Profile.Address createAddress(Profile pr, String city, String street, int home, int apartment) {
        Profile.Address address = pr.new Address(city, street, home, apartment);
        return address;
    }

    public List<Profile.Address> coolect(List<Profile> profiles) {
        List<Profile.Address> addresses = profiles.stream().map(
                profile -> profile.getAddress()
        ).collect(Collectors.toList());
        return addresses;
    }

    public static void main(String[] args) {
        Profile profile1 = new Profile();
        Profile profile2 = new Profile();
        Profile profile3 = new Profile();

        Profiles profiles1 = new Profiles();

        List<Profile> profiles = Arrays.asList(profiles1.createProfile(profile1, "BB", "AA", 5, 10),
                profiles1.createProfile(profile2, "BB", "AA", 5, 10),
                profiles1.createProfile(profile3, "A", "AA", 5, 15)
        );

        System.out.println("Коллекция: " + profiles);

        List<Profile.Address> addresses = Arrays.asList(profiles1.createAddress(profile1, "BB", "AA", 5, 10),
                profiles1.createAddress(profile2, "BB", "AA", 5, 10),
                profiles1.createAddress(profile3, "A", "AA", 5, 15)
        );

        System.out.println("Адресса: " + profiles1.coolect(profiles));
        System.out.println("Адресса1: " + addresses);

        //равенсво
        System.out.println(profiles1.coolect(profiles).equals(addresses));
    }
}

