package com.dzwz.shop.service;


import com.dzwz.shop.dao.ForderDao;
import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Sorder;


public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {
	
	 public ForderDao forderDao;
	 
	 

	public void setForderDao(ForderDao forderDao) {
		this.forderDao = forderDao;
	}


	/**
	 * 计算出总价格
	 * @author zrui
	 * @time 2015年9月8日16:51:12
	 * @vserion v.0.1
	 * 
	 */
	@Override
	public Double totalPrice(Forder forder) {
		Double totalPrice = 0.0;
		for(Sorder sorder : forder.getSorders() ){
			totalPrice +=sorder.getPrice()*sorder.getNumber();
		}
		return totalPrice;
	}
	
	
	/**
	 * 更新状态
	 * @author zrui
	 * @time 2015年9月8日16:51:12
	 * @vserion v.0.1
	 * 
	 */
	@Override
	public void updateForder(int uid, int sid) {
		forderDao.updateForder(uid, sid);
	}
	
}
