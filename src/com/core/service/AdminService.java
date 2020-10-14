package com.core.service;

import java.util.List;

import com.core.po.Admin;
import com.core.po.Borrows;
import com.core.po.Reserve;
import com.core.po.Users;

public interface AdminService {
	// ��ѯ������������鼮��ͬѧ
	List<Borrows> getBorrows(Borrows borrows);

	// �������
	void updateBorrows(Integer id);

	// ���������
	void notAllowBorrows(Integer id);

	// ���δ�黹�鼮
	void inserBackBooks(Integer id);

	// �鿴����黹���鼮
	List<Borrows> getBackBooks();

	// ͬ��黹
	void allowBackBook(Integer id);

	// ��ʾ�����û�����Ԥ���鼮
	List<Reserve> getAllReserve();

	// ͬ������Ԥ���鼮
	void updateReserveBook(Integer id);

	// ��ѯ����Ա
	Admin getAdmin(Users user);

	// ��ͬ������Ԥ���鼮
	void notAllowReserveBook(Integer id);

	// ��ӹ黹�鼮��Ŀ���Ȳ�ѯ��borrows��id,����borrows��bid�õ�book��ID
	int selectBorrowsId(Integer id);

	// �����鼮��
	void updateBooks(Integer id);

	int selectBooksId(Integer id);

	// �����鼮����
	void descBooks(Integer id);

	// ���¹黹ʱ��
	void updateBorrowsTime(Borrows borrow);

	// ����Ԥ������ʱ��
	void updateReserveTime(Reserve reserve);
}
