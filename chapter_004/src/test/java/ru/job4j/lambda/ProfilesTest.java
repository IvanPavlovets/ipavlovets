package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.stream.Profile;
import ru.job4j.stream.Profiles;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCallCollectThenGetAddressList() {
        Profiles profiles1 = new Profiles();
        Profile profile1 = new Profile();
        Profile profile2 = new Profile();
        Profile profile3 = new Profile();
        List<Profile> profiles = Arrays.asList(profiles1.createProfile(profile1, "A", "AA", 5, 10),
                profiles1.createProfile(profile2, "A", "AA", 5, 12),
                profiles1.createProfile(profile3, "A", "AA", 5, 15)
        );
        List<Profile.Address> result = profiles1.coolect(profiles);
        List<Profile.Address> expected = Arrays.asList(profiles1.createAddress(profile1, "A", "AA", 5, 10),
                profiles1.createAddress(profile2, "A", "AA", 5, 12),
                profiles1.createAddress(profile3, "A", "AA", 5, 15)
        );
        assertThat(result, is(expected));
    }
}
