package ru.job4j.stream;

public class Profile {
    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Profile{"
                +
                "address="
                +
                address
                +
                '}';
    }

    public class Address {
        private String city;
        private String street;

        private int home;
        private int apartment;

        public Address() {
        }

        public Address(String city, String street, int home, int apartment) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.apartment = apartment;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Address{"
                    +
                    "city='"
                    + city
                    +
                    '\''
                    +
                    ", street='"
                    +
                    street
                    +
                    '\''
                    +
                    ", home="
                    +
                    home
                    +
                    ", apartment="
                    +
                    apartment
                    +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Address)) {
                return false;
            }

            Address address = (Address) o;

            if (home != address.home) {
                return false;
            }
            if (apartment != address.apartment) {
                return false;
            }
            if (!city.equals(address.city)) {
                return false;
            }
            return street.equals(address.street);
        }

        @Override
        public int hashCode() {
            int result = city.hashCode();
            result = 31 * result + street.hashCode();
            result = 31 * result + home;
            result = 31 * result + apartment;
            return result;
        }
    }
}

