package com.taotao.service;

import java.util.List;

import com.taotao.pojo.common.EasyUITreeNode;

/**
 * 展示商品类目
 * @author lma
 *
 */
public interface ItemCatService {

	public List<EasyUITreeNode> getItemCatList(long parentId);
	
}
