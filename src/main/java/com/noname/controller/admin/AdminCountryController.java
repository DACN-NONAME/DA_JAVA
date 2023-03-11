/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBCountry;
import com.noname.model.Country;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCountryController {

    DBCountry dbCountry = new DBCountry();
    Session ss = new Session();

    @RequestMapping(value = "/admin/countries")
    public String Countries(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("countries", dbCountry.GetCountries());
            return "admin/countries";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/country")
    public String Country(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Country c = null;
            try {
                c = dbCountry.GetCountry(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                model.addAttribute("main_title", "Chỉnh sửa Quốc gia #" + c.getId());
            } else {
                c = new Country();
                c.setId(0);
                model.addAttribute("main_title", "Thêm mới Quốc gia");
            }
            model.addAttribute("country", c);
            return "admin/country";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/country", method = RequestMethod.POST)
    public String CountryProcess(HttpSession session, Country country, Model model) {
        if (ss.isLoggedIn(session)) {
            if (country.getId() == 0) {
                dbCountry.InsertCountry(country);
            } else {
                dbCountry.UpdateCountry(country);
                return "redirect:/admin/country?id=" + country.getId();
            }
            return "redirect:/admin/countries";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/country/delete")
    public String CountryDelete(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Country c = null;
            try {
                c = dbCountry.GetCountry(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                dbCountry.DeleteCountry(c.getId());
            }
            return "redirect:/admin/countries";
        }
        return "redirect:/admin/login";
    }
}
