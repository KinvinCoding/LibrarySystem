package com.core.po;

import java.util.List;

public class Page
{
	
	//�ܼ�¼��
	private int count;
	//��ҳ��
	private int totalPage;
	//�����
	List<Books> list;
	
	
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	public List<Books> getList()
	{
		return list;
	}
	public void setList(List<Books> list)
	{
		this.list = list;
	}
	@Override
	public String toString()
	{
		return "Page [count=" + count + ", totalPage=" + totalPage + ", list=" + list + "]";
	}

}
