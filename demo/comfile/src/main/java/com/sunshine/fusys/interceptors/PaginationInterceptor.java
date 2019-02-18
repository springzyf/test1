package com.sunshine.fusys.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sunshine.fusys.common.ParsePagination;

/**
 * 
 * 创建人：fantasy <br>
 * 创建时间：2013-12-2 <br>
 * 功能描述： 分页拦截器<br>
 */
public class PaginationInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(PaginationInterceptor.class);

	private int pageSize = 15;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ParsePagination pp = new ParsePagination(request);
		int ps = this.pageSize;
		int p = 1;
		if (pp.getPageSize() != 0) {
			ps = pp.getPageSize();
		}
		if (pp.getPage() != 1) {
			p = pp.getPage();
		}
		LOG.info("pageSize:{},page: {}", ps, p);
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}