package com.newretail.service;

import java.util.List;
import java.util.Map;

import com.newretail.common.utils.JqGridResult;
import com.newretail.pojo.GoodsTable;
import com.newretail.pojo.custom.GoodsTableCustom;

/**
 * 商品管理
 * @author Yongjie
 *
 */
public interface GoodsManagerService {
	/**
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public int addGoodsByGoods(GoodsTable goods) throws Exception;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteGoodsById(String id) throws Exception;
	/**
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public int updateGoodsById(GoodsTable goods) throws Exception;
	/**
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public List<GoodsTable> findGoodsByGoods(GoodsTable goods) throws Exception;
	
	/**
	 * 
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public JqGridResult<GoodsTableCustom> findGoodsByGoods(GoodsTable goods,Map<String,Integer> pages) throws Exception;

	/**
	 * 管理员查找商品
	 * @param goodsCustom
	 * @return
	 * @throws Exception
	 */
	public JqGridResult<GoodsTableCustom> findGoodsByAdminGoods(GoodsTableCustom goodsCustom,Map<String,Integer> pages) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoodsTable findGoodsById(String id) throws Exception;
	
}
