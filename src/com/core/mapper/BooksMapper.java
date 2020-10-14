package com.core.mapper;

import java.util.List;

import com.core.po.Books;
import com.core.po.Borrows;
import com.core.po.Page;
import com.core.po.Reserve;
import com.core.po.Users;

public interface BooksMapper {
	// ��ѯ�����鼮
	List<Books> getAllBooks(Books book);

	int getCount(Books book);

	// �����鼮��Ϣ
	Books getBook(Integer id);

	// ȷ�Ͻ����鼮
	void insertBorrow(Borrows borrow);

	// ��ѯ���ĵ��鼮
	List<Borrows> getBorrows(Integer uid);

	// ��ѯ��Ҫ�黹���鼮
	List<Borrows> getBacks(Integer id);

	// ����黹
	void updateBacks(Integer id);

	// Ԥ����Ϣ
	void insertReserve(Reserve reserve);

	// ��ѯԤ���鼮��Ϣ
	List<Reserve> getReserveBook(Integer id);

	// ��ѯ�Ƿ�����û�
	Users selectUser(Users user);
	// �û���������鼮����
	// void updateBooks(Integer id);
}
