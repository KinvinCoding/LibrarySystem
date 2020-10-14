package com.core.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.po.Books;
import com.core.po.Borrows;
import com.core.po.Page;
import com.core.po.Reserve;
import com.core.po.Users;
import com.core.service.BooksService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private BooksService booksService;

	@RequestMapping("/index")
	public String toIndex() {
		return "/users/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/jsp/index.jsp";
	}

	@RequestMapping("/show")
	public String toShow(Model model, Books book) {
		List<Books> books = booksService.getAllBooks(book);
		model.addAttribute("books", books);
		return "/users/show";
	}

	@RequestMapping("/borrow")
	public String toBorrow(Model model, Integer id) {
		Books book = booksService.getBook(id);
		System.out.println(book);
		model.addAttribute("book", book);
		return "/users/borrows";
	}

	/**
	 * 差用户id未注入，到时候添加登录功能在补充 /**@return
	 * 
	 */
	@RequestMapping("/insert")
	public String insertBorrow(Borrows borrow, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		System.out.println("id" + borrow);
		borrow.setUid(user.getId());
		Date date = new Date();
		borrow.setStartTime(date);
		borrow.setStatus(0);
		booksService.insertBorrow(borrow);
		// booksService.updateBooks(borrow.getBid());
		return "redirect:/user/back";
	}

	/**
	 * @return 也是注入用户ID，这里先用1
	 */
	@RequestMapping("/back")
	public String getBorrows(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Borrows> borrows = booksService.getBorrows(user.getId());
		model.addAttribute("borrows", borrows);
		return "users/back";
	}

	/**
	 * @return 这里注入session再把1换成session取得的id
	 */
	@RequestMapping("/showBackBook")
	public String showBackBook(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Borrows> backs = booksService.getBacks(user.getId());
		model.addAttribute("backs", backs);
		return "users/showBackBook";
	}

	@RequestMapping("/backBooks")
	public String backBooks(Integer id) {
		booksService.updateBacks(id);
		return "redirect:/user/showBackBook";
	}

	// 预定书籍,注入session后把1换成session的User中id
	@RequestMapping("/reserve")
	public String reserveBooks(Reserve reserve, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		reserve.setUid(user.getId());
		Date date = new Date();
		System.out.println(date);
		reserve.setStartTime(date);
		booksService.insertReserve(reserve);
		return "redirect:/user/showReserveBook";
	}

	/**
	 * @return 到时候注入session，1换成session的id
	 */
	@RequestMapping("/showReserveBook")
	public String showReserveBook(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Reserve> reserveBooks = booksService.getReserveBook(user.getId());
		model.addAttribute("reserveBooks", reserveBooks);
		return "/users/reserveBook";
	}
}