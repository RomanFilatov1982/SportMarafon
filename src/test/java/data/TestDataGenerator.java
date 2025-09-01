package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String generateUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password();
    }
}


