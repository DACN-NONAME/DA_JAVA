/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.database;

import com.noname.config.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return DriverManager.getConnection(Utils.DB_MYSQL);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error db: " + ex.toString());
            return null;
        }
    }

    public DB() {
//        con = getConnection();
    }

    private void begin() {
        try {
            con = getConnection();
            stmt = con.createStatement();
            pstmt = null;
        } catch (SQLException ex) {
            System.out.println("Error connecting to database.");
        }
    }

    private void finish() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error close db: " + ex.getMessage());
        }
    }

    // SELECT
    public List Query(String sql) {
        try {
            begin();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnLabel(i), rs.getObject(i));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error query 1a: " + ex.getMessage());
        } finally {
            finish();
        }
        return null;
    }

    public List Query(String sql, String[] params) {
        try {
            begin();
            pstmt = con.prepareStatement(sql);
            int i = 1;
            for (String ele : params) {
                pstmt.setString(i++, ele);
            }
//            return pstmt.executeQuery();

            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);
                for (i = 1; i <= columns; ++i) {
                    row.put(md.getColumnLabel(i), rs.getObject(i));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error query 1b: " + ex.getMessage());
            return null;
        } finally {
            finish();
        }
    }

    // INSERT, UPDATE, DELETE
    public int Update(String sql) {
        try {
            begin();
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error query 2a: " + ex.getMessage());
        } finally {
            finish();
        }
        return 0;
    }

    public int Update(String sql, String[] params) {
        try {
            begin();
            pstmt = con.prepareStatement(sql);
            int i = 1;
            for (String ele : params) {
                pstmt.setString(i++, ele);
            }
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error query 2b: " + ex.getMessage());
            return 0;
        } finally {
            finish();
        }
    }
}
