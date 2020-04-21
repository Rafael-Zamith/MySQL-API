package br.mack.ps2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection1 {
    private String bd = "Computadores";
    private String url = "jdbc:mysql://127.0.0.1:32775/" + bd;
    private String user = "root";
    private String pswd = "root";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pswd);
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 }