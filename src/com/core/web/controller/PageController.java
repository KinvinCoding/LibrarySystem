package com.core.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.core.po.Admin;
import com.core.po.SysAdmin;
import com.core.po.Users;
import com.core.service.AdminService;
import com.core.service.BooksService;
import com.core.service.SysAdminService;

@Controller
public class PageController {
	@Autowired
	private BooksService bookService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private SysAdminService sysAdminService;

	
	/*
	 * @RequestMapping("/index") public String toIndex() { return "/login"; }
	 */
	
	@RequestMapping("/login")
	public String login(Users user, int loginType, Model model, HttpSession session) {
		// ∆’Õ®”√ªß
		if (loginType == 1) {
			Users users = bookService.selectUser(user);
			if (users != null) {
				session.setAttribute("user", users);
				return "redirect:/user/index";
			} else {
				model.addAttribute("msg", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				return "login";
			}
		} else if (loginType == 2) {
			Admin admin = adminService.getAdmin(user);
			if (admin != null) {
				session.setAttribute("admin", admin);
				return "redirect:/admin/index";
			} else {
				model.addAttribute("msg", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				return "login";
			}
		} else if (loginType == 3) {
			SysAdmin sysAdmin = sysAdminService.getSysAdmin(user);
			if (sysAdmin != null) {
				session.setAttribute("sysAdmin", sysAdmin);
				return "redirect:/sysadmin/index";
			} else {
				model.addAttribute("msg", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				return "login";
			}
		}
		return "login";
	}
}
