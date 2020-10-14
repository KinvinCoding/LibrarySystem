package com.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.mapper.BooksMapper;
import com.core.po.Books;
import com.core.po.Borrows;
import com.core.po.Page;
import com.core.po.Reserve;
import com.core.po.Users;
import com.core.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService {
	@Autowired
	private BooksMapper booksMapper;

	@Override
	public List<Books> getAllBooks(Books book) {
		// TODO Auto-generated method stub
		return booksMapper.getAllBooks(book);
	}

	@Override
	public Books getBook(Integer id) {
		// TODO Auto-generated method stub
		return booksMapper.getBook(id);
	}

	@Override
	public void insertBorrow(Borrows borrow) {
		// TODO Auto-generated method stub
		booksMapper.insertBorrow(borrow);
	}

	@Override
	public List<Borrows> getBorrows(Integer uid) {
		// TODO Auto-generated method stub
		return booksMapper.getBorrows(uid);
	}

	@Override
	public List<Borrows> getBacks(Integer id) {
		// TODO Auto-generated method stub
		return booksMapper.getBacks(id);
	}

	@Override
	public void updateBacks(Integer id) {
		// TODO Auto-generated method stub
		booksMapper.updateBacks(id);
	}

	@Override
	public void insertReserve(Reserve reserve) {
		// TODO Auto-generated method stub
		booksMapper.insertReserve(reserve);
	}

	@Override
	public List<Reserve> getReserveBook(Integer id) {
		// TODO Auto-generated method stub
		return booksMapper.getReserveBook(id);
	}

	@Override
	public Users selectUser(Users user) {
		// TODO Auto-generated method stub
		return booksMapper.selectUser(user);
	}

}
