package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.common.EasyUIDataGridResult;

public interface ItemService {

	public TbItem getItemById(Long itemid);
	
	public EasyUIDataGridResult getItemList(int page, int rows);

}
