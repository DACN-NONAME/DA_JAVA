/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.user;

import com.noname.config.Utils;
import com.noname.database.DBUser;
import com.noname.model.User;
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
public class AuthenticationController {

    DBUser dbUser = new DBUser();

    @RequestMapping(value = "/sign-in")
    public String SignIn(Model model) {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public String SignInProcess(HttpSession session, @RequestParam(required = false) String url, @ModelAttribute() User user, Model model) {
        if (dbUser.Login(user.getEmail(), user.getPassword())) {
            session.setAttribute("user", dbUser.GetUserByEmail(user.getEmail()));
            if (url != null && !url.equals("")) {
                return "redirect:" + Utils.URLDecode(url);
            }
            return "redirect:/";
        }
        model.addAttribute("msg", "Tài khoản không chính xác!");
        return "sign-in";
    }

    @RequestMapping(value = "/sign-up")
    public String SignUp(Model model) {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String SignUpProcess(HttpSession session, @ModelAttribute() User user, @RequestParam("password2") String password2, Model model) {
//        System.out.println("user: " + user.getEmail());
//        System.out.println("pass2: " + password2);
        if (user.getPassword().equals(password2)) {
            int is_reg = dbUser.Register(user);
            if (is_reg == 1) {
                session.setAttribute("user", dbUser.GetUserByEmail(user.getEmail()));
                return "redirect:/";
            } else {
                model.addAttribute("msg", is_reg == 0 ? "Email đã tồn tại!" : "Có lỗi xảy ra, vui lòng thử lại!");
            }
        } else {
            model.addAttribute("msg", "Mật khẩu nhập lại không trùng khớp!");
        }
        return "sign-up";
    }
}
