/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.user;

import com.noname.config.Utils;
import com.noname.database.DBBooking;
import com.noname.database.DBFilm;
import com.noname.database.DBSchedule;
import com.noname.database.DBTicket;
import com.noname.database.DBUser;
import com.noname.model.Booking;
import com.noname.model.Booking_detail;
import com.noname.model.Film;
import com.noname.model.Ticket;
import com.noname.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phatv
 */
@Controller
public class UserController {

    DBBooking dbBooking = new DBBooking();
    DBFilm dbFilm = new DBFilm();
    DBSchedule dbSchedule = new DBSchedule();
    DBTicket dbTicket = new DBTicket();
    DBUser dbUser = new DBUser();

    @RequestMapping(value = "/profile")
    public String Profile(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        model.addAttribute("count_bookings", dbBooking.GetCountBookingsByUserId(u.getId()));
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String UpdateProfile(HttpSession session, @ModelAttribute() User user, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        user.setId(u.getId());
        user.setEmail(u.getEmail());
        if (dbUser.UpdateUser(user)) {
            session.setAttribute("user", user);
        }
        return "profile";
    }

    @RequestMapping(value = "/profile/changepass")
    public String UpdateProfilePassword(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile/changepass", method = RequestMethod.POST)
    public String UpdateProfilePassword(HttpSession session, @ModelAttribute() User user, @RequestParam("password2") String password2, @RequestParam("repassword2") String repassword2, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        u = dbUser.GetUser(u.getId());
        if (u.getPassword().equals(Utils.SHA1(user.getPassword()))) {
            if (password2.equals(repassword2)) {
                dbUser.ChangePass(u.getId(), password2);
                return "redirect:/profile";
            } else {
                model.addAttribute("msg", "Mật khẩu nhập lại không đúng!");
            }
        } else {
            model.addAttribute("msg", "Mật khẩu cũ không đúng!");
        }
        return "profile";
    }

    @RequestMapping(value = "/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/history")
    public String History(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        User u = (User) session.getAttribute("user");
        model.addAttribute("bookings", dbBooking.GetBookingsByUserId(u.getId()));

        return "history";
    }

    @RequestMapping(value = "/booking-detail")
    public String BookingDetail(@RequestParam(required = false) String id, Model model) {
        try {
            int bid = Integer.parseInt(id);
            Booking b = dbBooking.GetBooking(bid);
            if (b == null) {
                return "redirect:/";
            }
            Film f = dbFilm.GetFilm(b.getFilm_id());
            model.addAttribute("created_at", b.getCreated_at().split(" ")[0]);
            model.addAttribute("title", "Thanh toán vé phim " + f.getName());
            model.addAttribute("film", f);
            model.addAttribute("schedule", dbSchedule.GetSchedule(b.getSchedule_id()));

            List<Ticket> tickets = dbTicket.GetTickets();
            List<Booking_detail> listSeats = dbBooking.GetBookingDetailsByBookingId(bid);
            List<Ticket> listSeat1 = new ArrayList<>();
            List<Ticket> listSeat2 = new ArrayList<>();
            List<Ticket> listSeat3 = new ArrayList<>();
            int total_price = 0;
            for (Booking_detail ele : listSeats) {
                Ticket t = new Ticket();
                String code_seat = ele.getSeat();
                t.setSeat(code_seat);
                char c_row = code_seat.charAt(0);
                if ('A' <= c_row && c_row <= 'D') {
                    total_price += tickets.get(0).getPrice();
                    listSeat1.add(t);
                } else if ('E' <= c_row && c_row <= 'H') {
                    total_price += tickets.get(1).getPrice();
                    listSeat2.add(t);
                } else if (c_row == 'J') {
                    total_price += tickets.get(2).getPrice();
                    listSeat3.add(t);
                }
            }
            model.addAttribute("tickets", tickets);
            model.addAttribute("seats1", listSeat1);
            model.addAttribute("seats2", listSeat2);
            model.addAttribute("seats3", listSeat3);
            model.addAttribute("total_price", String.format("%,d", total_price) + " đ");

            return "booking-detail";
        } catch (NumberFormatException ex) {
            return "redirect:/";
        }
    }
}
