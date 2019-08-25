package com.mj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

	//页面请求
	@GetMapping("/socket/{cid}")
	@ResponseBody
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav=new ModelAndView("/socket");
		mav.addObject("cid", cid);

		return mav;
	}

	@GetMapping("/socket1")
	public ModelAndView socket1() {
		ModelAndView mav=new ModelAndView("/socket");

		return mav;
	}


	//推送数据接口
	@ResponseBody
	@RequestMapping("/socket/push/{cid}")
	public String pushToWeb(@PathVariable String cid,String message) {
		try {
			WebSocketServer.sendInfo(message,cid);
		} catch (IOException e) {
			e.printStackTrace();
			return cid+"#"+e.getMessage();
		}  
		return "推送成功"+cid;
	}

	@RequestMapping("/66")
	@ResponseBody
	public String xx(){
		return "666";
	}
} 
