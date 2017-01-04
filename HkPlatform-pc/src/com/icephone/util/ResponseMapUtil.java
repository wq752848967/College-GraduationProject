package com.icephone.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duhw
 * @date:2015年9月27日 下午6:30:02
 *
 */
public class ResponseMapUtil
{
	public static Map<String, Object> responseSuccess(String message,Object o)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("success", true);
		map.put("data", o);
		return map;
	}

	public static Map<String, Object> responseError(String message,Object o)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("success", false);
		map.put("data", o);
		return map;
	}
}
