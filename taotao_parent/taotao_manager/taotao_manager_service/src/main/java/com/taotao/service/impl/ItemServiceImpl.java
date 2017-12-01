package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.common.EasyUIDataGridResult;
import com.taotao.service.ItemService;

//使用@Service标识为Service类，便于扫描
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		
		//通过主键查询
		//TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		
		TbItem item = null;
		
		//使用example查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//使用criteria对象拼接查询条件
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if(null != list && list.size() > 0) {
			item = list.get(0);
		}
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		PageHelper.startPage(page, rows);
		
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
		
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(info.getTotal());
			
		return result;
	}

}
