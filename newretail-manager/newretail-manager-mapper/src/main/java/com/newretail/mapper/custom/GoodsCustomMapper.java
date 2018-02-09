/**
 * Project Name:newretail-manager-mapper
 * File Name:GoodsCustomMapper.java
 * Package Name:com.newretail.mapper.custom
 * Date:2017年10月18日下午11:59:56
 * Copyright (c) 2017, campuspp.com All Rights Reserved.
 *
*/

package com.newretail.mapper.custom;

import java.util.List;

import com.newretail.pojo.custom.GoodsTableCustom;

/**
 * ClassName:GoodsCustomMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年10月18日 下午11:59:56 <br/>
 * @author   Yongjie
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface GoodsCustomMapper {
	/**
	 * 
	 * findGoodsByCustom:(这里用一句话描述这个方法的作用). <br/>
	 * 根据用户Id查询
	 * @author Yongjie
	 * @param id
	 * @return
	 * @since JDK 1.8
	 */
	public List<GoodsTableCustom> findGoodsByCustom(String userId);
	/**
	 * 
	 * findGoodsByCustomOrderByLastTime:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(根据时间排序).<br/>
	 *
	 * @author Yongjie
	 * @param goodsCustom
	 * @return
	 * @since JDK 1.8
	 */
	public List<GoodsTableCustom> findGoodsByCustomOrderByLastTime(GoodsTableCustom goodsCustom);
	/**
	 * 
	 * findGoodsByCustomOrderBySales:(). <br/>
	 * TODO(根据销量排序).<br/>
	 *
	 * @author Yongjie
	 * @param goodsCustom
	 * @return
	 * @since JDK 1.8
	 */
	public List<GoodsTableCustom> findGoodsByCustomOrderBySales(GoodsTableCustom goodsCustom);

	/**
	 * 管理员查询数据
	 * @param goodsCustom
	 * @return
	 */
	public List<GoodsTableCustom> findGoodsByCustomOrderByAdmin(GoodsTableCustom goodsCustom);
	
	/**
	 * 查询
	 * @param goodsCustom
	 * @return
	 */
	public List<GoodsTableCustom> findGoodsByCustomOrderByGoodsCustom(GoodsTableCustom goodsCustom);
	
	/**
	 * 查询商品详情，根据商品ID
	 * @param goodsCustom
	 * @return
	 */
	public List<GoodsTableCustom> findGoodsDetailByGoodsCustom(GoodsTableCustom goodsCustom);
	
	
	
}

