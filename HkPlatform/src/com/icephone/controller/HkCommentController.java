package com.icephone.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.service.CommentsService;
import com.icephone.util.ResponseMapUtil;


@Controller
@RequestMapping("/comment")
public class HkCommentController {

	@Autowired
	private CommentsService cService;
	
	@ResponseBody
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public Map<String,Object> addComment(@RequestParam String hwId,@RequestParam String cContent
			,@RequestParam int cPoint)
	{
		System.out.println("order:"+hwId+"  "+cContent+"  "+cPoint);
		boolean result =  cService.add(hwId, cContent, cPoint);
		if(result)
		{
			return ResponseMapUtil.responseSuccess("success", null);
		}
		else
		{
			return ResponseMapUtil.responseError("error", null);
		}
		
	}
}
