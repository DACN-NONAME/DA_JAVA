/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.controller.admin;

import com.noname.database.DBCategory;
import com.noname.model.Category;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCategoryController {

    Session ss = new Session();
    DBCategory dbCategory = new DBCategory();

    @RequestMapping(value = "/admin/categories")
    public String Categories(HttpSession session, Model model) {
        if (ss.isLoggedIn(session)) {
            model.addAttribute("categories", dbCategory.GetCategories());
            return "admin/categories";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/category")
    public String Category(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Category c = null;
            try {
                c = dbCategory.GetCategory(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                model.addAttribute("main_title", "Chỉnh sửa Thể loại #" + c.getId());
            } else {
                c = new Category();
                c.setId(0);
                model.addAttribute("main_title", "Thêm mới Thể loại");
            }
            model.addAttribute("category", c);
            return "admin/category";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/category", method = RequestMethod.POST)
    public String CategoryProcess(HttpSession session, Category category, Model model) {
        if (ss.isLoggedIn(session)) {
            if (category.getId() == 0) {
                dbCategory.InsertCategory(category);
            } else {
                dbCategory.UpdateCategory(category);
                return "redirect:/admin/category?id=" + category.getId();
            }
            return "redirect:/admin/categories";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/admin/category/delete")
    public String CategoryDelete(HttpSession session, @RequestParam(required = false) String id, Model model) {
        if (ss.isLoggedIn(session)) {
            Category c = null;
            try {
                c = dbCategory.GetCategory(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
            }
            if (c != null) {
                dbCategory.DeleteCategory(c.getId());
            }
            return "redirect:/admin/categories";
        }
        return "redirect:/admin/login";
    }
}
