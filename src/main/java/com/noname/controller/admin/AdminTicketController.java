/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBTicket;
import com.noname.model.Ticket;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminTicketController {

    Session ss = new Session();
    DBTicket dbTicket = new DBTicket();

    @RequestMapping(value = "/admin/tickets")
    public String Tickets(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("tickets", dbTicket.GetTickets());
            return "admin/tickets";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/ticket")
    public String Ticket(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Ticket t = null;
            try {
                t = dbTicket.GetTicket(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (t != null) {
                model.addAttribute("main_title", "Chỉnh sửa Giá vé #" + t.getType());
                model.addAttribute("ticket", t);
                return "admin/ticket";
            } else {
                return "redirect:/admin/tickets";
            }
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/ticket", method = RequestMethod.POST)
    public String TicketProcess(HttpSession session, Ticket ticket, Model model) {
        if (ss.isLoggedIn(session)) {
            if (ticket.getId() != 0) {
                dbTicket.UpdateTicket(ticket);
                return "redirect:/admin/ticket?id=" + ticket.getId();
            }
            return "redirect:/admin/tickets";
        }
        return "redirect:/admin/login";
    }
}
