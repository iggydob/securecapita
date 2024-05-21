CREATE SCHEMA IF NOT EXISTS securecapita;

SET client_encoding TO 'UTF8';
SET TIME ZONE 'Europe/Sofia';

DROP TABLE IF EXISTS securecapita.Users;

CREATE TABLE securecapita.Users
(
    users_id   BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR(255) DEFAULT NULL,
    address    VARCHAR(255) DEFAULT NULL,
    phone      VARCHAR(30)  DEFAULT NULL,
    title      VARCHAR(50)  DEFAULT NULL,
    bio        VARCHAR(255) DEFAULT NULL,
    enabled    BOOLEAN      DEFAULT FALSE,
    non_locked BOOLEAN      DEFAULT TRUE,
    using_mfa  BOOLEAN      DEFAULT FALSE,
    created_at TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    image_url  VARCHAR(255) DEFAULT 'https://img.icons8.com/?size=100&id=43964&format=png&color=000000',
    CONSTRAINT UQ_Users_Email UNIQUE (email)
);

DROP TABLE IF EXISTS securecapita.Roles;

CREATE TABLE securecapita.Roles
(
    roles_id   BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL,
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Roles_Name UNIQUE (name)
);

DROP TABLE IF EXISTS securecapita.UserRoles;

CREATE TABLE securecapita.UserRoles
(
    user_roles_id BIGSERIAL PRIMARY KEY,
    user_id       BIGINT NOT NULL,
    role_id       BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES securecapita.Users (users_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES securecapita.Roles (roles_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT UQ_UserRoles_User_Id UNIQUE (user_id)
);

DROP TABLE IF EXISTS securecapita.Events;

CREATE TABLE securecapita.Events
(
    events_id   BIGSERIAL PRIMARY KEY,
    type        VARCHAR(50)  NOT NULL CHECK (type IN
                                             ('LOGIN_ATTEMPT', 'LOGIN_ATTEMPT_FAILURE', 'LOGIN_ATTEMPT_SUCCESS',
                                              'PROFILE_UPDATE', 'PROFILE_PICTURE_UPDATE', 'ROLE_UPDATE',
                                              'ACCOUNT_SETTINGS_UPDATE', 'PASSWORD_UPDATE', 'MFA_UPDATE')),
    description VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Events_Type UNIQUE (type)
);

DROP TABLE IF EXISTS securecapita.UserEvents;

CREATE TABLE securecapita.UserEvents
(
    user_events_id BIGSERIAL PRIMARY KEY,
    user_id        BIGINT NOT NULL,
    event_id       BIGINT NOT NULL,
    device         VARCHAR(100) DEFAULT NULL,
    ip_address     VARCHAR(100) DEFAULT NULL,
    created_at     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES securecapita.Users (users_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (event_id) REFERENCES securecapita.Events (events_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS securecapita.AccountVerifications;

CREATE TABLE securecapita.AccountVerifications
(
    account_verifications_id BIGSERIAL PRIMARY KEY,
    user_id                  BIGINT       NOT NULL,
    url                      VARCHAR(255) NOT NULL,
    -- date     TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES securecapita.Users (users_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_AccountVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_AccountVerifications_Url UNIQUE (url)
);

DROP TABLE IF EXISTS securecapita.ResetPasswordVerifications;

CREATE TABLE securecapita.ResetPasswordVerifications
(
    reset_password_verifications_id BIGSERIAL PRIMARY KEY,
    user_id                         BIGINT       NOT NULL,
    url                             VARCHAR(255) NOT NULL,
    expiration_date                 TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES securecapita.Users (users_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_ResetPasswordVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_ResetPasswordVerifications_Url UNIQUE (url)
);

DROP TABLE IF EXISTS securecapita.TwoFactorVerifications;

CREATE TABLE securecapita.TwoFactorVerifications
(
    two_factor_verifications_id BIGSERIAL PRIMARY KEY,
    user_id                     BIGINT      NOT NULL,
    code                        VARCHAR(10) NOT NULL,
    expiration_date             TIMESTAMP   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES securecapita.Users (users_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_TwoFactorVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_TwoFactorVerifications_Code UNIQUE (code)
);
