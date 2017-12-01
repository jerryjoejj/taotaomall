package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.pojo.common.EasyUITreeNode;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper mapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = mapper.selectByExample(example);
		
		List<EasyUITreeNode> resultList = new ArrayList<>();
		
		for (TbItemCat itemCat: list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent() ? "closed" : "open");
			resultList.add(node);
			for (int i = 0; i < resultList.size(); i++) {
				System.out.println(resultList.get(i).getText());
			}
		}
		
		
		return resultList;
	}

}
