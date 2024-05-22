package com.example.securecapita.query;

public class UserQuery {
    public static final String INSERT_USER_QUERY = "INSERT INTO securecapita.users (first_name, last_name, email, password) VALUES (:firstName, :lastName, :email, :password)";
    public static final String COUNT_USER_EMAIL_QUERY = "SELECT COUNT(*) FROM securecapita.users WHERE email = :email";
    public static final String INSERT_ACCOUNT_VERIFICATION_URL_QUERY = "INSERT INTO securecapita.account_verifications (user_id, url) VALUES (:userId, :url)";
}
