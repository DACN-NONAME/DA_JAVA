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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author phatv
 */
public class Transaction {

    Connection conn = null;
    private Statement stmt;
    private PreparedStatement pstmt = null;

    public void begin() throws SQLException {
        conn = DriverManager.getConnection(Utils.DB_MYSQL);
        conn.setAutoCommit(false);
        stmt = conn.createStatement();
    }

    public void commit() throws SQLException {
        conn.commit();
        finish();
    }

    public void rollback() {
        try {
            conn.rollback();
            finish();
        } catch (SQLException ex) {
            System.out.println("Error rollback: " + ex.toString());
        }
    }

    public void finish() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error close transaction: " + ex.getMessage());
        }
    }

    // SELECT
    public ResultSet Query(String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }

    public ResultSet Query(String sql, String[] params) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        int i = 1;
        for (String ele : params) {
            pstmt.setString(i++, ele);
        }
        return pstmt.executeQuery();
    }

    // INSERT, UPDATE, DELETE
    public int Update(String sql) throws SQLException {
        return stmt.executeUpdate(sql);
    }

    public int UpdateStmt(String sql) throws SQLException {
        return stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public int Update(String sql, String[] params) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        int i = 1;
        for (String ele : params) {
            pstmt.setString(i++, ele);
        }
        return pstmt.executeUpdate();
    }

    public int UpdatePstmt(String sql, String[] params) throws SQLException {
        pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        int i = 1;
        for (String ele : params) {
            pstmt.setString(i++, ele);
        }
        return pstmt.executeUpdate();
    }

    public int GetIdStmt() throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public int GetIdPstmt() throws SQLException {
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
