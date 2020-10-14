package com.core.mapper;

import java.util.List;

import com.core.po.Books;
import com.core.po.SysAdmin;
import com.core.po.Users;

public interface SysAdminMapper {
	// ��ѯ����ͼ��
	List<Books> getBooks(Books book);

	// ����ͼ��
	void addBooks(Books book);

	// ��ѯͼ�����id
	Books getBookById(Integer id);

	// �޸�ͼ��
	void updateBooks(Books book);

	// ɾ��ͼ��
	void deleteBooks(Integer id);

	// ��ѯ�����û�
	List<Users> getUsers(Users user);

	// �����û�
	void addUsers(Users user);

	// ����id���û�
	Users getUserById(Integer id);

	// �޸��û�
	void updateUser(Users user);

	// ɾ���û�
	void deleteUser(Integer id);

	// ��ѯϵͳ����Ա
	SysAdmin getSysAdmin(Users user);

	// ��ѯ�û��Ƿ����
	int selectUsers(String code);
}
