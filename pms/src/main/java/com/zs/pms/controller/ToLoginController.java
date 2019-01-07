package com.zs.pms.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.UserQuery;
// 登陆控制器
import com.zs.sm.exception.AppException;
@Controller
public class ToLoginController {
	@Autowired
	UserService us;
	@RequestMapping("tologin.do")
	public String toLogin(){
		
		return "login";
	}
	/**
	 * 验证用户登录
	 * @param query  用户名和密码
	 * @param chkcode  验证码
	 * @param session  会话
	 * @param modelMap  带数据
	 * @return 成功main  失败 login  系统异常error
	 */
	@RequestMapping("login.do")
	public String login(UserQuery query,String chkcode,HttpSession session,ModelMap modelMap) {

		try {

//			   从session中获取验证码图片中的验证信息
			   String code=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
//			   判断
			   if (!code.equals(chkcode)) {
				   modelMap.addAttribute("msg", "验证码输入错误，请重新输入");
				return "login";
			}
//			   验证登陆
			   TUser user=us.queryByLogin(query);
			   //使用session保存
			   session.setAttribute("CUSER", user);
//			   转发到主页面
				return "main";
			}catch (AppException e) {
//				如果为空，表示登陆失败
				modelMap.addAttribute("msg", e.getErrMsg());
				return "login";
			
			}catch (Exception e) {
				e.printStackTrace();
				return "error";
	}
	}

	}


