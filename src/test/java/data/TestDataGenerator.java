package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }
}


