package com.core.service;

import java.util.List;

import com.core.po.Admin;
import com.core.po.Borrows;
import com.core.po.Reserve;
import com.core.po.Users;

public interface AdminService {
	// 查询所有申请借阅书籍的同学
	List<Borrows> getBorrows(Borrows borrows);

	// 允许借阅
	void updateBorrows(Integer id);

	// 不允许借阅
	void notAllowBorrows(Integer id);

	// 添加未归还书籍
	void inserBackBooks(Integer id);

	// 查看申请归还的书籍
	List<Borrows> getBackBooks();

	// 同意归还
	void allowBackBook(Integer id);

	// 显示所有用户申请预定书籍
	List<Reserve> getAllReserve();

	// 同意申请预定书籍
	void updateReserveBook(Integer id);

	// 查询管理员
	Admin getAdmin(Users user);

	// 不同意申请预定书籍
	void notAllowReserveBook(Integer id);

	// 添加归还书籍数目，先查询出borrows的id,根据borrows的bid得到book的ID
	int selectBorrowsId(Integer id);

	// 增加书籍数
	void updateBooks(Integer id);

	int selectBooksId(Integer id);

	// 减少书籍数量
	void descBooks(Integer id);

	// 更新归还时间
	void updateBorrowsTime(Borrows borrow);

	// 更新预定结束时间
	void updateReserveTime(Reserve reserve);
}
