package com.icephone.util;

import java.util.Calendar;

public class IdProviderUtils {

	
	
	
	public static String getOrderId()
	{
		String orderId = "ORDER";
		orderId = orderId+getIdNumber();
		return orderId;
	}
	public static String getFundRecordId()
	{
		String fundId = "FUND";
		fundId = fundId+getIdNumber();
		return fundId;
	}
	public static String getRepairId()
	{
		String repairId = "REPAIR";
		repairId = repairId+getIdNumber();
		return repairId;
	}
	public static String getHworkId()
	{
		String repairId = "HWORK";
		repairId = repairId+getIdNumber();
		return repairId;
	}
	public static String getUSERId()
	{
		String repairId = "USER";
		repairId = repairId+getIdNumber();
		return repairId;
	}
	
	private static String getIdNumber()
	{
		String Id = "";
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int mill = cal.get(Calendar.SECOND);
		int x=(int)(Math.floor(Math.random()*10000));
		Id = Id+year+month+day+hours+min+mill+x+"";
		return Id;
	}
}
