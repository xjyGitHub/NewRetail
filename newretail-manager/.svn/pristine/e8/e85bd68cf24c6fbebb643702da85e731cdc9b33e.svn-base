package com.newretail.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.mapper.GoodsCatTableMapper;
import com.newretail.pojo.GoodsCatTable;
import com.newretail.pojo.GoodsCatTableExample;
import com.newretail.pojo.GoodsCatTableExample.Criteria;
import com.newretail.pojo.custom.GoodsCatData;
import com.newretail.service.GoodsCatService;

@Service("goodsCatService")
public class GoodsCatServiceImpl implements GoodsCatService {

	@Autowired
	private GoodsCatTableMapper goodsCatTableMapper;
	
	@Override
	public List<GoodsCatData> findAllGoodsCat() {
		GoodsCatTableExample goodsCatTableExample = new GoodsCatTableExample();
		Criteria criteria = goodsCatTableExample.createCriteria();
		criteria.andIdNotEqualTo(0L);
		List<GoodsCatTable> goodsCatTables = goodsCatTableMapper.selectByExample(goodsCatTableExample);
		ArrayList<GoodsCatData> goodsCatDataList = new ArrayList<GoodsCatData>();
		for(GoodsCatTable goodsCatTable:goodsCatTables) {
			GoodsCatData goodsCatData = new GoodsCatData();
			goodsCatData.setGoodsId(Integer.parseInt(goodsCatTable.getId().toString()));
			goodsCatData.setGoodsName(goodsCatTable.getId().toString());
			goodsCatDataList.add(goodsCatData);
		}
		
		return goodsCatDataList;
	}

	@Override
	public List<GoodsCatTable> findAllGoodsCatTable() {
		GoodsCatTableExample goodsCatTableExample = new GoodsCatTableExample();
		Criteria criteria = goodsCatTableExample.createCriteria();
		criteria.andIdNotEqualTo(0L);
		return goodsCatTableMapper.selectByExample(goodsCatTableExample);
	
	}

}
