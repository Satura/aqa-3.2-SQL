package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;

public class ConnectionHelper {

    private ConnectionHelper() {    }

    private final static Connection conn = establishConnection();
    private final static QueryRunner runn = new QueryRunner();

    @SneakyThrows
    private static Connection establishConnection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_app", "app", "pass");
    }

    @SneakyThrows
    public static String getCode() {
        return runn.query(conn, "SELECT code FROM auth_codes", new ScalarHandler<>());
    }

}
