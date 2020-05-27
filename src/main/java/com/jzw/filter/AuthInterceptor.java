package com.jzw.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jzw.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter{
 public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler
) throws Exception{
	HandlerMethod handlerMethod=(HandlerMethod) handler;
	//获取请求需要执行的方法名
	String methodName=handlerMethod.getMethod().getName();
	//判断当前请求是否和登录操作相关
	if(!methodName.equals("index")&&!methodName.equals("login")){
		HttpSession session=request.getSession(true);
		User loginUser=(User) session.getAttribute("loginUser");
				if(loginUser==null){
					response.sendRedirect(request.getContextPath()+"/");
				}
		
	}
	return super.preHandle(request, response, handler); 
 }
}
