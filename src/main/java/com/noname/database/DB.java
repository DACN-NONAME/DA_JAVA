/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author phatv
 */
public class DB {

    private Connection con;
    private Statement stmt;

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://pma.phatnef.me/phatdevx_dat_ve_phim?user=phatdevx_noname&password=Noname@2023&useUnicode=true&characterEncoding=UTF-8";
            Connection conn = DriverManager.getConnection(URL);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error db: " + ex.toString());
            return null;
        }
    }

    public DB() {
        try {
            con = getConnection();
            stmt = con.createStatement();
        } catch (SQLException ex) {
        }
    }

    public int Update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
}
