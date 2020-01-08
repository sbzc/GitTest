package cn.hlxy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		System.out.println("pre="+url);
		if("/fSpringMVC01/userLogin".equals(url)) {
			return true;
		}else {
          Object obj = request.getSession().getAttribute("user");
          if(obj!=null) {
        	  return true;
          }
		}
		response.sendRedirect("/fSpringMVC01/login.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(ex.getMessage());
	}

}
