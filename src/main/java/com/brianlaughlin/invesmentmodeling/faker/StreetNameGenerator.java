package com.brianlaughlin.invesmentmodeling.faker;

import com.github.javafaker.Faker;

public class StreetNameGenerator {
    public static Faker generator = new Faker();

    public static String generateAddress() {

        return generator.address().streetAddressNumber() + " " + generator.address().streetName();

    }

}
