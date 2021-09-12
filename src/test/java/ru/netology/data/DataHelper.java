package ru.netology.data;

import lombok.Value;
import com.github.javafaker.Faker;

public class DataHelper {
    private static Faker faker = new Faker();

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidAuthInfo(){
        return new AuthInfo(faker.name().username(), faker.internet().password());
    }

    public static AuthInfo getToBlockAuthInfo(){
        return new AuthInfo("vasya","987987");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static String getInvalidVerificationCode() {
        return String.valueOf(faker.random().nextLong());
    }

}
