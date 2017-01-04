package com.icephone.util;

import java.util.ArrayList;
import java.util.List;

public class Page
{
	private int maxPage;

	public int getMaxPage()
	{
		return maxPage;
	}

	public void setMaxPage(int maxPage)
	{
		this.maxPage = maxPage;
	}

	public List getPageList(List list, int pageNow, int pageSize)
	{
		maxPage = list.size() / pageSize + 1;
		if (pageNow < 1)
			pageNow = 1;
		if (pageNow > maxPage)
			pageNow = maxPage;
		List res = new ArrayList();
		for (int i = (pageNow - 1) * pageSize; i < pageNow * pageSize; i++)
		{
			if (i < list.size())
				res.add(list.get(i));
		}
		return res;
	}
}
