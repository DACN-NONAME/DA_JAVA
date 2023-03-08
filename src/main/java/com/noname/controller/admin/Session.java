/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import javax.servlet.http.HttpSession;

public class Session {

    public boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("admin") != null;
    }

    public boolean Login(HttpSession session, String username, String password) {
        if (username.equals("admin") && password.equals("Noname@2023")) {
            session.setAttribute("admin", "true");
            return true;
        }
        return false;
    }

    public void Logout(HttpSession session) {
        session.removeAttribute("admin");
    }
}
