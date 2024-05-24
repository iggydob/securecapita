package com.example.securecapita.query;

public class RoleQuery {
    public static final String INSERT_ROLE_TO_USER_QUERY = "INSERT INTO securecapita.user_roles (user_id, role_id) VALUES (:userId, :roleId)";
    public static final String SELECT_ROLE_BY_NAME_QUERY = "SELECT * FROM securecapita.roles WHERE name = :name";
    public static final String SELECT_ROLE_BY_USER_ID_QUERY =
            "SELECT r.role_id, r.name, r.permission FROM securecapita.roles r JOIN securecapita.user_roles ur ON ur.role_id = r.role_id JOIN securecapita.users u ON u.user_id = ur.user_id WHERE u.user_id = :id";
}
