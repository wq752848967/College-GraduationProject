package com.icephone.util;

import java.util.Map;

import net.sf.json.JSONObject;

public class MapConvertUtils {
	
	public static Map<String,Object> getMapFromString(String str)
	{
		JSONObject  jasonObject = JSONObject.fromObject(str);
		
		return (Map<String,Object>)jasonObject;
	}
}
