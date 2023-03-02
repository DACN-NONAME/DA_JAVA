/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private PreparedStatement pstmt = null;

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://pma.phatnef.me/phatdevx_dat_ve_phim?user=phatdevx_noname&password=Noname@2023&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
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
            System.out.println("Error connecting to database.");
        }
    }

    // SELECT
    public ResultSet Query(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error query 1a: " + ex.getMessage());
        }
        return null;
    }

    public ResultSet Query(String sql, String[] params) {
        try {
            pstmt = con.prepareStatement(sql);
            int i = 1;
            for (String ele : params) {
                pstmt.setString(i++, ele);
            }
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error query 1b: " + ex.getMessage());
            return null;
        }
    }

    // INSERT, UPDATE, DELETE
    public int Update(String sql) {
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error query 2a: " + ex.getMessage());
        }
        return 0;
    }

    public int Update(String sql, String[] params) {
        try {
            pstmt = con.prepareStatement(sql);
            int i = 1;
            for (String ele : params) {
                pstmt.setString(i++, ele);
            }
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error query 2b: " + ex.getMessage());
            return 0;
        }
    }
}
