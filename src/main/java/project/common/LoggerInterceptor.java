package project.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**

* 1. 패키지명 : project.common

* 2. 타입명 : LoggerInterceptor.java

* 3. 작성일 : 2017. 6. 23. 오전 9:32:35

* 4. 작성자 : kim

* 5. 설명 : log용 인터셉터


*/
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	   throws Exception {
	  if (log.isDebugEnabled()) {
	            log.debug("======================================          START         ======================================");
	            log.debug(" Request URI \t:  " + request.getRequestURI());
	        }
	  return super.preHandle(request, response, handler);
	 }
	 
	 @Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	   ModelAndView modelAndView) throws Exception {
	   if (log.isDebugEnabled()) {
	             log.debug("======================================           END          ======================================\n");
	      }
	 }
}
