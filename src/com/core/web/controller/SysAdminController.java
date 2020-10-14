package com.core.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.po.Books;
import com.core.po.Users;
import com.core.service.SysAdminService;

@Controller
@RequestMapping("/sysadmin")
public class SysAdminController {
	@Autowired
	private SysAdminService sysAdminService;

	@RequestMapping("/index")
	public String toIndex() {
		return "sysadmin/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/jsp/index.jsp";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "sysadmin/add";
	}

	@RequestMapping("/show")
	public String getBooks(Model model, Books book) {
		List<Books> books = sysAdminService.getBooks(book);
		model.addAttribute("books", books);
		return "sysadmin/show";
	}

	@RequestMapping("/add")
	public String addBooks(Books book) {
		sysAdminService.addBooks(book);
		return "redirect:/sysadmin/show";
	}

	@RequestMapping("/selById")
	public String selBookById(Model model, Integer id) {
		Books book = sysAdminService.getBookById(id);
		model.addAttribute("book", book);
		return "sysadmin/update";
	}

	@RequestMapping("/update")
	public String updateBooks(Books book) {
		sysAdminService.updateBooks(book);
		return "redirect:/sysadmin/show";
	}

	@RequestMapping("/delete")
	public String deleteBooks(Integer id) {
		sysAdminService.deleteBooks(id);
		return "redirect:/sysadmin/show";
	}

	// 下面部分为user模块
	@RequestMapping("/showUser")
	public String showUser(Model model, Users user) {
		List<Users> users = sysAdminService.getUsers(user);
		model.addAttribute("users", users);
		return "sysadmin/showUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "sysadmin/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(Users user) {
		sysAdminService.addUsers(user);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/selUserById")
	public String selUserById(Model model, Integer id) {
		Users user = sysAdminService.getUserById(id);
		model.addAttribute("user", user);
		return "sysadmin/updateUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(Users user) {
		sysAdminService.updateUser(user);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		sysAdminService.deleteUser(id);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/checkCode")
	@ResponseBody
	public String checkCode(String code) {
		int user = sysAdminService.selectUsers(code);
		if (user != 0) {
			return "1";
		}
		return "0";
	}

}
