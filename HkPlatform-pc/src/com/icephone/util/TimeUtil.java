package com.icephone.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeUtil
{
	/***
	 * 
	 * @Title: getTimeNow
	 * @TitleExplain: 获取Timestamp格式当前时间
	 * @Description: TODO
	 * @param:
	 * @return: Timestamp
	 * @version:
	 * @author: ZhangYu
	 */
	public static Timestamp getTimeNow()
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}

	/***
	 * 
	 * @Title: getTimeString
	 * @TitleExplain:获取17位String格式当前时间
	 * @Description: TODO
	 * @param:
	 * @return: String
	 * @version:
	 * @author: ZhangYu
	 */
	public static String getTimeString()
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		return dateFormat.format(timestamp);
	}
}
