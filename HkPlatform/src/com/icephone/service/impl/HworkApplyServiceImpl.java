package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.CommentsDao;
import com.icephone.dao.HworkApplyDao;
import com.icephone.dao.HworkDao;
import com.icephone.dao.OrdersDao;
import com.icephone.dao.UserDao;
import com.icephone.model.GenApplyer;
import com.icephone.model.HkApplyDetial;
import com.icephone.pojo.Comments;
import com.icephone.pojo.HkApply;
import com.icephone.pojo.Hworks;
import com.icephone.pojo.Orders;
import com.icephone.pojo.Users;
import com.icephone.service.HworkApplyService;
import com.icephone.util.Constants;


@Service
public class HworkApplyServiceImpl implements HworkApplyService {

	
	
	@Autowired
	private HworkApplyDao happlyDao;
	@Autowired
	private HworkDao hworkDao;
	
	@Autowired 
	private OrdersDao ordersDao;
	@Autowired
	private UserDao  userDao;
	
	@Autowired
	private CommentsDao  commentsDao;
	
	@Override
	public boolean addHworkApply(HkApply hkApply) {
		happlyDao.add(hkApply);
		return true;
	}

	@Override
	public HkApplyDetial getApplyDetial(String hwId) {
		
		
		System.out.println("hwId:"+hwId);
		//先获取详细信息
		Hworks hwork = hworkDao.getById(Hworks.class, hwId);
		
		
		
		
		//初始化数据
		HkApplyDetial applyDetial = new HkApplyDetial(hwork);
		
		
		//根据状态判别
		if(hwork.getHwStatusCode()==Constants.HWORK_STATUS_USEFUL){
			//申请中
			//在获取申请者列表
			List<HkApply> applyList = happlyDao.getListByHwId(hwId);
			ArrayList<GenApplyer> list = new ArrayList<GenApplyer>();
			for(int i=0;i<applyList.size();i++)
			{
				HkApply apply = applyList.get(i);
				Users user = userDao.getUserById(apply.getUId());
				GenApplyer applyer = new GenApplyer(user.getUId(),user.getUName(), apply.getHaDate(), user.getUPoints());
				list.add(applyer);
			}
			applyDetial.setApplyers(list);
		}
		else{
			//获取接单信息
			//getter order
			
			List list = ordersDao.getOrderByHwId(hwId);
			if(list==null||list.size()==0){
				
			}
			else{
				Orders order = (Orders)list.get(0);
				applyDetial.setOrder(order);
				//getter worker info
				Users worker = userDao.getById(Users.class, order.getUWorkId());
				worker.setUPsw(null);
				applyDetial.setWorker(worker);
			}
			
		}
		if(hwork.getHwStatusCode()==Constants.HWORK_STATUS_COMPLETE ){
			List list = commentsDao.getCommentByHwId(hwId);
			if(list!=null&&(list.size()>0)){
				Comments comment = (Comments)list.get(0);
				applyDetial.setComments(comment);
			}
		}
		
		
		
		
		return applyDetial;
	}

	@Override
	public boolean updateApply(String hwId, int statusCode) {
		List applyList = happlyDao.getListByHwId(hwId);
		HkApply apply = null;
		for(int i=0;i<applyList.size();i++){
			apply = (HkApply)applyList.get(i);
			apply.setHaStatusCode(statusCode);
			happlyDao.update(apply);
		}
		return true;
	}
}
