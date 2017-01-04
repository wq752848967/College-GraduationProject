package com.icephone.util;

public class Constants {

	//usertype
	public static final int USER_TYPE_USER = 1;
	public static final int USER_TYPE_WORK = 2;
	
	//user status
	public static final int USER_STATUS_NOMAL = 11;
	public static final int USER_STATUS_PROHIBIT = 12;
	
	
	
	//response info
	
	public static final String USER_STSTUS_NOT_NOMAL = "10001";
	public static final String HWORK_INFO_ERROR = "10002";
	
	
	//hworks status
	public static final int HWORK_STATUS_USEFUL = 210;
	public static final int HWORK_STATUS_WORKING = 211;
	public static final int HWORK_STATUS_COMMENTS = 212;
	public static final int HWORK_STATUS_ALL = 213;
	//hworks apply status
	public static final int HWORK_APPLY_STATUS_USEFUL = 220;
	public static final int HWORK_APPLY_STATUS_SUSPEND = 221;
	
	//hworks collection status
	public static final int HWORK_COLLECTION_STATUS_USEFUL = 230;
	
	//repair Ststus
	public static final int REPAIR_WAITE_REPAIR = 311;
	public static final int REPAIR_REPAIRING = 312;
	public static final int REPAIR_COMPLETE = 313;
	
	//login result 
	public static final String LOGIN_FAIL_NO_USER = "11";
	public static final String LOGIN_FAIL_USER_STATUS_ERROR = "12";
	public static final String LOGIN_FAIL_USER_PSW_ERROR = "13";
}
