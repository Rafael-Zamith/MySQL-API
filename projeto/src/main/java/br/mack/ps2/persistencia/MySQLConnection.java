package br.mack.ps2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    private String bd = "trabalhops2";
    private String url = "jdbc:mysql://dorime.dlinkddns.com:3306/" + bd;
    private String user = "root";
    private String pswd = "WzYFLqKQ2KfvARE4";

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