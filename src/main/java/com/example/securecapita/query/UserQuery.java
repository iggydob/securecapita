package com.example.securecapita.query;

public class UserQuery {
    public static final String INSERT_USER_QUERY = "INSERT INTO securecapita.users (first_name, last_name, email, password) VALUES (:firstName, :lastName, :email, :password)";
    public static final String COUNT_USER_EMAIL_QUERY = "SELECT COUNT(*) FROM securecapita.users WHERE email = :email";
    public static final String INSERT_ACCOUNT_VERIFICATION_URL_QUERY = "INSERT INTO securecapita.account_verifications (user_id, url) VALUES (:userId, :url)";
    public static final String SELECT_USER_BY_EMAIL_QUERY = "SELECT * FROM securecapita.users WHERE email = :email";
    public static final String DELETE_VERIFICATION_CODE_BY_USER_ID_QUERY = "DELETE FROM securecapita.two_factor_verifications WHERE user_id = :userId";
    public static final String INSERT_VERIFICATION_CODE_QUERY = "INSERT INTO securecapita.two_factor_verifications (user_id, code, expiration_date) VALUES (:userId, :verificationCode, :expirationDate)";
    public static final String SELECT_USER_BY_USER_CODE_QUERY = "SELECT * FROM securecapita.users WHERE user_id = (SELECT user_id FROM securecapita.two_factor_verifications WHERE code = :code)";
    public static final String DELETE_CODE_QUERY = "DELETE FROM securecapita.two_factor_verifications WHERE code = :code";
    public static final String SELECT_CODE_EXPIRATION_QUERY = "SELECT expiration_date < NOW() as is_expired FROM securecapita.two_factor_verifications WHERE code = :code";
    public static final String DELETE_PASSWORD_VERIFICATION_BY_USER_ID_QUERY = "DELETE FROM securecapita.reset_password_verifications WHERE user_id = :userId";
    public static final String INSERT_PASSWORD_VERIFICATION_QUERY = "INSERT INTO securecapita.reset_password_verifications (user_id, url, expiration_date) VALUES (:userId, :url, :expirationDate)";
    public static final String SELECT_EXPIRATION_BY_URL_QUERY = "SELECT expiration_date < NOW() as is_expired FROM securecapita.reset_password_verifications WHERE url = :url ";
    public static final String SELECT_USER_BY_PASSWORD_URL_QUERY = "SELECT * FROM securecapita.users WHERE user_id = (SELECT user_id FROM securecapita.reset_password_verifications WHERE url = :url)";
    public static final String UPDATE_USER_PASSWORD_BY_URL_QUERY = "UPDATE securecapita.users SET password = :password WHERE user_id = (SELECT user_id FROM securecapita.reset_password_verifications WHERE url = :url)";
    public static final String DELETE_VERIFICATION_BY_URL_QUERY = "DELETE FROM securecapita.reset_password_verifications WHERE url = :url";
    public static final String SELECT_USER_BY_ACCOUNT_URL_QUERY = "SELECT * FROM securecapita.users where user_id = (SELECT user_id from securecapita.account_verifications WHERE url = :url)";
    public static final String UPDATE_USER_ENABLED_QUERY = "UPDATE securecapita.users SET enabled = :enabled WHERE user_id = :userId";
}
