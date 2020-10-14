package com.core.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.po.Borrows;
import com.core.po.Reserve;
import com.core.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("/index")
	public String toIndex() {
		return "/admin/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/jsp/index.jsp";
	}

	@RequestMapping("/show")
	public String toshow(Model model, Borrows borrow) {
		List<Borrows> borrows = adminService.getBorrows(borrow);
		for (Borrows borrows2 : borrows) {
			System.out.println(borrows2);
		}
		model.addAttribute("borrows", borrows);
		return "/admin/show";
	}

	@RequestMapping("/allow")
	public String allowBorrow(Integer id) {
		// 审批，增加未归还书籍
		adminService.updateBorrows(id);
		adminService.inserBackBooks(id);
		// 书籍数目减1
		int booksId = adminService.selectBooksId(id);
		adminService.descBooks(booksId);
		return "redirect:/admin/show";
	}

	@RequestMapping("/notAllow")
	public String notAllow(Integer id) {
		adminService.notAllowBorrows(id);
		// 更新结束时间
		Date endTime = new Date();
		Borrows borrow = new Borrows();
		borrow.setId(id);
		borrow.setEndTime(endTime);
		adminService.updateBorrowsTime(borrow);
		return "redirect:/admin/show";
	}

	@RequestMapping("/backBooks")
	public String getBackBooks(Model model) {
		List<Borrows> backBooks = adminService.getBackBooks();
		model.addAttribute("backBooks", backBooks);
		return "/admin/showBackBook";
	}

	@RequestMapping("/allowBackBook")
	public String allowBackBook(Integer id) {
		adminService.allowBackBook(id);
		int borrowsId = adminService.selectBorrowsId(id);
		int booksId = adminService.selectBooksId(id);
		// 书籍数目加1
		adminService.updateBooks(booksId);
		// 更新归还时间
		Date endTime = new Date();
		Borrows borrow = new Borrows();
		borrow.setId(borrowsId);
		borrow.setEndTime(endTime);
		adminService.updateBorrowsTime(borrow);
		return "redirect:/admin/backBooks";
	}

	// 获得所有预定书籍信息
	@RequestMapping("/showReserveBook")
	public String showReserveBook(Model model) {
		List<Reserve> allReserves = adminService.getAllReserve();
		model.addAttribute("allReserves", allReserves);
		return "/admin/showReserveBook";
	}

	// 允许预定书籍信息
	@RequestMapping("/allowReserveBook")
	public String allowReserveBook(Integer id) {
		adminService.updateReserveBook(id);
		// 预定处理时间
		Date endTime = new Date();
		Reserve reserve = new Reserve();
		reserve.setId(id);
		reserve.setEndTime(endTime);
		adminService.updateReserveTime(reserve);
		return "redirect:/admin/showReserveBook";
	}

	// 允许预定书籍信息
	@RequestMapping("/notAllowReserveBook")
	public String notAllowReserveBook(Integer id) {
		adminService.notAllowReserveBook(id);
		Date endTime = new Date();
		Reserve reserve = new Reserve();
		reserve.setId(id);
		reserve.setEndTime(endTime);
		adminService.updateReserveTime(reserve);
		return "redirect:/admin/showReserveBook";
	}
}
