package com.icephone.service.impl;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.CommentsDao;
import com.icephone.dao.HworkDao;
import com.icephone.dao.OrdersDao;
import com.icephone.dao.UserDao;
import com.icephone.pojo.Comments;
import com.icephone.pojo.Hworks;
import com.icephone.pojo.Orders;
import com.icephone.pojo.Users;
import com.icephone.service.CommentsService;
import com.icephone.util.Constants;
import com.icephone.util.TimeUtil;
@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsDao commentDao;
	@Autowired
	private OrdersDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HworkDao hwDao;
	
	public boolean add(String hwId,String cContent,int cPoint){
		List list  = orderDao.getOrderByHwId(hwId);
		
		
		if((list==null)||(list.size()==0)){
			
			return false;
		}
		Orders order = (Orders)list.get(0);
		Users c_User = userDao.getUserById(order.getUCusId());
		Users w_User = userDao.getUserById(order.getUWorkId());
		if((c_User==null)||(w_User==null)){
			return false;
		}
		Comments comment = new Comments(w_User.getUId(),cContent,(double)cPoint,TimeUtil.getTimeNow()
				,c_User.getUName(),w_User.getUId(),hwId);
		
		commentDao.add(comment);
		/*  update user points */
		double old_point = w_User.getUPoints();
		double new_point = old_point*0.9+cPoint*0.1;
		w_User.setUPoints(changeDouble(new_point));
		userDao.update(w_User);
		/* update status */
		//order
		order.setOrderStatusCode(Constants.HWORK_STATUS_COMPLETE);
		orderDao.update(order);
		//hwork
		Hworks work = hwDao.getById(Hworks.class, hwId);
		work.setHwStatusCode(Constants.HWORK_STATUS_COMPLETE);
		hwDao.update(work);
		
		return true;
	}
	public  double changeDouble(Double dou){
        NumberFormat   nf=new  DecimalFormat( "0.0 "); 
        dou = Double.parseDouble(nf.format(dou));
        return dou;
    }
}
